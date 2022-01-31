package de.fyreum.itemizerxs.command;

import de.erethon.bedrock.chat.MessageUtil;
import de.fyreum.itemizerxs.ItemizerXS;
import de.fyreum.itemizerxs.command.logic.ItemECommand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ResetCommand extends ItemECommand {

    public ResetCommand() {
        setCommand("reset");
        setAliases("r");
        setMinArgs(0);
        setMaxArgs(0);
        setHelp("&6/ii r&eeset &8- &7&oSetzt die ItemMeta zurück");
    }

    @Override
    public void onExecute(String[] args, Player player, ItemStack itemStack) {
        ItemMeta meta = ItemizerXS.inst().getServer().getItemFactory().getItemMeta(itemStack.getType());
        itemStack.setItemMeta(meta);

        MessageUtil.sendMessage(player, "&7Die ItemMeta wurde zurückgesetzt");
    }
}
