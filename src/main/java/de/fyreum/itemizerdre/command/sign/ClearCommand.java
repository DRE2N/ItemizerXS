package de.fyreum.itemizerdre.command.sign;

import de.erethon.commons.chat.MessageUtil;
import de.fyreum.itemizerdre.command.logic.SignDRECommand;
import net.kyori.adventure.text.Component;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

public class ClearCommand extends SignDRECommand {

    public ClearCommand() {
        setCommand("clear");
        setAliases("c");
        setMaxArgs(0);
        setHelp("&6/id &6s&eign c&elear &8- &7&oLöscht alle Reihen");
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
