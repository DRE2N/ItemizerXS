package de.fyreum.itemizerdre;

import de.erethon.commons.javaplugin.DREPlugin;
import de.erethon.commons.javaplugin.DREPluginSettings;
import de.fyreum.itemizerdre.command.logic.ICommandCache;

public final class ItemizerDRE extends DREPlugin {

    private static ItemizerDRE instance;
    private ICommandCache iCommandCache;

    public ItemizerDRE() {
        settings = DREPluginSettings.builder()
                .paper(true)
                .spigot(true)
                .build();
    }

    @Override
    public void onEnable() {
        super.onEnable();

        instance = this;

        this.iCommandCache = new ICommandCache(this);
        setCommandCache(iCommandCache);
        iCommandCache.register(this);
    }

    @Override
    public void onDisable() {

    }

    public ICommandCache getICommandCache() {
        return iCommandCache;
    }

    public static ItemizerDRE inst() {
        return instance;
    }
}
