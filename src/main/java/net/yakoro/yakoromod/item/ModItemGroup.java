package net.yakoro.yakoromod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.yakoro.yakoromod.YakoroMod;

public class ModItemGroup {
    public static final ItemGroup CORDIERITE = FabricItemGroupBuilder.build(
            new Identifier(YakoroMod.MOD_ID, "cordierite"), () -> new ItemStack(ModItems.CORDIERITE));
}
