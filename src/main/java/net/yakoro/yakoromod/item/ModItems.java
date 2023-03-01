package net.yakoro.yakoromod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.yakoro.yakoromod.YakoroMod;
import net.yakoro.yakoromod.item.toolmaterial.CordieriteToolMaterial;
import net.yakoro.yakoromod.item.toolmaterial.custom.HealingStaffItem;

public class ModItems {

    public static final Item RAW_CORDIERITE = registerItem("raw_cordierite",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.CORDIERITE)));
    public static final Item CORDIERITE = registerItem("cordierite",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.CORDIERITE)));

    public static final Item CORDIERITE_SWORD = registerItem("cordierite_sword",
            new SwordItem(CordieriteToolMaterial.INSTANCE, 20, -2f, new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.CORDIERITE)));
    public static final Item HEALING_STAFF = registerItem("healing_staff",
            new HealingStaffItem(new FabricItemSettings().group(ItemGroup.MISC).group(ModItemGroup.CORDIERITE)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(YakoroMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        YakoroMod.LOGGER.debug("Registering Mod Items for " + YakoroMod.MOD_ID);
    }



}
