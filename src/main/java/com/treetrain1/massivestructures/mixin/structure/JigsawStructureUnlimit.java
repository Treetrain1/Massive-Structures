package com.treetrain1.massivestructures.mixin.structure;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.treetrain1.massivestructures.MassiveStructures;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = JigsawStructure.class, priority = 999)
public class JigsawStructureUnlimit {

    @WrapOperation(method = "method_41662", at = @At(value = "INVOKE", target = "Lcom/mojang/serialization/Codec;intRange(II)Lcom/mojang/serialization/Codec;"))
    private static Codec<Integer> replaceIntRange(int minInclusive, int maxInclusive, Operation<Codec<Integer>> original) {
        return Codec.INT;
    }

    @ModifyConstant(method = "<init>(Lnet/minecraft/world/level/levelgen/structure/Structure$StructureSettings;Lnet/minecraft/core/Holder;ILnet/minecraft/world/level/levelgen/heightproviders/HeightProvider;Z)V", constant = @Constant(intValue = 80), require = 0)
    private static int init1(int value) {
        return MassiveStructures.NEW_STRUCTURE_SIZE;
    }

    @ModifyConstant(method = "<init>(Lnet/minecraft/world/level/levelgen/structure/Structure$StructureSettings;Lnet/minecraft/core/Holder;ILnet/minecraft/world/level/levelgen/heightproviders/HeightProvider;ZLnet/minecraft/world/level/levelgen/Heightmap$Types;)V", constant = @Constant(intValue = 80), require = 0)
    private static int init2(int value) {
        return MassiveStructures.NEW_STRUCTURE_SIZE;
    }

    @ModifyConstant(method = "verifyRange", constant = @Constant(intValue = 128), require = 0)
    private static int maxDistanceFromCenter(int value) {
        return MassiveStructures.NEW_STRUCTURE_SIZE;
    }

    @ModifyConstant(method = "method_49541", constant = @Constant(stringValue = "Structure size including terrain adaptation must not exceed 128"), require = 0)
    private static String maxDistanceFromCenter(String value) {
        return "Structure size including terrain adaptation must not exceed 4096";
    }
}
