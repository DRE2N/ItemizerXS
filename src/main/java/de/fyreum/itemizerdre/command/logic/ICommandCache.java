package de.fyreum.itemizerdre.command.logic;

import de.erethon.commons.command.DRECommandCache;
import de.erethon.commons.javaplugin.DREPlugin;
import de.fyreum.itemizerdre.command.DurabilityCommand;
import de.fyreum.itemizerdre.command.HelpCommand;
import de.fyreum.itemizerdre.command.NameCommand;
import de.fyreum.itemizerdre.command.ResetCommand;
import de.fyreum.itemizerdre.command.SetModelDataCommand;
import de.fyreum.itemizerdre.command.TypeCommand;
import de.fyreum.itemizerdre.command.attribute.AttributeCommand;
import de.fyreum.itemizerdre.command.book.BookCommand;
import de.fyreum.itemizerdre.command.enchant.EnchantCommand;
import de.fyreum.itemizerdre.command.flag.FlagCommand;
import de.fyreum.itemizerdre.command.lore.LoreCommand;
import de.fyreum.itemizerdre.command.sign.SignCommand;

public class ICommandCache extends DRECommandCache {

    public static final String LABEL = "itemizerdre";

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

    public ICommandCache(DREPlugin plugin) {
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
