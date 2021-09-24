package de.fyreum.itemizerdre.command.lore;

import de.erethon.commons.chat.MessageUtil;
import de.fyreum.itemizerdre.command.logic.ItemDRECommand;
import de.fyreum.itemizerdre.util.ArgsUtil;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class InsertCommand extends ItemDRECommand {

    public InsertCommand() {
        setCommand("insert");
        setAliases("i");
        setMinArgs(2);
        setHelp("&6/id l&eore &6i&ensert [&7index&e] [&7...&e] &8- &7&oFügt die Zeile vor einer anderen ein");
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
            lore.add(--index, ArgsUtil.parse(line));
        } catch (IndexOutOfBoundsException e) {
            MessageUtil.sendMessage(player, "&eDer angegebene Index ist zu niedrig oder zu hoch");
            return;
        }
        meta.lore(lore);
        itemStack.setItemMeta(meta);

        MessageUtil.sendMessage(player, "&7Zeile '&f" + line + "<reset>&7' wurde eingefügt");
    }
}
