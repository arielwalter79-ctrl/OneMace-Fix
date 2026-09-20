package com.thegreenvillagesmp.onemace.mixin;

import com.thegreenvillagesmp.onemace.OneMace;
import net.minecraft.block.entity.HopperBlockEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(HopperBlockEntity.class)
public abstract class HopperBlockEntityMixin {
 @Inject(method="canInsert", at=@At("HEAD"), cancellable=true)
 private static void oneMace$rejectMaceInsert(
   Inventory inventory, ItemStack stack, int slot, Direction side,
   CallbackInfoReturnable<Boolean> cir) {
  if (OneMace.isMace(stack)) cir.setReturnValue(false);
 }
}