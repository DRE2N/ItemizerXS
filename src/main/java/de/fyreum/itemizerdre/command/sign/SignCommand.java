package de.fyreum.itemizerdre.command.sign;

import de.erethon.commons.command.DRECommand;
import de.fyreum.itemizerdre.command.HelpCommand;
import org.bukkit.command.CommandSender;

public class SignCommand extends DRECommand {

    public ClearCommand clearCommand = new ClearCommand();
    public SetCommand setCommand = new SetCommand();

    public SignCommand() {
        setCommand("sign");
        setAliases("s");
        setMinArgs(0);
        setMaxArgs(Integer.MAX_VALUE);
        setConsoleCommand(false);
        setPlayerCommand(true);
        setPermission("itemizerdre.cmd.sign");
        setHelp("&6/id s&eign &8- &7&oBefehle rund um die lore eines Items");

        addSubCommands(clearCommand, setCommand);
    }

    @Override
    public void onExecute(String[] args, CommandSender sender) {
        HelpCommand.sendHelp(getSubCommands(), args, sender);
    }
}