package de.fyreum.itemizerdre.command.lore;

import de.erethon.commons.chat.MessageUtil;
import de.fyreum.itemizerdre.command.logic.ItemDRECommand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ClearCommand extends ItemDRECommand {

    public ClearCommand() {
        setCommand("clear");
        setAliases("c");
        setMinArgs(0);
        setMaxArgs(0);
        setHelp("&6/id l&eore c&elear &8- &7Löscht die lore");
    }

    @Override
    public void onExecute(String[] args, Player player, ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();
        int size = getLore(meta).size();

        meta.lore(null);
        itemStack.setItemMeta(meta);

        MessageUtil.sendMessage(player, "&7Es wurden &6" + size + " &7Zeilen gelöscht");
    }
}
