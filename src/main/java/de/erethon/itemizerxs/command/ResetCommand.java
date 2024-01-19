package de.erethon.itemizerxs.command;

import de.erethon.bedrock.chat.MessageUtil;
import de.erethon.itemizerxs.ItemizerXS;
import de.erethon.itemizerxs.command.logic.ItemECommand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ResetCommand extends ItemECommand {

    public ResetCommand() {
        setCommand("reset");
        setAliases("r");
        setMinArgs(0);
        setMaxArgs(0);
        setPermission("itemizerxs.cmd.reset");
        setUsage("/ii reset");
        setDescription("Setzt die ItemMeta zurück");
        setDefaultHelp();
    }

    @Override
    public void onExecute(String[] args, Player player, ItemStack itemStack) {
        ItemMeta meta = ItemizerXS.inst().getServer().getItemFactory().getItemMeta(itemStack.getType());
        itemStack.setItemMeta(meta);

        MessageUtil.sendMessage(player, "&7Die ItemMeta wurde zurückgesetzt");
    }
}
