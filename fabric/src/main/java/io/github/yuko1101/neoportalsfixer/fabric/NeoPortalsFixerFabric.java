package io.github.yuko1101.neoportalsfixer.fabric;

import io.github.yuko1101.neoportalsfixer.NeoPortalsFixer;
import io.github.yuko1101.neoportalsfixer.portal.DummyPortalBlock;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class NeoPortalsFixerFabric implements ClientModInitializer {

    final static Block DUMMY_PORTAL_BLOCK = Registry.register(Registries.BLOCK, new Identifier(NeoPortalsFixer.MOD_ID, DummyPortalBlock.ID), new DummyPortalBlock(FabricBlockSettings.create()));

    @Override
    public void onInitializeClient() {
        NeoPortalsFixer.init();
    }
}