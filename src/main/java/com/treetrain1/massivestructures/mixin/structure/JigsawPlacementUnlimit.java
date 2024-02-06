package com.treetrain1.massivestructures.mixin.structure;

import com.treetrain1.massivestructures.MassiveStructures;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = JigsawPlacement.class, priority = 999)
public class JigsawPlacementUnlimit {

    @ModifyConstant(method = "generateJigsaw", constant = @Constant(intValue = 128), require = 0)
    private static int changeMaxGenDistance(int value) {
        return MassiveStructures.NEW_STRUCTURE_SIZE;
    }
}