package me.lab5.Utility;

//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.exc.StreamWriteException;
//import com.fasterxml.jackson.databind.module.SimpleModule;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import me.lab5.Manager.CollectionManager;
import me.lab5.Manager.CommandManager;
import me.lab5.Data.SpaceMarine;
import me.lab5.Exception.ScriptRecursionException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileHanding {
    public void setCommandManager(CommandManager commandManager){
        this.commandManager = commandManager;
    }
    private CommandManager commandManager;
    private CollectionManager collectionManager;
    private SpaceMarine spaceMarine;
    private SpaceMarinesAsker spaceMarinesAsker;
    private Console console;
    private String path;
    private String envVariable;
    private List<String> nameScripts = new ArrayList<>();
    private FileType fileType;
    private static int callCount = 0;
    private static final int MAX_CC = 2;

    public enum FileType {
        XML_FILE,
        SCRIPT
    }

    public FileHanding(CollectionManager collectionManager, SpaceMarinesAsker spaceMarinesAsker, String envVariable, Console console){
        this.collectionManager = collectionManager;
        this.spaceMarinesAsker = spaceMarinesAsker;
        this.envVariable = envVariable;
        this.console = console;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void scriptReader() throws IOException {
        try {
            callCount = 0;
            recursionDefence();
            /* if (nameScripts.contains(path)) throw new ScriptRecursionException();
            nameScripts.add(path); */
            String[] command;
            FileReader inputFile = new FileReader(path);
            Scanner scriptScanner = new Scanner(new BufferedReader(inputFile));
            if (!scriptScanner.hasNext()) throw new NoSuchElementException();
            Scanner tmpScanner = spaceMarinesAsker.getScanner();
            spaceMarinesAsker.setScanner(scriptScanner);
            while (scriptScanner.hasNextLine()) {
                command = (scriptScanner.nextLine().trim() + " ").split(" ", 2);
                command[1] = command[1].trim();
                commandManager.commandSelection(command);
            }
            spaceMarinesAsker.setScanner(tmpScanner);
            //nameScripts.clear();
        } catch (NoSuchElementException e) {
            System.out.println("Скрипт сломан");
        } catch (ScriptRecursionException e) {
            System.out.println("Повторный вызов скрипта " + path);
        }
    }

    public void recursionDefence() throws ScriptRecursionException {
        callCount++;
        if(callCount > MAX_CC) throw new ScriptRecursionException();
        recursionDefence();
    }

    public void fileReader(){

    }

    public void operatingTypeSetting() throws IOException {
//        if(fileType.equals(FileType.XML_FILE)){
//            fileReader();
//        } else {
//            scriptReader();
//        }
        scriptReader();
    }
}
