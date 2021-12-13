package de.fyreum.itemizerxs.command.attribute;

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
import java.util.List;
import java.util.UUID;

public class AddCommand extends ItemDRECommand {

    public AddCommand() {
        setCommand("add");
        setAliases("a");
        setMinArgs(3);
        setMaxArgs(4);
        setHelp("&6/id attribute a&edd [&7attr&e] [&7strength&e] [&7operation&e] ([&7slot&e]) &8- &7&oFügt ein Attribut hinzu");
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        List<String> completes = new ArrayList<>();
        if (args.length == 2) {
            for (Attribute attribute : Attribute.values()) {
                if (attribute.name().toLowerCase().startsWith(args[1].toLowerCase()) || attribute.name().toLowerCase().contains(args[1].toLowerCase())) {
                    completes.add(attribute.name());
                }
            }
        }
        if (args.length == 4) {
            for (AttributeModifier.Operation operation : AttributeModifier.Operation.values()) {
                if (operation.name().toLowerCase().startsWith(args[3].toLowerCase()) || operation.name().toLowerCase().contains(args[3].toLowerCase())) {
                    completes.add(operation.name());
                }
            }
        }
        if (args.length == 5) {
            for (EquipmentSlot slot : EquipmentSlot.values()) {
                if (slot.name().toLowerCase().startsWith(args[4].toLowerCase()) || slot.name().toLowerCase().contains(args[4].toLowerCase())) {
                    completes.add(slot.name());
                }
            }
        }
        return completes;
    }

    @Override
    public void onExecute(String[] args, Player player, ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();

        Attribute attribute;
        String attributeArg = args[1];
        try {
            attribute = Attribute.valueOf(attributeArg);
        } catch (IllegalArgumentException | NullPointerException e) {
            MessageUtil.sendMessage(player, "&eDas Attribut '&6" + attributeArg + "&e' konnte nicht gefunden werden");
            return;
        }

        String strengthArg = args[2];
        double strength;
        try {
            try {
                strength = Double.parseDouble(strengthArg);
            } catch (NumberFormatException e) {
                strength = Integer.parseInt(strengthArg);
            }
        } catch (NumberFormatException e) {
            MessageUtil.sendMessage(player, "&eDie angegebene Stärke ist kein Zahlenwert");
            return;
        }

        AttributeModifier.Operation operation;
        String operationArg = args[3];
        try {
            operation = AttributeModifier.Operation.valueOf(operationArg.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            MessageUtil.sendMessage(player, "&eDie Operation '&6" + operationArg + "&e' konnte nicht gefunden werden");
            return;
        }

        if (args.length == 4) {
            meta.addAttributeModifier(attribute, new AttributeModifier(UUID.randomUUID(), attribute.name(), strength, operation));
        } else {
            EquipmentSlot slot;
            String slotArg = args[4];
            try {
                slot = EquipmentSlot.valueOf(slotArg.toUpperCase());
            } catch (Exception e) {
                MessageUtil.sendMessage(player, "&eDer Slot '" + slotArg + "' konnte nicht gefunden werden");
                return;
            }

            meta.addAttributeModifier(attribute, new AttributeModifier(UUID.randomUUID(), attribute.name(), strength, operation, slot));
        }

        itemStack.setItemMeta(meta);

        MessageUtil.sendMessage(player, "&7Das Attribute '&f" + attribute.name() + "&7' wurde hinzugefügt");
    }
}
