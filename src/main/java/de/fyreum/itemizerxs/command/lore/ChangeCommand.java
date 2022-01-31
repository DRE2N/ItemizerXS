package de.fyreum.itemizerxs.command.lore;

import de.erethon.bedrock.chat.MessageUtil;
import de.fyreum.itemizerxs.command.logic.ItemECommand;
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
        setHelp("&6/ii l&eore &6c&ehange [&7index&e] [&7...&e] &8- &7&oTauscht eine Zeile aus");
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
            lore.set(--index, MessageUtil.parse(line));
        } catch (IndexOutOfBoundsException e) {
            MessageUtil.sendMessage(player, "&eDer angegebene Index ist zu niedrig oder zu hoch");
            return;
        }

        meta.lore(lore);
        itemStack.setItemMeta(meta);

        MessageUtil.sendMessage(player, "&7Zeile &6" + (index + 1) + " &7wurde zu '&f" + line + "<reset>&7' geändert");
    }
}
