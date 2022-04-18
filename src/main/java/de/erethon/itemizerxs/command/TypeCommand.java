package de.erethon.itemizerxs.command;

import de.erethon.bedrock.chat.MessageUtil;
import de.erethon.itemizerxs.command.logic.ItemECommand;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class TypeCommand extends ItemECommand {

    public TypeCommand() {
        setCommand("type");
        setAliases("t", "type", "material");
        setMaxArgs(1);
        setPermission("itemizerxs.cmd.type");
        setUsage("/ii type [type]");
        setDescription("Setzt das Material");
        setDefaultHelp();
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        List<String> completes = new ArrayList<>();

        if (args.length == 2) {
            for (Material material : Material.values()) {
                if (material.name().toLowerCase().startsWith(args[1].toLowerCase())) {
                    completes.add(material.name());
                }
            }
        }
        return completes;
    }

    @Override
    public void onExecute(String[] args, Player player, ItemStack itemStack) {
        Material material = Material.getMaterial(args[1]);
        if (material == null) {
            MessageUtil.sendMessage(player, "&eMaterial konnte nicht gefunden werden");
            return;
        }
        itemStack.setType(material);

        MessageUtil.sendMessage(player, "&7Material wurde zu '&f" + material.name() + "&7' geändert");
    }
}
