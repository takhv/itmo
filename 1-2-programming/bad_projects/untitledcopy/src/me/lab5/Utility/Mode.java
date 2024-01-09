package me.lab5.Utility;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Mode {
    private Console console;
    private FileHanding fileHanding;
    ModeEnum mode;
    public Mode(Console console, FileHanding fileHanding){
        this.console = console;
        this.fileHanding = fileHanding;
    }

    public void operatingModeSetting() {
        try {
            if (mode.equals(ModeEnum.CONSOLE)) {
                console.consoleReader();
            } else if (mode.equals(ModeEnum.SCRIPT)) {
                fileHanding.operatingTypeSetting();
                setMode(ModeEnum.CONSOLE);
            }
        }catch (IOException e){
            System.out.println("файл не найден");
        }
    }

    public ModeEnum getMode() {
        return mode;
    }

    public void setMode(ModeEnum mode) {
        this.mode = mode;
    }
}
