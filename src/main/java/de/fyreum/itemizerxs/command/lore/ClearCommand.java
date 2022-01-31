package de.fyreum.itemizerxs.command.lore;

import de.erethon.bedrock.chat.MessageUtil;
import de.fyreum.itemizerxs.command.logic.ItemECommand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ClearCommand extends ItemECommand {

    public ClearCommand() {
        setCommand("clear");
        setAliases("c");
        setMinArgs(0);
        setMaxArgs(0);
        setHelp("&6/ii l&eore c&elear &8- &7Löscht die lore");
    }

    @Override
    public void onExecute(String[] args, Player player, ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();
        int size = getLore(meta).size();

        meta.lore(null);
        itemStack.setItemMeta(meta);

        MessageUtil.sendMessage(player, "&7Es wurden &6" + size + " &7Zeilen gelöscht");
    }
}
