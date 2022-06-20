package de.erethon.itemizerxs.command.lore;

import de.erethon.bedrock.chat.MessageUtil;
import de.erethon.itemizerxs.command.logic.ItemECommand;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ChangeCommand extends ItemECommand {

    public ChangeCommand() {
        setCommand("change");
        setAliases("c");
        setMinArgs(2);
        setUsage("/ii lore change [index] [...]");
        setDescription("Tauscht eine Zeile aus");
        setDefaultHelp();
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        return LoreCommand.tabCompleteLoreIndexes(sender, args);
    }

    @Override
    public void onExecute(String[] args, Player player, ItemStack itemStack) {
        int index;
        try {
            index = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            MessageUtil.sendMessage(player, "&eDer angegebene Index ist kein Zahlenwert");
            return;
        }
        ItemMeta meta = itemStack.getItemMeta();
        List<Component> lore = getLore(meta);

        String line = getFinalArg(args, 2);
        try {
            lore.set(index - 1, MessageUtil.parse(line));
        } catch (IndexOutOfBoundsException e) {
            MessageUtil.sendMessage(player, "&eDer angegebene Index ist zu niedrig oder zu hoch");
            return;
        }
        meta.lore(lore);
        itemStack.setItemMeta(meta);

        MessageUtil.sendMessage(player, "&7Zeile &6" + index + " &7wurde zu '&f<italic>" + line + "<reset>&7' geändert");
    }
}
