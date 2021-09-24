package de.fyreum.itemizerdre.command.book;

import de.erethon.commons.chat.MessageUtil;
import de.fyreum.itemizerdre.command.logic.BookDRECommand;
import de.fyreum.itemizerdre.util.ArgsUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AuthorCommand extends BookDRECommand {

    public AuthorCommand() {
        setCommand("author");
        setAliases("a");
        setHelp("&6/id a&euthor [&7name&e] &8- &7&oSetzt den Autoren");
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        if (args.length != 2) {
            return null;
        }
        List<String> completes = new ArrayList<>();

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getName().toLowerCase().startsWith(args[1].toLowerCase())) {
                completes.add(player.getName());
            }
        }
        return completes;
    }

    @Override
    public void onExecute(String[] args, Player player, ItemStack itemStack, BookMeta bookMeta) {
        String author = getFinalArg(args, 1);

        bookMeta.author(ArgsUtil.parse(author));
        itemStack.setItemMeta(bookMeta);

        MessageUtil.sendMessage(player, "&7Der Autor wurde zu '&f" + author + "<reset>&7' geändert");
    }
}
