package de.erethon.itemizerxs.command.lore;

import de.erethon.bedrock.chat.MessageUtil;
import de.erethon.itemizerxs.command.logic.ItemECommand;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * @author Fyreum
 */
public class GetCommand extends ItemECommand {

    public GetCommand() {
        setCommand("get");
        setAliases("g");
        setMinArgs(1);
        setUsage("/ii lore get [index]");
        setDescription("Kopiert eine bestimmte Zeile");
        setDefaultHelp();
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        return LoreCommand.tabCompleteLoreIndexes(sender, args);
    }

    @Override
    public void onExecute(String[] args, Player player, ItemStack itemStack) {
        int index;
        try {
            index = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            MessageUtil.sendMessage(player, "&eDer angegebene Index ist kein Zahlenwert");
            return;
        }
        List<Component> lore = getLore(itemStack.getItemMeta());
        Component line;
        try {
            line = lore.get(index - 1);
        } catch (IndexOutOfBoundsException e) {
            MessageUtil.sendMessage(player, "&eDer angegebene Index ist zu niedrig oder zu hoch");
            return;
        }
        MessageUtil.sendMessage(player, MessageUtil.parse("&7Zum Kopieren ")
                .append(MessageUtil.parse("&6[hier]")
                        .clickEvent(ClickEvent.copyToClipboard(MessageUtil.serialize(line)))
                        .hoverEvent(HoverEvent.showText(Component.text().decorate(TextDecoration.ITALIC).append(line))))
                .append(MessageUtil.parse(" &7drücken")));
    }

}
