package de.fyreum.itemizerdre.command.logic;

import de.erethon.commons.chat.MessageUtil;
import de.erethon.commons.command.DRECommand;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public abstract class ItemDRECommand extends DRECommand {

    public ItemDRECommand() {
        setMinArgs(1);
        setMaxArgs(Integer.MAX_VALUE);
        setPlayerCommand(true);
        setConsoleCommand(false);
    }

    protected List<Component> getLore(ItemMeta meta) {
        List<Component> lore = meta.lore();
        if (lore == null) {
            lore = new ArrayList<>();
        }
        return lore;
    }

    @Override
    public void onExecute(String[] args, CommandSender sender) {
        Player player = (Player) sender;
        ItemStack itemStack = player.getInventory().getItemInMainHand();

        if (itemStack == null || itemStack.getType() == Material.AIR) {
            MessageUtil.sendMessage(sender, "&cDu musst ein Item in der Hand halten, um diesen Befehl benutzen zu dürfen");
            return;
        }
        onExecute(args, player, itemStack);
    }

    public abstract void onExecute(String[] args, Player player, ItemStack itemStack);
}
