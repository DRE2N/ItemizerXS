package de.erethon.itemizerxs.command.book;

import de.erethon.bedrock.command.ECommand;
import de.erethon.bedrock.misc.InfoUtil;
import org.bukkit.command.CommandSender;

public class BookCommand extends ECommand {

    public TitleCommand titleCommand = new TitleCommand();
    public AuthorCommand authorCommand = new AuthorCommand();
    public GenerationCommand generationCommand = new GenerationCommand();
    public WritableCommand writableCommand = new WritableCommand();

    public BookCommand() {
        setCommand("book");
        setAliases("b");
        setMinArgs(0);
        setMaxArgs(Integer.MAX_VALUE);
        setConsoleCommand(false);
        setPlayerCommand(true);
        setPermission("itemizerxs.cmd.book");
        setUsage("/ii book [...]");
        setDescription("Befehle rund um Bücher");
        setDefaultHelp();

        addSubCommands(titleCommand, authorCommand, generationCommand, writableCommand);
    }

    @Override
    public void onExecute(String[] args, CommandSender sender) {
        InfoUtil.sendListedHelp(sender, getSubCommands());
    }
}
