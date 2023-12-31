package io.github.yuko1101.neoportalsfixer.forge;

import dev.architectury.platform.forge.EventBuses;
import io.github.yuko1101.neoportalsfixer.NeoPortalsFixer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(NeoPortalsFixer.MOD_ID)
public class NeoPortalsFixerForge {
    public NeoPortalsFixerForge() {
		// Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(NeoPortalsFixer.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        NeoPortalsFixer.init();
    }
}