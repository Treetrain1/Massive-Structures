package com.treetrain1.massivestructures.mixin.structure;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.treetrain1.massivestructures.MassiveStructures;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.blockentity.StructureBlockRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Environment(EnvType.CLIENT)
@Mixin(value = StructureBlockRenderer.class, priority = 999)
public class StructureBlockRenderMixin {

    @ModifyReturnValue(method = "getViewDistance", at = @At("RETURN"))
    public int getRenderDistance(int value) {
        return Math.max(value, MassiveStructures.NEW_STRUCTURE_SIZE / 2);
    }
}