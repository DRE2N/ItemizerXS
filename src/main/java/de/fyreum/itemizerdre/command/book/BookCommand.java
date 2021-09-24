package de.fyreum.itemizerdre.command.book;

import de.erethon.commons.command.DRECommand;
import de.fyreum.itemizerdre.command.HelpCommand;
import org.bukkit.command.CommandSender;

public class BookCommand extends DRECommand {

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
        setHelp("&6/id b&eook &8- &7&oBefehle rund um Bücher");
        setPermission("itemizerdre.cmd.book");

        addSubCommands(titleCommand, authorCommand, generationCommand, writableCommand);
    }

    @Override
    public void onExecute(String[] args, CommandSender sender) {
        HelpCommand.sendHelp(getSubCommands(), args, sender);
    }
}
