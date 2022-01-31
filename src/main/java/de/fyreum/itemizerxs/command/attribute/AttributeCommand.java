package de.fyreum.itemizerxs.command.attribute;

import de.erethon.bedrock.command.ECommand;
import de.fyreum.itemizerxs.command.HelpCommand;
import org.bukkit.command.CommandSender;

public class AttributeCommand extends ECommand {

    public AddCommand addCommand = new AddCommand();
    public RemoveCommand removeCommand = new RemoveCommand();

    public AttributeCommand() {
        setCommand("attribute");
        setAliases("a", "attr");
        setMinArgs(1);
        setMaxArgs(Integer.MAX_VALUE);
        setConsoleCommand(false);
        setPlayerCommand(true);
        setHelp("&6/ii a&ettribute &8- &7&oBefehle rund um Attribute");
        setPermission("itemizerxs.cmd.attribute");

        addSubCommands(addCommand, removeCommand);
    }

    @Override
    public void onExecute(String[] args, CommandSender sender) {
        HelpCommand.sendHelp(getSubCommands(), args, sender);
    }
}
