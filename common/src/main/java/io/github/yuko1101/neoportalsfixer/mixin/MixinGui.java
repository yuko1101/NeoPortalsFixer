package io.github.yuko1101.neoportalsfixer.mixin;

import io.github.yuko1101.neoportalsfixer.NeoPortalsFixer;

import net.minecraft.block.BlockState;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.block.BlockModels;
import net.minecraft.client.texture.Sprite;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(InGameHud.class)
public class MixinGui {
    @Redirect(method = "renderPortalOverlay", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;setShaderColor(FFFF)V", ordinal = 0))
    public void renderCustomPortalOverlay(DrawContext instance, float red, float green, float blue, float alpha) {
        instance.setShaderColor(1f, 0f, 0f, alpha);
    }

    @Redirect(method = "renderPortalOverlay", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/block/BlockModels;getModelParticleSprite(Lnet/minecraft/block/BlockState;)Lnet/minecraft/client/texture/Sprite;"))
    public Sprite renderCustomPortalOverlay(BlockModels instance, BlockState state) {
        final BlockState dummyPortalState = NeoPortalsFixer.getDummyPortalBlock().getDefaultState();
        return instance.getModelParticleSprite(dummyPortalState);
    }
}
