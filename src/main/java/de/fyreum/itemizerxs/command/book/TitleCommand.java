package de.fyreum.itemizerxs.command.book;

import de.erethon.commons.chat.MessageUtil;
import de.fyreum.itemizerxs.command.logic.BookDRECommand;
import de.fyreum.itemizerxs.util.ArgsUtil;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class TitleCommand extends BookDRECommand {

    public TitleCommand() {
        setCommand("title");
        setAliases("t");
        setHelp("&6/id b&eook &6t&eitle [&7title&e] &8- &7&oSetzt den Titel");
    }

    @Override
    public void onExecute(String[] args, Player player, ItemStack itemStack, BookMeta bookMeta) {
        String title = getFinalArg(args, 1);

        bookMeta.title(ArgsUtil.parse(title));
        itemStack.setItemMeta(bookMeta);

        MessageUtil.sendMessage(player, "&7Der Titel wurde zu '&f" + title + "<reset>&7' geändert");
    }
}
