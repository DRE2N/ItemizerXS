package de.erethon.itemizerxs.command.book;

import de.erethon.bedrock.chat.MessageUtil;
import de.erethon.itemizerxs.command.logic.BookECommand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class TitleCommand extends BookECommand {

    public TitleCommand() {
        setCommand("title");
        setAliases("t");
        setUsage("/ii book title [title]");
        setDescription("Setzt den Titel");
        setDefaultHelp();
    }

    @Override
    public void onExecute(String[] args, Player player, ItemStack itemStack, BookMeta bookMeta) {
        String title = getFinalArg(args, 1);

        bookMeta.title(MessageUtil.parse(title));
        itemStack.setItemMeta(bookMeta);

        MessageUtil.sendMessage(player, "&7Der Titel wurde zu '&f" + title + "<reset>&7' geändert");
    }
}
