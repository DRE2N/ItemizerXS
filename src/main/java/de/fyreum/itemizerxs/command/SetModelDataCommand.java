package de.fyreum.itemizerxs.command;

import de.erethon.bedrock.chat.MessageUtil;
import de.fyreum.itemizerxs.command.logic.ItemECommand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SetModelDataCommand extends ItemECommand {

    public SetModelDataCommand() {
        setCommand("setModelData");
        setAliases("data");
        setMaxArgs(1);
        setHelp("&6/ii &esetModel&6Data &e[&7value&e] &8- &7&oSetzt die CustomModelData");
        setPermission("itemizerxs.cmd.setcustommodeldata");
    }

    @Override
    public void onExecute(String[] args, Player player, ItemStack itemStack) {
        int value;
        try {
            value = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            MessageUtil.sendMessage(player, "&eDer angegebene Wert ist kein Zahlenwert");
            return;
        }
        ItemMeta meta = itemStack.getItemMeta();

        meta.setCustomModelData(value);
        itemStack.setItemMeta(meta);

        MessageUtil.sendMessage(player, "&7Die CustomModelData wurde auf &6" + value + " &7gesetzt");
    }
}
