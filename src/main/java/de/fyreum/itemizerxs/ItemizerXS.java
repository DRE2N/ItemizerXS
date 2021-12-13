package de.fyreum.itemizerxs;

import de.erethon.commons.javaplugin.DREPlugin;
import de.erethon.commons.javaplugin.DREPluginSettings;
import de.fyreum.itemizerxs.command.logic.ICommandCache;

public final class ItemizerXS extends DREPlugin {

    private static ItemizerXS instance;
    private ICommandCache iCommandCache;

    public ItemizerXS() {
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

    public static ItemizerXS inst() {
        return instance;
    }
}
