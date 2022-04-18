package de.erethon.itemizerxs.command.book;

import de.erethon.itemizerxs.command.logic.BookECommand;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class WritableCommand extends BookECommand {

    public WritableCommand() {
        setCommand("writable");
        setAliases("w");
        setMinArgs(0);
        setMaxArgs(0);
        setUsage("/ii book writable");
        setDescription("Gibt dir eine bearbeitbare Version");
        setDefaultHelp();
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
