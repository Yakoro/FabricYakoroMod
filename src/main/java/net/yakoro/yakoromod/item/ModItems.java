package net.yakoro.yakoromod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.yakoro.yakoromod.YakoroMod;

public class ModItems {

    public static final Item RAW_CORDIERITE = registerItem("raw_cordierite.json",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item CORDIERITE = registerItem("cordierite.json",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(YakoroMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        YakoroMod.LOGGER.debug("Registering Mod Items for " + YakoroMod.MOD_ID);
    }



}
