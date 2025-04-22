package de.erethon.itemizerxs.command.logic;

import de.erethon.bedrock.command.ECommandCache;
import de.erethon.bedrock.plugin.EPlugin;
import de.erethon.itemizerxs.command.DurabilityCommand;
import de.erethon.itemizerxs.command.HelpCommand;
import de.erethon.itemizerxs.command.NameCommand;
import de.erethon.itemizerxs.command.ResetCommand;
import de.erethon.itemizerxs.command.SetModelDataCommand;
import de.erethon.itemizerxs.command.TypeCommand;
import de.erethon.itemizerxs.command.attribute.AttributeCommand;
import de.erethon.itemizerxs.command.book.BookCommand;
import de.erethon.itemizerxs.command.enchant.EnchantCommand;
import de.erethon.itemizerxs.command.flag.FlagCommand;
import de.erethon.itemizerxs.command.lore.LoreCommand;
import de.erethon.itemizerxs.command.sign.SignCommand;

public class ICommandCache extends ECommandCache {

    public static final String LABEL = "itemizerxs";

    /* commands with sub commands */
    public AttributeCommand attributeCommand = new AttributeCommand();
    public BookCommand bookCommand = new BookCommand();
    public EnchantCommand enchantCommand; // Causes conflict with Papyrus
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
        this(plugin, false);
    }

    public ICommandCache(EPlugin plugin, boolean isPapyrus) {
        super(LABEL, plugin);

        addCommand(attributeCommand);
        addCommand(bookCommand);

        if (!isPapyrus) {
            addCommand(enchantCommand = new EnchantCommand());
        }
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
