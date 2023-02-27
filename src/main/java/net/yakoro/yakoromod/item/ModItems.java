package net.yakoro.yakoromod.item;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.yakoro.yakoromod.YakoroMod;

public class ModItems {





    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(YakoroMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        YakoroMod.LOGGER.debug("Registering Mod Items for " + YakoroMod.MOD_ID);
    }



}
