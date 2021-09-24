package de.fyreum.itemizerdre.command.logic;

import de.erethon.commons.chat.MessageUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public abstract class BookDRECommand extends ItemDRECommand {

    @Override
    public final void onExecute(String[] args, Player player, ItemStack itemStack) {
        if (itemStack.getType() != Material.WRITTEN_BOOK) {
            MessageUtil.sendMessage(player, "&eDu musst ein Buch in der Hand halten, um diesen Befehl benutzen zu dürfen");
            return;
        }
        onExecute(args, player, itemStack, (BookMeta) itemStack.getItemMeta());
    }

    public abstract void onExecute(String[] args, Player player, ItemStack itemStack, BookMeta bookMeta);
}
