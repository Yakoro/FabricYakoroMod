package net.yakoro.yakoromod.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.yakoro.yakoromod.YakoroMod;
import net.yakoro.yakoromod.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {

    public static final List<OreFeatureConfig.Target> OVERWORLD_CORDIERITE_ORE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.CORDIERITE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_CORDIERITE_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> CORDIERITE_ORE =
            ConfiguredFeatures.register("cordierite_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_CORDIERITE_ORE, 9));

    public static final List<OreFeatureConfig.Target> OVERWORLD_URANIUM_ORE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.URANIUM_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_URANIUM_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> URANIUM_ORE =
            ConfiguredFeatures.register("uranium_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_URANIUM_ORE, 9));


    public static void registerConfiguredFeatures() {
        YakoroMod.LOGGER.debug("Registering the ModConfiguredFeatures for " + YakoroMod.MOD_ID);
    }

}
