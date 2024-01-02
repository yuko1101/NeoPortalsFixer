package io.github.yuko1101.neoportalsfixer.portal;

import io.github.yuko1101.neoportalsfixer.mixin.MixinEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.decoration.DisplayEntity;
import net.minecraft.item.DyeableHorseArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.List;
import java.util.Objects;

public class PortalHandler {

    public static @Nullable Color lastColor = null;

    public static @Nullable Color getPortalBlockColor() {
        final World world = MinecraftClient.getInstance().world;
        final ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (world == null || player == null) {
            return null;
        }

        if (!((MixinEntity) player).getInNetherPortal()) {
            return lastColor;
        }

        final List<DisplayEntity.ItemDisplayEntity> itemDisplays = world.getEntitiesByClass(DisplayEntity.ItemDisplayEntity.class, player.getBoundingBox().expand(1), entity -> {
            final DisplayEntity.ItemDisplayEntity.Data data = entity.getData();
            if (data == null) return false;

            final ItemStack itemStack = data.itemStack();
            if (itemStack == null || itemStack.getNbt() == null) return false;

            final int customModelData = itemStack.getNbt().getInt("CustomModelData");
            if (customModelData != 3213) return false;

            // default nether portal
            if (itemStack.getItem() == Items.GOLDEN_HORSE_ARMOR) return true;

            if (itemStack.getItem() != Items.LEATHER_HORSE_ARMOR) return false;
            return itemStack.hasCustomName() && itemStack.getName().getString().equals("NeoPortals");
        });
        if (itemDisplays.isEmpty()) {
            return lastColor;
        }

        DisplayEntity.ItemDisplayEntity result = itemDisplays.get(0);
        for (DisplayEntity.ItemDisplayEntity itemDisplayEntity : itemDisplays) {
            if (getDistance(player, itemDisplayEntity) < getDistance(player, result)) {
                result = itemDisplayEntity;
            }
        }

        final ItemStack itemStack = Objects.requireNonNull(result.getData()).itemStack();

        if (itemStack.getItem() == Items.GOLDEN_HORSE_ARMOR) {
            lastColor = null;
            return lastColor;
        }

        lastColor = new Color(((DyeableHorseArmorItem) itemStack.getItem()).getColor(itemStack));
        return lastColor;
    }

    private static double getDistance(ClientPlayerEntity player, DisplayEntity.ItemDisplayEntity itemDisplayEntity) {
        return player.getPos().distanceTo(itemDisplayEntity.getPos());
    }

}
