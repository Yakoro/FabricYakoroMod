package net.yakoro.yakoromod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.yakoro.yakoromod.block.ModBlocks;

public class YakoroModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HEARTBEETROOTS_CROP, RenderLayer.getCutout());
    }
}
