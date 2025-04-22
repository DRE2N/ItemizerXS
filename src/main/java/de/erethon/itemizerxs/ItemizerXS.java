package de.erethon.itemizerxs;

import de.erethon.bedrock.compatibility.Internals;
import de.erethon.bedrock.plugin.EPlugin;
import de.erethon.bedrock.plugin.EPluginSettings;
import de.erethon.itemizerxs.command.logic.ICommandCache;

public final class ItemizerXS extends EPlugin {

    private static ItemizerXS instance;
    private ICommandCache iCommandCache;

    public ItemizerXS() {
        settings = EPluginSettings.builder()
                .internals(Internals.v1_18_R2.andHigher())
                .permissions(true)
                .build();
    }

    @Override
    public void onEnable() {
        super.onEnable();

        instance = this;

        getBedrockMessageHandler().setDefaultLanguage("german");

        this.iCommandCache = new ICommandCache(this, compat.isPapyrus());
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
