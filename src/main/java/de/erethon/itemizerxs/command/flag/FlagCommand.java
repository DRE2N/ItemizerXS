package de.erethon.itemizerxs.command.flag;

import de.erethon.bedrock.command.ECommand;
import de.erethon.bedrock.misc.InfoUtil;
import org.bukkit.command.CommandSender;

public class FlagCommand extends ECommand {

    public AddCommand addCommand = new AddCommand();
    public RemoveCommand removeCommand = new RemoveCommand();

    public FlagCommand() {
        setCommand("flag");
        setAliases("f");
        setMinArgs(0);
        setMaxArgs(Integer.MAX_VALUE);
        setConsoleCommand(true);
        setPlayerCommand(true);
        setPermission("itemizerxs.cmd.flag");
        setUsage("/ii flag [...]");
        setDescription("Befehle run um ItemFlags");
        setDefaultHelp();

        addSubCommands(addCommand, removeCommand);
    }

    @Override
    public void onExecute(String[] args, CommandSender sender) {
        InfoUtil.sendListedHelp(sender, getSubCommands());
    }
}
