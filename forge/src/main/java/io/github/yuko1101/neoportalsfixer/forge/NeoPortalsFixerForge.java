package io.github.yuko1101.neoportalsfixer.forge;

import io.github.yuko1101.neoportalsfixer.NeoPortalsFixer;
import io.github.yuko1101.neoportalsfixer.portal.DummyNetherPortalBlock;
import io.github.yuko1101.neoportalsfixer.portal.DummyPortalBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(NeoPortalsFixer.MOD_ID)
public class NeoPortalsFixerForge {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NeoPortalsFixer.MOD_ID);
    protected static final RegistryObject<Block> DUMMY_PORTAL_BLOCK = BLOCKS.register(DummyPortalBlock.ID, () -> new DummyPortalBlock(AbstractBlock.Settings.create()));
    protected static final RegistryObject<Block> DUMMY_NETHER_PORTAL_BLOCK = BLOCKS.register(DummyNetherPortalBlock.ID, () -> new DummyNetherPortalBlock(AbstractBlock.Settings.create()));

    public NeoPortalsFixerForge() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        NeoPortalsFixer.init();
    }
}