package de.fyreum.itemizerxs.command.lore;

import de.erethon.bedrock.chat.MessageUtil;
import de.fyreum.itemizerxs.command.logic.ItemECommand;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class AddCommand extends ItemECommand {

    public AddCommand() {
        setCommand("add");
        setAliases("a");
        setHelp("&6/ii l&eore &6a&edd [&7...&e] &8- &7&oFügt die Zeile hinzu");
    }

    @Override
    public void onExecute(String[] args, Player player, ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();
        List<Component> lore = getLore(meta);

        String line = getFinalArg(args, 1);
        lore.add(MessageUtil.parse(line));

        meta.lore(lore);
        itemStack.setItemMeta(meta);

        MessageUtil.sendMessage(player, "&7Zeile '&f" + line + "<reset>&7' wurde hinzugefügt");
    }
}
