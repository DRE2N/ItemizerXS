package de.fyreum.itemizerxs.command.lore;

import de.erethon.commons.chat.MessageUtil;
import de.fyreum.itemizerxs.command.logic.ItemDRECommand;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class RemoveCommand extends ItemDRECommand {

    public RemoveCommand() {
        setCommand("remove");
        setAliases("r");
        setMaxArgs(1);
        setHelp("&6/id l&eore &6r&eemove [&7index&e] &8- &7&oEntfernt eine Zeile");
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

        try {
            lore.remove(--index);
        } catch (IndexOutOfBoundsException e) {
            MessageUtil.sendMessage(player, "&eDer angegebene Index ist zu niedrig oder zu hoch");
            return;
        }
        meta.lore(lore);
        itemStack.setItemMeta(meta);

        MessageUtil.sendMessage(player, "&7Zeile &6" + (index + 1) + " &7wurde entfernt");
    }
}
