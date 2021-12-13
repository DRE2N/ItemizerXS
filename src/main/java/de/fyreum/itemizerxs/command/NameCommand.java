package de.fyreum.itemizerxs.command;

import de.erethon.commons.chat.MessageUtil;
import de.fyreum.itemizerxs.command.logic.ItemDRECommand;
import de.fyreum.itemizerxs.util.ArgsUtil;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class NameCommand extends ItemDRECommand {

    public NameCommand() {
        setCommand("name");
        setAliases("n", "rename");
        setHelp("&6/id n&eame [&7name&e] &8- &7&oÄndert den Namen'");
        setPermission("itemizerdre.cmd.type");
    }

    @Override
    public void onExecute(String[] args, Player player, ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();
        String name = getFinalArg(args, 1);

        meta.displayName(ArgsUtil.parse(name));
        itemStack.setItemMeta(meta);

        MessageUtil.sendMessage(player, "&7Name wurde zu '&f" + name + "<reset>&7' geändert");
    }
}
