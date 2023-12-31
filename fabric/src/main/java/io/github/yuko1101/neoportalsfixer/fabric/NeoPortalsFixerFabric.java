package io.github.yuko1101.neoportalsfixer.fabric;

import io.github.yuko1101.neoportalsfixer.NeoPortalsFixer;
import net.fabricmc.api.ModInitializer;

public class NeoPortalsFixerFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        NeoPortalsFixer.init();
    }
}