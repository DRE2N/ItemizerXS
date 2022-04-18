package de.erethon.itemizerxs.command.enchant;

import de.erethon.bedrock.command.ECommand;
import de.erethon.bedrock.misc.InfoUtil;
import org.bukkit.command.CommandSender;

public class EnchantCommand extends ECommand {

    public AddCommand addCommand = new AddCommand();
    public RemoveCommand removeCommand = new RemoveCommand();

    public EnchantCommand() {
        setCommand("enchant");
        setAliases("e");
        setMinArgs(0);
        setMaxArgs(Integer.MAX_VALUE);
        setConsoleCommand(false);
        setPlayerCommand(true);
        setPermission("itemizerxs.cmd.enchant");
        setUsage("/ii enchant [...]");
        setDescription("Befehle rund um Verzauberungen");
        setDefaultHelp();

        addSubCommands(addCommand, removeCommand);
    }

    @Override
    public void onExecute(String[] args, CommandSender sender) {
        InfoUtil.sendListedHelp(sender, getSubCommands());
    }
}
