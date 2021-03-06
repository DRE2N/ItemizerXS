package de.erethon.itemizerxs.command.logic;

import de.erethon.bedrock.chat.MessageUtil;
import de.erethon.bedrock.command.ECommand;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public abstract class ItemECommand extends ECommand {

    public ItemECommand() {
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

        if (itemStack.getType() == Material.AIR) {
            MessageUtil.sendMessage(sender, "&cDu musst ein Item in der Hand halten, um diesen Befehl benutzen zu dürfen");
            return;
        }
        onExecute(args, player, itemStack);
    }

    public abstract void onExecute(String[] args, Player player, ItemStack itemStack);
}
