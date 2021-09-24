package de.fyreum.itemizerdre.command.enchant;

import de.erethon.commons.command.DRECommand;
import de.fyreum.itemizerdre.command.HelpCommand;
import org.bukkit.command.CommandSender;

public class EnchantCommand extends DRECommand {

    public AddCommand addCommand = new AddCommand();
    public RemoveCommand removeCommand = new RemoveCommand();

    public EnchantCommand() {
        setCommand("enchant");
        setAliases("e");
        setMinArgs(0);
        setMaxArgs(Integer.MAX_VALUE);
        setConsoleCommand(false);
        setPlayerCommand(true);
        setPermission("itemizerdre.cmd.enchant");
        setHelp("&6/id e&enchant &8- &7&oBefehle rund um Verzauberungen");

        addSubCommands(addCommand, removeCommand);
    }

    @Override
    public void onExecute(String[] args, CommandSender sender) {
        HelpCommand.sendHelp(getSubCommands(), args, sender);
    }
}