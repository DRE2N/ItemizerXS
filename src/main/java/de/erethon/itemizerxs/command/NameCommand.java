package de.erethon.itemizerxs.command;

import de.erethon.bedrock.chat.MessageUtil;
import de.erethon.itemizerxs.command.logic.ItemECommand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class NameCommand extends ItemECommand {

    public NameCommand() {
        setCommand("name");
        setAliases("n", "rename");
        setPermission("itemizerxs.cmd.name");
        setUsage("/ii name [name]");
        setDescription("Ändert den Namen");
        setDefaultHelp();
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
