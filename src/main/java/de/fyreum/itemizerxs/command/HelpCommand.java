package de.fyreum.itemizerxs.command;

import de.erethon.bedrock.chat.MessageUtil;
import de.erethon.bedrock.command.CommandCache;
import de.erethon.bedrock.command.ECommand;
import de.erethon.bedrock.misc.NumberUtil;
import de.fyreum.itemizerxs.ItemizerXS;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        sendHelp(commandCache, args, sender);
    }

    public static void sendHelp(CommandCache commandCache, String[] args, CommandSender sender) {
        List<ECommand> sorted = commandCache.getCommands().stream()
                .filter(command -> command.senderHasPermissions(sender))
                .sorted(Comparator.comparing(ECommand::getCommand))
                .collect(Collectors.toList());

        if (sorted.isEmpty()) {
            MessageUtil.sendMessage(sender, "&cDu hast keine Berechtigung um dies zu tun");
            return;
        }

        ArrayList<ECommand> toSend = new ArrayList<>();

        int page = 1;
        if (args.length == 2) {
            page = NumberUtil.parseInt(args[1], 1);
        }
        int send = 0;
        int max = 0;
        int min = 0;

        int perPage = 5;
        for (ECommand dCommand : sorted) {
            send++;
            if (send >= page * perPage - (perPage - 1) && send <= page * perPage) {
                min = page * perPage - (perPage - 1);
                max = page * perPage;
                toSend.add(dCommand);
            }
        }

        MessageUtil.sendPluginTag(sender, ItemizerXS.inst());
        MessageUtil.sendCenteredMessage(sender, "&4&l[ &6" + min + "-" + max + " &4/&6 " + send + " &4|&6 " + page + " &4&l]");

        for (ECommand dCommand : toSend) {
            MessageUtil.sendMessage(sender, "&b" + dCommand.getCommand() + "&8 - &7" + dCommand.getHelp());
        }
    }
}
