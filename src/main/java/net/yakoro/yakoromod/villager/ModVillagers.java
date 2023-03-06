package net.yakoro.yakoromod.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import net.yakoro.yakoromod.YakoroMod;
import net.yakoro.yakoromod.block.ModBlocks;
import net.yakoro.yakoromod.item.ModItems;

public class ModVillagers {
    public static final PointOfInterestType HEAL_POI = registerPOI("heal_poi", ModBlocks.HEAL_BLOCK);
    public static final VillagerProfession NURSE = registerProfession("nurse",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(YakoroMod.MOD_ID, "heal_poi")));

    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registry.VILLAGER_PROFESSION, new Identifier(YakoroMod.MOD_ID, name),
                VillagerProfessionBuilder.create().id(new Identifier(YakoroMod.MOD_ID, name)).workstation(type)
                        .workSound(SoundEvents.ENTITY_VILLAGER_WORK_CLERIC).build());
    }

    public static PointOfInterestType registerPOI(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(YakoroMod.MOD_ID, name),
                1,1, ImmutableSet.copyOf(block.getStateManager().getStates()));
    }
    public static void registerVillagers() {
        YakoroMod.LOGGER.debug("Registering Villagers for " + YakoroMod.MOD_ID);
    }

    public static void registerTrades() {
        TradeOfferHelper.registerVillagerOffers(NURSE, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 20),
                            new ItemStack(ModItems.HEARTBEETROOTS_SEEDS, 1), 1, 10, 0.02f
                    )));
                });
    }
}
