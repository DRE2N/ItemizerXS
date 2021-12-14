package de.fyreum.itemizerxs.command.lore;

import de.erethon.commons.command.DRECommand;
import de.fyreum.itemizerxs.command.HelpCommand;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class LoreCommand extends DRECommand {

    public AddCommand addCommand = new AddCommand();
    public ChangeCommand changeCommand = new ChangeCommand();
    public ClearCommand clearCommand = new ClearCommand();
    public InsertCommand insertCommand = new InsertCommand();
    public RemoveCommand removeCommand = new RemoveCommand();

    public LoreCommand() {
        setCommand("lore");
        setAliases("l");
        setMinArgs(0);
        setMaxArgs(Integer.MAX_VALUE);
        setConsoleCommand(false);
        setPlayerCommand(true);
        setPermission("itemizerxs.cmd.lore");
        setHelp("&6/ii l&eore &8- &7&oBefehle rund um die lore eines Items");

        addSubCommands(addCommand, changeCommand, clearCommand, insertCommand, removeCommand);
    }

    @Override
    public void onExecute(String[] args, CommandSender sender) {
        HelpCommand.sendHelp(getSubCommands(), args, sender);
    }

    public static List<String> tabCompleteLoreIndexes(CommandSender sender, String[] args) {
        if (args.length != 2) {
            return null;
        }
        if (!(sender instanceof Player player)) {
            return null;
        }
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        List<String> completes = new ArrayList<>();
        List<Component> lore = itemStack.getItemMeta().lore();

        if (lore == null) {
            lore = new ArrayList<>();
        }

        for (int i = 0; i < lore.size(); i++) {
            String s = Integer.toString(i + 1);

            if (s.startsWith(args[1])) {
                completes.add(s);
            }
        }
        return completes;
    }
}
