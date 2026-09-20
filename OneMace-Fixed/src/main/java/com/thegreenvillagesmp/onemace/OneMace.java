package com.thegreenvillagesmp.onemace;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;

public class OneMace implements ModInitializer {
 public static boolean isMace(ItemStack stack) {
  return stack != null && stack.isOf(Items.MACE);
 }
 @Override public void onInitialize() {
  UseBlockCallback.EVENT.register((player, world, hand, hit) -> {
   if (isMace(player.getStackInHand(hand))
       && world.getBlockState(hit.getBlockPos()).isOf(Blocks.DECORATED_POT)) {
    return ActionResult.FAIL;
   }
   return ActionResult.PASS;
  });
  System.out.println("[OneMace] Loaded v1.1.0");
 }
}