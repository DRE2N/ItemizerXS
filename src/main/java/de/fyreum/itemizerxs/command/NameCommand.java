package de.fyreum.itemizerxs.command;

import de.erethon.bedrock.chat.MessageUtil;
import de.fyreum.itemizerxs.command.logic.ItemECommand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class NameCommand extends ItemECommand {

    public NameCommand() {
        setCommand("name");
        setAliases("n", "rename");
        setHelp("&6/ii n&eame [&7name&e] &8- &7&oÄndert den Namen'");
        setPermission("itemizerxs.cmd.type");
    }

    @Override
    public void onExecute(String[] args, Player player, ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();
        String name = getFinalArg(args, 1);

        meta.displayName(MessageUtil.parse(name));
        itemStack.setItemMeta(meta);

        MessageUtil.sendMessage(player, "&7Name wurde zu '&f" + name + "<reset>&7' geändert");
    }
}
