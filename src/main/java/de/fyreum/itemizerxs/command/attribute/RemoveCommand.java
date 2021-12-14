package de.fyreum.itemizerxs.command.attribute;

import com.google.common.collect.Multimap;
import de.erethon.commons.chat.MessageUtil;
import de.fyreum.itemizerxs.command.logic.ItemDRECommand;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveCommand extends ItemDRECommand {

    public RemoveCommand() {
        setCommand("remove");
        setAliases("r");
        setMaxArgs(1);
        setHelp("&6/ii r&eemove [&7attr&e|&7slot&e] &8- &7&oEntfernt ein Attribut");
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
        ItemMeta meta = itemStack.getItemMeta();
        Multimap<Attribute, AttributeModifier> attributeModifiers = meta.getAttributeModifiers();
        List<String> completes = new ArrayList<>();

        if (attributeModifiers == null) {
            return null;
        }
        for (Attribute attribute : attributeModifiers.keySet()) {
            if (attribute.name().toLowerCase().startsWith(args[1].toLowerCase()) || attribute.name().toLowerCase().contains(args[1].toLowerCase())) {
                completes.add(attribute.name());
            }
        }
        Set<String> slots = new HashSet<>();

        for (AttributeModifier modifier : attributeModifiers.values()) {
            EquipmentSlot slot = modifier.getSlot();

            if (slot == null) {
                slots.add("ALL");
                continue;
            }
            slots.add(slot.name());
        }

        for (String slot : slots) {
            if (slot.toLowerCase().startsWith(args[1].toLowerCase()) || slot.toLowerCase().contains(args[1].toLowerCase())) {
                completes.add(slot);
            }
        }
        return completes;
    }

    @Override
    public void onExecute(String[] args, Player player, ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();
        String arg = args[1];
        int amount = 0;

        try {
            Attribute attribute = Attribute.valueOf(arg.toUpperCase());
            Collection<AttributeModifier> modifiers = meta.getAttributeModifiers(attribute);
            amount = modifiers == null ? 0 : modifiers.size();

            meta.removeAttributeModifier(attribute);
        } catch (IllegalArgumentException | NullPointerException e1) {
            try {
                if (arg.equalsIgnoreCase("ALL")) {
                    Multimap<Attribute, AttributeModifier> attributeModifiers = meta.getAttributeModifiers();

                    amount = attributeModifiers == null ? 0 : attributeModifiers.size();

                    meta.setAttributeModifiers(null);
                } else {
                    EquipmentSlot slot = EquipmentSlot.valueOf(arg.toUpperCase());

                    amount = meta.getAttributeModifiers(slot).size();

                    meta.removeAttributeModifier(slot);
                }
            } catch (IllegalArgumentException | NullPointerException e2) {
                MessageUtil.sendMessage(player, "&eDas Attribut / der Slot '&6" + arg + "&e' konnte nicht gefunden werden");
            }
        }
        itemStack.setItemMeta(meta);

        MessageUtil.sendMessage(player, "&7Es wurden &6" + amount + " &7AttributeModifier antfernt");
    }
}
