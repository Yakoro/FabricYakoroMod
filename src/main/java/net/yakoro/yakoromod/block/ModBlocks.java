package net.yakoro.yakoromod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.yakoro.yakoromod.YakoroMod;

import net.minecraft.util.registry.Registry;
import net.yakoro.yakoromod.block.custom.HealBlock;
import net.yakoro.yakoromod.block.custom.UraniumBlock;
import net.yakoro.yakoromod.block.custom.UraniumOreBlock;
import net.yakoro.yakoromod.item.ModItemGroup;
import net.yakoro.yakoromod.item.ModItems;

public class ModBlocks {
    public static final Block CORDIERITE_BLOCK = registerBlock("cordierite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemGroup.CORDIERITE);
    public static final Block CORDIERITE_ORE = registerBlock("cordierite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(1,50)), ModItemGroup.CORDIERITE);
    public static final Block DEEPSLATE_CORDIERITE_ORE = registerBlock("deepslate_cordierite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
            UniformIntProvider.create(1,50)), ModItemGroup.CORDIERITE);

    public static final Block URANIUM_BLOCK = registerBlock("uranium_block",
            new UraniumBlock(FabricBlockSettings.of(Material.METAL).luminance(10).strength(4f).requiresTool()), ModItemGroup.CORDIERITE);
    public static final Block URANIUM_ORE = registerBlock("uranium_ore",
            new UraniumOreBlock(FabricBlockSettings.of(Material.STONE).luminance(10).strength(4f).requiresTool(),
                    UniformIntProvider.create(5,10)), ModItemGroup.CORDIERITE);
    public static final Block DEEPSLATE_URANIUM_ORE = registerBlock("deepslate_uranium_ore",
            new UraniumOreBlock(FabricBlockSettings.of(Material.STONE).luminance(10).strength(4f).requiresTool(),
                    UniformIntProvider.create(5,10)), ModItemGroup.CORDIERITE);

    public static final Block HEAL_BLOCK = registerBlock("heal_block",
            new HealBlock(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemGroup.CORDIERITE);


    private static Block registerBlock(String name, Block block, ItemGroup tab){
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(YakoroMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab){
        return Registry.register(Registry.ITEM, new Identifier(YakoroMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }
    public static void registerModBlocks() {
        YakoroMod.LOGGER.debug("Registering ModBlocks for " + YakoroMod.MOD_ID);
    }

}
