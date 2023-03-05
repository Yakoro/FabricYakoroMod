package net.yakoro.yakoromod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.yakoro.yakoromod.item.ModItems;

public class HeartBeetrootsCropBlock extends CropBlock {

    public static final IntProperty AGE = IntProperty.of("age", 0, 3);

    public HeartBeetrootsCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.HEARTBEETROOTS_SEEDS;
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

}
