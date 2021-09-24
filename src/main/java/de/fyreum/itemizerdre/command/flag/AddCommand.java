package de.fyreum.itemizerdre.command.flag;

import de.erethon.commons.chat.MessageUtil;
import de.fyreum.itemizerdre.command.logic.ItemDRECommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class AddCommand extends ItemDRECommand {

    public AddCommand() {
        setCommand("add");
        setAliases("a");
        setMaxArgs(1);
        setHelp("&6/id a&edd [&7flag&e] &8- &7&oFügt ein ItemFlag hinzu");
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        if (args.length != 2) {
            return null;
        }
        List<String> completes = new ArrayList<>();

        for (ItemFlag flag : ItemFlag.values()) {
            if (flag.name().toLowerCase().startsWith(args[1].toLowerCase()) || flag.name().toLowerCase().contains(args[1].toLowerCase())) {
                completes.add(flag.name());
            }
        }
        return completes;
    }

    @Override
    public void onExecute(String[] args, Player player, ItemStack itemStack) {
        ItemFlag flag;
        String flagArg = args[1];

        try {
            flag = ItemFlag.valueOf(flagArg);
        } catch (Exception e) {
            MessageUtil.sendMessage(player, "&eDer ItemFlag '&6" + flagArg + "&7' konnte nicht gefunden werden");
            return;
        }
        itemStack.addItemFlags(flag);

        MessageUtil.sendMessage(player, "&7Der ItemFlag '&f" + flag.name() + "&7' wurde hinzugefügt");
    }
}