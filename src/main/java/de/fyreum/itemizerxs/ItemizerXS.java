package de.fyreum.itemizerxs;

import de.erethon.bedrock.compatibility.Internals;
import de.erethon.bedrock.plugin.EPlugin;
import de.erethon.bedrock.plugin.EPluginSettings;
import de.fyreum.itemizerxs.command.logic.ICommandCache;

public final class ItemizerXS extends EPlugin {

    private static ItemizerXS instance;
    private ICommandCache iCommandCache;

    public ItemizerXS() {
        settings = EPluginSettings.builder()
                .internals(Internals.v1_17_R1.andHigher())
                .permissions(true)
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
