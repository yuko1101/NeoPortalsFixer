package io.github.yuko1101.neoportalsfixer.forge;

import net.minecraft.block.Block;

public class NeoPortalsFixerImpl {
    public static Block getDummyPortalBlock() {
        return NeoPortalsFixerForge.DUMMY_PORTAL_BLOCK.get();
    }

    public static Block getDummyNetherPortalBlock() {
        return NeoPortalsFixerForge.DUMMY_NETHER_PORTAL_BLOCK.get();
    }
}
