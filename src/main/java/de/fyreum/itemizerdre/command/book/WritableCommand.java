package de.fyreum.itemizerdre.command.book;

import de.fyreum.itemizerdre.command.logic.BookDRECommand;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class WritableCommand extends BookDRECommand {

    public WritableCommand() {
        setCommand("writable");
        setAliases("w");
        setMinArgs(0);
        setMaxArgs(0);
        setHelp("&6/id b&eook &6w&eritable &8- &7&oGibt dir eine bearbeitbare Version");
    }

    @Override
    public void onExecute(String[] args, Player player, ItemStack itemStack, BookMeta bookMeta) {
        ItemStack item = new ItemStack(Material.WRITABLE_BOOK);
        BookMeta meta = (BookMeta) item.getItemMeta();

        meta.pages(bookMeta.pages());
        item.setItemMeta(meta);

        player.getInventory().addItem(item);
    }
}
