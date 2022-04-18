package de.erethon.itemizerxs.command.sign;

import de.erethon.bedrock.command.ECommand;
import de.erethon.bedrock.misc.InfoUtil;
import org.bukkit.command.CommandSender;

public class SignCommand extends ECommand {

    public ClearCommand clearCommand = new ClearCommand();
    public SetCommand setCommand = new SetCommand();

    public SignCommand() {
        setCommand("sign");
        setAliases("s");
        setMinArgs(0);
        setMaxArgs(Integer.MAX_VALUE);
        setConsoleCommand(false);
        setPlayerCommand(true);
        setPermission("itemizerxs.cmd.sign");
        setUsage("/ii sign [...]");
        setDescription("Befehle rund um die lore eines Items");
        setDefaultHelp();

        addSubCommands(clearCommand, setCommand);
    }

    @Override
    public void onExecute(String[] args, CommandSender sender) {
        InfoUtil.sendListedHelp(sender, getSubCommands());
    }
}
