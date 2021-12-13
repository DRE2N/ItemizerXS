package de.fyreum.itemizerxs.command.flag;

import de.erethon.commons.command.DRECommand;
import de.fyreum.itemizerxs.command.HelpCommand;
import org.bukkit.command.CommandSender;

public class FlagCommand extends DRECommand {

    public AddCommand addCommand = new AddCommand();
    public RemoveCommand removeCommand = new RemoveCommand();

    public FlagCommand() {
        setCommand("flag");
        setAliases("f");
        setMinArgs(0);
        setMaxArgs(Integer.MAX_VALUE);
        setConsoleCommand(true);
        setPlayerCommand(true);
        setHelp("&6/id f&elag &8- &7&oBefehle run um ItemFlags");
        setPermission("itemizerdre.cmd.flag");

        addSubCommands(addCommand, removeCommand);
    }

    @Override
    public void onExecute(String[] args, CommandSender sender) {
        HelpCommand.sendHelp(getSubCommands(), args, sender);
    }
}
