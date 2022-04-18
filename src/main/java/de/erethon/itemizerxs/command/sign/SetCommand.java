package de.erethon.itemizerxs.command.sign;

import de.erethon.bedrock.chat.MessageUtil;
import de.erethon.itemizerxs.command.logic.SignECommand;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

public class SetCommand extends SignECommand {

    public SetCommand() {
        setCommand("set");
        setAliases("s", "line");
        setMinArgs(2);
        setMaxArgs(Integer.MAX_VALUE);
        setUsage("/ii sign set [row] [...]");
        setDescription("Setzt eine Reihe");
        setDefaultHelp();
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
            sign.line(--row, MessageUtil.parse(msg));
        } catch(IndexOutOfBoundsException e) {
            MessageUtil.sendMessage(player, "&eDie angegebene Reihe muss zwischen &61-4 &esein");
            return;
        }
        MessageUtil.sendMessage(player, "&7Reihe &6" + (row + 1) + " &7wurde zu '&f" + msg + "<reset>&7' gesetzt");
    }
}
