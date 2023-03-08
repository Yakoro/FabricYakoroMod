package net.yakoro.yakoromod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.yakoro.yakoromod.entity.custom.InvisibleProjectileEntity;
import net.yakoro.yakoromod.item.ModItems;

public class FireStaffItem extends Item {

    public FireStaffItem(Settings settings) {
        super(settings);
    }

    //public ExplosiveGunItem(Item.Settings settings) { super(settings); }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {



        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_BAMBOO_PLACE, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));



        if (!world.isClient) {
            InvisibleProjectileEntity invisibleProjectileEntity = new InvisibleProjectileEntity(world, user);
            invisibleProjectileEntity.setItem(ModItems.URANIUM_BALL.getDefaultStack());
            invisibleProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0f, 5f, 0f);
            world.spawnEntity(invisibleProjectileEntity);
        }
        user.incrementStat(Stats.USED.getOrCreateStat(this));


        return TypedActionResult.success(itemStack, world.isClient());
    }
}