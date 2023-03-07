package net.yakoro.yakoromod;

import net.fabricmc.api.ModInitializer;
import net.yakoro.yakoromod.block.ModBlocks;
import net.yakoro.yakoromod.item.ModItems;
import net.yakoro.yakoromod.villager.ModVillagers;
import net.yakoro.yakoromod.world.feature.ModConfiguredFeatures;
import net.yakoro.yakoromod.world.gen.ModOreGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class YakoroMod implements ModInitializer {
	public static final String MOD_ID = "yakoromod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModConfiguredFeatures.registerConfiguredFeatures();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

        ModVillagers.registerVillagers();
		ModVillagers.registerTrades();
		ModOreGeneration.generateOres();

	}
}
