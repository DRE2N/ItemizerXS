package de.fyreum.itemizerdre.command;

import de.erethon.commons.chat.MessageUtil;
import de.fyreum.itemizerdre.ItemizerDRE;
import de.fyreum.itemizerdre.command.logic.ItemDRECommand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ResetCommand extends ItemDRECommand {

    public ResetCommand() {
        setCommand("reset");
        setAliases("r");
        setMinArgs(0);
        setMaxArgs(0);
        setHelp("&6/id r&eeset &8- &7&oSetzt die ItemMeta zurück");
    }

    @Override
    public void onExecute(String[] args, Player player, ItemStack itemStack) {
        ItemMeta meta = ItemizerDRE.inst().getServer().getItemFactory().getItemMeta(itemStack.getType());
        itemStack.setItemMeta(meta);

        MessageUtil.sendMessage(player, "&7Die ItemMeta wurde zurückgesetzt");
    }
}