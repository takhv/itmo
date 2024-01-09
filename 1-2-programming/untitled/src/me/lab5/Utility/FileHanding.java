package me.lab5.Utility;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import me.lab5.Manager.CollectionManager;
import me.lab5.Manager.CommandManager;
import me.lab5.Data.SpaceMarine;
import me.lab5.Exception.ScriptRecursionException;

import java.io.*;
import java.util.*;

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
    Document document = null;

    public enum FileType {
        FILE,
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
            //recursionDefence();
            if (nameScripts.contains(path)) throw new ScriptRecursionException();
            nameScripts.add(path);
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

    public void operatingTypeSetting() throws IOException {
        if(fileType.equals(ModeEnum.FILE)){
            readFile();
        } else {
            scriptReader();
        }
    }

    public void createFile(){
        try {
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.newDocument();

            // Вызываем метод для добавления новой книги

        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        }
    }


    public void addNewSM(SpaceMarine spaceMarine){
        createFile();
        Node root = document.getDocumentElement();


        Element spacemarine = document.createElement("SpaceMarine");

        // create <name>
        Element spacemarinename = document.createElement("name");
        spacemarinename.setTextContent(spaceMarine.getName());
        spacemarine.appendChild(spacemarinename);

        // create <coordinates>
        Element coordinates = document.createElement("coordinates");
        // create <coordinates> --> <x>
        Element x = document.createElement("x");
        x.setTextContent("a"/*String.valueOf(spaceMarine.getCoordinates().getX())*/);
        coordinates.appendChild(x);
        // create <coordinates> --> <y>
        Element y = document.createElement("y");
        y.setTextContent("a"/*String.valueOf(spaceMarine.getCoordinates().getY().toString())*/);
        coordinates.appendChild(y);
        spacemarine.appendChild(coordinates);

        // create <minhealth>
        Element minhealth = document.createElement("minhealth");
        minhealth.setTextContent("a"/*String.valueOf(spaceMarine.getHealth())*/);
        spacemarine.appendChild(minhealth);

        // create <achievement>
        Element achievement = document.createElement("achievement");
        achievement.setTextContent("a"/*spaceMarine.getAchievements()*/);
        spacemarine.appendChild(achievement);

        // create <weapon>
        Element weapon = document.createElement("weapon");
        weapon.setTextContent("a"/*spaceMarine.getWeaponType().name()*/);
        spacemarine.appendChild(weapon);

        // create <meleeweapon>
        Element meleeweapon = document.createElement("meleeweapon");
        meleeweapon.setTextContent("a"/*spaceMarine.getMeleeWeapon().name()*/);
        spacemarine.appendChild(meleeweapon);

        // create <chapter>
        Element chapter = document.createElement("chapter");
        // create <chapter> --> <name>
        Element chaptername = document.createElement("name");
        chaptername.setTextContent("a"/*spaceMarine.getChapter().getName()*/);
        chapter.appendChild(chaptername);
        // create <chapter> --> <marinesCount>
        Element marinesCount = document.createElement("marinesCount");
        marinesCount.setTextContent("a"/*String.valueOf(spaceMarine.getChapter().getMarinesCount())*/);
        chapter.appendChild(marinesCount);
        spacemarine.appendChild(chapter);

        root.appendChild(spacemarine);

        writeToXML(document);
    }


    /**
     * Запись DOM в файл
     */
    public void writeToXML(Document document) throws TransformerFactoryConfigurationError {
        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("spacemarines.xml"));
            tr.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace(System.out);
        }
    }

    public void readFile(){
        try {
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse("spacemarines.xml");

            // Получаем корневой элемент
            Node root = document.getDocumentElement();

            System.out.println("List of spacemarines:");
            System.out.println();
            // Просматриваем все подэлементы корневого
            NodeList spacemarines = root.getChildNodes();
            for (int i = 0; i < spacemarines.getLength(); i++) {
                Node sm = spacemarines.item(i);
                // Если нода не текст - заходим внутрь
                if (sm.getNodeType() != Node.TEXT_NODE) {
                    NodeList smProps = sm.getChildNodes();
                    for(int j = 0; j < smProps.getLength(); j++) {
                        Node smProp = smProps.item(j);
                        // Если нода не текст, то это один из параметров - печатаем
                        if (smProp.getNodeType() != Node.TEXT_NODE) {
                            System.out.println(smProp.getNodeName() + ":" + smProp.getChildNodes().item(0).getTextContent());
                        }
                    }
                    System.out.println("---=== Done! ===---");
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
