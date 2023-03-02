package net.yakoro.yakoromod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HealingStaffItem extends Item {

    public HealingStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!user.world.isClient() && hand == Hand.MAIN_HAND) {
            if(!entity.isPlayer()) {
                entity.takeKnockback(8, user.getX() - entity.getX(), user.getZ() - entity.getZ());
            }
            if(entity.isPlayer()) {
                entity.heal(6);
                user.getItemCooldownManager().set(this, 20);
            }
        }
        return super.useOnEntity(stack, user, entity, hand);
    }

    /*public ActionResult useOnBlock(ItemStack stack, PlayerEntity user, Block block, Hand hand) {
        if (!user.world.isClient() && hand == Hand.MAIN_HAND) {
            user.takeKnockback(4, user.getX() - getBlockPosition(block, world) .);
        }
        return ActionResult.PASS;
    }

    private BlockPos getBlockPosition(Block block, World world) {
        BlockPos pos = null;
        if (world != null) {
            for (int x = -300; x < 300; x++) {
                for (int y = 0; y < 256; y++) {
                    for (int z = -300; z < 300; z++) {
                        BlockPos blockPos = new BlockPos(x, y, z);
                        if (world.getBlockState(blockPos).getBlock() == block) {
                            pos = blockPos;
                            break;
                        }
                    }
                }
            }
        }
        return pos;
    }*/

}




