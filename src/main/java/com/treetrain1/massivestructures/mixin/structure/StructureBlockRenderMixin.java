package com.treetrain1.massivestructures.mixin.structure;

import com.treetrain1.massivestructures.MassiveStructures;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.entity.StructureBlockBlockEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = StructureBlockBlockEntityRenderer.class, priority = 999)
public class StructureBlockRenderMixin {

    /**
     * @reason Increase the distance that the bounding box can be seen up to 2048 blocks
     * @author SamB440/Cotander
     */
    @ModifyConstant(method = "getRenderDistance", constant = @Constant(intValue = 96), require = 0)
    @Environment(EnvType.CLIENT)
    public int getRenderDistance(int value) {
        return MassiveStructures.NEW_STRUCTURE_SIZE / 2;
    }
}