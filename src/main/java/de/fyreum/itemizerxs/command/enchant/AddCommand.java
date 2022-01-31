package de.fyreum.itemizerxs.command.enchant;

import de.erethon.bedrock.chat.MessageUtil;
import de.fyreum.itemizerxs.command.logic.ItemECommand;
import org.bukkit.NamespacedKey;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class AddCommand extends ItemECommand {

    public AddCommand() {
        setCommand("add");
        setAliases("a");
        setMinArgs(2);
        setMaxArgs(2);
        setHelp("&6/ii e&enchant &6a&edd [&7ench&e] [&7level&e] &8- &7&oFügt Verzauberung hinzu");
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        if (args.length != 2) {
            return null;
        }
        List<String> completes = new ArrayList<>();

        for (Enchantment enchant : Enchantment.values()) {
            String key = enchant.getKey().getKey();
            if (key.toLowerCase().startsWith(args[1].toLowerCase()) || key.toLowerCase().contains(args[1].toLowerCase())) {
                completes.add(key);
            }
        }
        return completes;
    }

    @Override
    public void onExecute(String[] args, Player player, ItemStack itemStack) {
        Enchantment enchant = Enchantment.getByKey(NamespacedKey.minecraft(args[1]));
        if (enchant == null) {
            MessageUtil.sendMessage(player, "&eVerzauberung konnte nicht gefunden werden");
            return;
        }
        int level;
        try {
            level = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            MessageUtil.sendMessage(player, "&eDie angegebene Stufe ist kein Zahlenwert");
            return;
        }
        itemStack.addUnsafeEnchantment(enchant, level);

        MessageUtil.sendMessage(player, "&7Verzauberung '&f" + enchant.getKey().getKey() + "&7' Stufe &6" + level + " &7wurde hinzugefügt");
    }
}
