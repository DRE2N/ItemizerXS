package de.erethon.itemizerxs.command.attribute;

import de.erethon.bedrock.command.ECommand;
import de.erethon.bedrock.misc.InfoUtil;
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
        setPermission("itemizerxs.cmd.attribute");
        setUsage("/ii attribute [...]");
        setDescription("Befehle rund um Attribute");
        setDefaultHelp();

        addSubCommands(addCommand, removeCommand);
    }

    @Override
    public void onExecute(String[] args, CommandSender sender) {
        InfoUtil.sendListedHelp(sender, getSubCommands());
    }
}
