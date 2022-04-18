package de.erethon.itemizerxs.command.enchant;

import de.erethon.bedrock.chat.MessageUtil;
import de.erethon.itemizerxs.command.logic.ItemECommand;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class RemoveCommand extends ItemECommand {

    public RemoveCommand() {
        setCommand("remove");
        setAliases("r");
        setMinArgs(1);
        setUsage("/ii enchant remove [ench]");
        setDescription("Entfernt eine Verzauberung");
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

        for (Enchantment enchant : itemStack.getEnchantments().keySet()) {
            String key = enchant.getKey().getKey();
            if (key.toLowerCase().startsWith(args[1].toLowerCase()) || key.toLowerCase().contains(args[1].toLowerCase())) {
                completes.add(key);
            }
        }
        return completes;
    }

    @Override
    public void onExecute(String[] args, Player player, ItemStack itemStack) {
        Enchantment enchant = null;
        for (Enchantment ench : itemStack.getEnchantments().keySet()) {
            if (ench.getKey().getKey().equalsIgnoreCase(args[1])) {
                enchant = ench;
            }
        }
        if (enchant == null) {
            MessageUtil.sendMessage(player, "&eVerzauberung konnte nicht gefunden werden");
            return;
        }
        itemStack.removeEnchantment(enchant);

        MessageUtil.sendMessage(player, "&7Verzauberung '&f" + enchant.getKey().getKey() + "&7' wurde entfernt");
    }
}
