package de.fyreum.itemizerxs.command.sign;

import de.erethon.commons.chat.MessageUtil;
import de.fyreum.itemizerxs.command.logic.SignDRECommand;
import de.fyreum.itemizerxs.util.ArgsUtil;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

public class SetCommand extends SignDRECommand {

    public SetCommand() {
        setCommand("set");
        setAliases("s", "line");
        setMinArgs(2);
        setMaxArgs(Integer.MAX_VALUE);
        setHelp("&6/ii s&eet [&7row&e] [&8...&e] &8- &7&oSetzt eine Reihe");
    }

    @Override
    public void onExecute(String[] args, Player player, Sign sign) {
        int row;
        try {
            row = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            MessageUtil.sendMessage(player, "&eDie angegebene Reihe ist kein Zahlenwert");
            return;
        }
        String msg = getFinalArg(args, 2);
        try {
            sign.line(--row, ArgsUtil.parse(msg));
        } catch(IndexOutOfBoundsException e) {
            MessageUtil.sendMessage(player, "&eDie angegebene Reihe muss zwischen &61-4 &esein");
            return;
        }
        MessageUtil.sendMessage(player, "&7Reihe &6" + (row + 1) + " &7wurde zu '&f" + msg + "<reset>&7' gesetzt");
    }
}
