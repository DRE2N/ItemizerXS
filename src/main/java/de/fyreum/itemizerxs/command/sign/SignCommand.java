package de.fyreum.itemizerxs.command.sign;

import de.erethon.bedrock.command.ECommand;
import de.fyreum.itemizerxs.command.HelpCommand;
import org.bukkit.command.CommandSender;

public class SignCommand extends ECommand {

    public ClearCommand clearCommand = new ClearCommand();
    public SetCommand setCommand = new SetCommand();

    public SignCommand() {
        setCommand("sign");
        setAliases("s");
        setMinArgs(0);
        setMaxArgs(Integer.MAX_VALUE);
        setConsoleCommand(false);
        setPlayerCommand(true);
        setPermission("itemizerxs.cmd.sign");
        setHelp("&6/ii s&eign &8- &7&oBefehle rund um die lore eines Items");

        addSubCommands(clearCommand, setCommand);
    }

    @Override
    public void onExecute(String[] args, CommandSender sender) {
        HelpCommand.sendHelp(getSubCommands(), args, sender);
    }
}
