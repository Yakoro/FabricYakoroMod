package net.yakoro.yakoromod.item.toolmaterial.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

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
            entity.takeKnockback(4, user.getX()-entity.getX(), user.getZ()-entity.getZ());
        }
        return super.useOnEntity(stack, user, entity, hand);
    }
}
