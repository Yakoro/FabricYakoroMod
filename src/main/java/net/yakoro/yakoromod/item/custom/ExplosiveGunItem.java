package net.yakoro.yakoromod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.yakoro.yakoromod.entity.custom.ExplosiveProjectileEntity;
import net.yakoro.yakoromod.item.ModItems;

public class ExplosiveGunItem extends Item {

    public ExplosiveGunItem(Settings settings) {
        super(settings);
    }

    //public ExplosiveGunItem(Item.Settings settings) { super(settings); }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_DRAGON_FIREBALL_EXPLODE, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));


        if (!world.isClient) {
            ExplosiveProjectileEntity explosiveProjectileEntity = new ExplosiveProjectileEntity(world, user);
            explosiveProjectileEntity.setItem(ModItems.URANIUM_BALL.getDefaultStack());
            explosiveProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 1.5f, 1.0f);
            world.spawnEntity(explosiveProjectileEntity);
        }
        user.incrementStat(Stats.USED.getOrCreateStat(this));

        return TypedActionResult.success(itemStack, world.isClient());
    }
}