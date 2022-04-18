package de.erethon.itemizerxs.command;

import de.erethon.bedrock.chat.MessageUtil;
import de.erethon.itemizerxs.command.logic.ItemECommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class DurabilityCommand extends ItemECommand {

    public DurabilityCommand() {
        setCommand("durability");
        setAliases("d");
        setPermission("itemizerxs.cmd.durability");
        setUsage("/ii durability [durability]");
        setDescription("Setzt die Haltbarkeit");
        setDefaultHelp();
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        if (args.length != 2) {
            return null;
        }
        if (!(sender instanceof Player player)) {
            return null;
        }
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        List<String> completes = new ArrayList<>();

        String maxDurability = Short.toString(itemStack.getType().getMaxDurability());

        if (maxDurability.startsWith(args[1])) {
            completes.add(maxDurability);
        }
        return completes;
    }

    @Override
    public void onExecute(String[] args, Player player, ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();
        if (meta == null) {
            meta = Bukkit.getServer().getItemFactory().getItemMeta(itemStack.getType());
        }
        if (!(meta instanceof Damageable)) {
            MessageUtil.sendMessage(player, "&eDieses Item besitzt keine Haltbarkeit");
            return;
        }
        int durability;
        try {
            durability = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            MessageUtil.sendMessage(player, "&eDie angegebene Haltbarkeit ist kein Zahlenwert");
            return;
        }
        int damage = itemStack.getType().getMaxDurability() - durability;

        ((Damageable) meta).setDamage(damage);
        itemStack.setItemMeta(meta);

        MessageUtil.sendMessage(player, "&7Die Haltbarkeit wurde auf &6" + durability + " &7gesetzt");
    }
}
