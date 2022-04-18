package de.erethon.itemizerxs.command;

import de.erethon.bedrock.command.CommandCache;
import de.erethon.bedrock.command.ECommand;
import de.erethon.bedrock.misc.InfoUtil;
import org.bukkit.command.CommandSender;

public class HelpCommand extends ECommand {

    private final CommandCache commandCache;

    public HelpCommand(CommandCache commandCache) {
        setCommand("help");
        setAliases("h", "?", "main");
        setMinArgs(0);
        setMaxArgs(1);
        setPlayerCommand(true);
        setConsoleCommand(true);
        setHelp("&6/ii &6h&eelp ([&7page&e]) &8- &7&oKurzbeschreibung aller Befehle");

        this.commandCache = commandCache;
    }

    @Override
    public void onExecute(String[] args, CommandSender sender) {
        InfoUtil.sendListedHelp(sender, commandCache);
    }
}
