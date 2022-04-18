package de.erethon.itemizerxs.command.flag;

import de.erethon.bedrock.chat.MessageUtil;
import de.erethon.itemizerxs.command.logic.ItemECommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class RemoveCommand extends ItemECommand {

    public RemoveCommand() {
        setCommand("remove");
        setAliases("r");
        setUsage("/ii flag remove [flag]");
        setDescription("Entfernt ein ItemFlag");
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

        for (ItemFlag flag : itemStack.getItemFlags()) {
            if (flag.name().toLowerCase().startsWith(args[1].toLowerCase()) || flag.name().toLowerCase().contains(args[1].toLowerCase())) {
                completes.add(flag.name());
            }
        }
        return completes;
    }

    @Override
    public void onExecute(String[] args, Player player, ItemStack itemStack) {
        ItemFlag flag;
        try {
            flag = ItemFlag.valueOf(args[1]);
        } catch (IllegalArgumentException | NullPointerException e) {
            MessageUtil.sendMessage(player, "&eItemFlag konnte nicht gefunden werden");
            return;
        }
        itemStack.removeItemFlags(flag);

        MessageUtil.sendMessage(player, "&7Der ItemFlag '&f" + flag + "' &7wurde entfernt");
    }
}
