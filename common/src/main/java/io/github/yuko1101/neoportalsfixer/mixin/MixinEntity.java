package io.github.yuko1101.neoportalsfixer.mixin;

import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Entity.class)
public interface MixinEntity {
    @Accessor
    boolean getInNetherPortal();
}
