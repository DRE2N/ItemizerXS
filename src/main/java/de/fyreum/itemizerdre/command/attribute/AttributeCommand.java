package de.fyreum.itemizerdre.command.attribute;

import de.erethon.commons.command.DRECommand;
import de.fyreum.itemizerdre.command.HelpCommand;
import org.bukkit.command.CommandSender;

public class AttributeCommand extends DRECommand {

    public AddCommand addCommand = new AddCommand();
    public RemoveCommand removeCommand = new RemoveCommand();

    public AttributeCommand() {
        setCommand("attribute");
        setAliases("a", "attr");
        setMinArgs(1);
        setMaxArgs(Integer.MAX_VALUE);
        setConsoleCommand(false);
        setPlayerCommand(true);
        setHelp("&6/id a&ettribute &8- &7&oBefehle rund um Attribute");
        setPermission("itemizerdre.cmd.attribute");

        addSubCommands(addCommand, removeCommand);
    }

    @Override
    public void onExecute(String[] args, CommandSender sender) {
        HelpCommand.sendHelp(getSubCommands(), args, sender);
    }
}
