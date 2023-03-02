package net.yakoro.yakoromod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.yakoro.yakoromod.YakoroMod;
import net.yakoro.yakoromod.item.custom.ExplosiveGunItem;
import net.yakoro.yakoromod.item.toolmaterial.CordieriteToolMaterialPickaxe;
import net.yakoro.yakoromod.item.toolmaterial.CordieriteToolMaterialSword;
import net.yakoro.yakoromod.item.custom.HealingStaffItem;
import net.yakoro.yakoromod.item.toolmaterial.MyPickaxeItem;

public class ModItems {

    public static final Item RAW_CORDIERITE = registerItem("raw_cordierite",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.CORDIERITE)));
    public static final Item CORDIERITE = registerItem("cordierite",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.CORDIERITE)));

    public static final Item CORDIERITE_SWORD = registerItem("cordierite_sword",
            new SwordItem(CordieriteToolMaterialSword.INSTANCE, 20, -2f, new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.CORDIERITE)));
    public static final Item HEALING_STAFF = registerItem("healing_staff",
            new HealingStaffItem(new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.CORDIERITE)));

    public static final Item CORDIERITE_PICKAXE = registerItem("cordierite_pickaxe",
            new MyPickaxeItem(CordieriteToolMaterialPickaxe.INSTANCE2,2,-2f, new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.CORDIERITE)));

    public static final Item EXPLOSIVE_GUN = registerItem("explosive_gun",
            new ExplosiveGunItem(new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.CORDIERITE)));

    public static final Item URANIUM_BALL = registerItem("uranium_ball",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.CORDIERITE)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(YakoroMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        YakoroMod.LOGGER.debug("Registering Mod Items for " + YakoroMod.MOD_ID);
    }


}
