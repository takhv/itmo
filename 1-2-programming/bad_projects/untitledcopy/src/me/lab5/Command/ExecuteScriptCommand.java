package me.lab5.Command;
import me.lab5.Utility.FileHanding;
import me.lab5.Utility.Mode;
import me.lab5.Utility.ModeEnum;

/**
 *
 * @author takhvatulin
 */
public class ExecuteScriptCommand extends AbstractCommand implements Command {
    private FileHanding fileHanding;
    private Mode mode;


    public ExecuteScriptCommand(FileHanding fileHanding, Mode mode) {
        super("execute_script <file_name>", "исполнить скрипт из указанного файла");
        this.fileHanding = fileHanding;
        this.mode = mode;
    }

    @Override
    public boolean execute(String argument){
        fileHanding.setPath(argument.trim());
        mode.setMode(ModeEnum.SCRIPT);
        mode.operatingModeSetting();
        return true;
    }
}