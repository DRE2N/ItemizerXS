package de.fyreum.itemizerxs.command.logic;

import de.erethon.bedrock.command.ECommandCache;
import de.erethon.bedrock.plugin.EPlugin;
import de.fyreum.itemizerxs.command.DurabilityCommand;
import de.fyreum.itemizerxs.command.HelpCommand;
import de.fyreum.itemizerxs.command.NameCommand;
import de.fyreum.itemizerxs.command.ResetCommand;
import de.fyreum.itemizerxs.command.SetModelDataCommand;
import de.fyreum.itemizerxs.command.TypeCommand;
import de.fyreum.itemizerxs.command.attribute.AttributeCommand;
import de.fyreum.itemizerxs.command.book.BookCommand;
import de.fyreum.itemizerxs.command.enchant.EnchantCommand;
import de.fyreum.itemizerxs.command.flag.FlagCommand;
import de.fyreum.itemizerxs.command.lore.LoreCommand;
import de.fyreum.itemizerxs.command.sign.SignCommand;

public class ICommandCache extends ECommandCache {

    public static final String LABEL = "itemizerxs";

    /* commands with sub commands */
    public AttributeCommand attributeCommand = new AttributeCommand();
    public BookCommand bookCommand = new BookCommand();
    public EnchantCommand enchantCommand = new EnchantCommand();
    public FlagCommand flagCommand = new FlagCommand();
    public LoreCommand loreCommand = new LoreCommand();
    public SignCommand signCommand = new SignCommand();
    /* normal commands */
    public DurabilityCommand durabilityCommand = new DurabilityCommand();
    public HelpCommand helpCommand = new HelpCommand(this);
    public NameCommand nameCommand = new NameCommand();
    public TypeCommand typeCommand = new TypeCommand();
    public ResetCommand resetCommand = new ResetCommand();
    public SetModelDataCommand setModelDataCommand = new SetModelDataCommand();

    public ICommandCache(EPlugin plugin) {
        super(LABEL, plugin);

        addCommand(attributeCommand);
        addCommand(bookCommand);
        addCommand(enchantCommand);
        addCommand(flagCommand);
        addCommand(loreCommand);
        addCommand(signCommand);

        addCommand(durabilityCommand);
        addCommand(helpCommand);
        addCommand(nameCommand);
        addCommand(typeCommand);
        addCommand(resetCommand);
        addCommand(setModelDataCommand);
    }
}
