package de.fyreum.itemizerdre.command.book;

import de.erethon.commons.chat.MessageUtil;
import de.fyreum.itemizerdre.command.logic.BookDRECommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;
import java.util.List;

public class GenerationCommand extends BookDRECommand {

    public GenerationCommand() {
        setCommand("generation");
        setAliases("g");
        setMaxArgs(1);
        setHelp("&6/id a&euthor &6g&eeneration [&7generation&e] &8- &7&oSetzt die Generation");
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        if (args.length != 2) {
            return null;
        }
        List<String> completes = new ArrayList<>();

        for (BookMeta.Generation generation : BookMeta.Generation.values()) {
            if (generation.name().toLowerCase().startsWith(args[1].toLowerCase()) || generation.name().toLowerCase().contains(args[1].toLowerCase())) {
                completes.add(generation.name());
            }
        }
        return completes;
    }

    @Override
    public void onExecute(String[] args, Player player, ItemStack itemStack, BookMeta bookMeta) {
        BookMeta.Generation generation;
        try {
            generation = BookMeta.Generation.valueOf(args[1].toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            MessageUtil.sendMessage(player, "&eDie Generation '&6" + args[1] + "&e' konnte nicht gefunden werden");
            return;
        }
        bookMeta.setGeneration(generation);
        itemStack.setItemMeta(bookMeta);

        MessageUtil.sendMessage(player, "&7Die Generation wurde zu '&f" + generation.name() + "&7' geändert");
    }
}
