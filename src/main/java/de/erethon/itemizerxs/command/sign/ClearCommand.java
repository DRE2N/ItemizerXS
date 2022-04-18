package de.erethon.itemizerxs.command.sign;

import de.erethon.bedrock.chat.MessageUtil;
import de.erethon.itemizerxs.command.logic.SignECommand;
import net.kyori.adventure.text.Component;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

public class ClearCommand extends SignECommand {

    public ClearCommand() {
        setCommand("clear");
        setAliases("c");
        setMaxArgs(0);
        setUsage("/ii sign clear");
        setDescription("Löscht alle Reihen");
        setDefaultHelp();
    }

    @Override
    public void onExecute(String[] args, Player player, Sign sign) {
        sign.line(0, Component.empty());
        sign.line(1, Component.empty());
        sign.line(2, Component.empty());
        sign.line(3, Component.empty());

        MessageUtil.sendMessage(player, "&7Der Schildinhalt wurde gelöscht");
    }
}
