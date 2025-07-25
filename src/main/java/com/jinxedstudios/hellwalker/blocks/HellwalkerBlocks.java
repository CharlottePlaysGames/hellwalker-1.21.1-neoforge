package com.jinxedstudios.hellwalker.blocks;

import com.jinxedstudios.hellwalker.HellwalkerEngine;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HellwalkerBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(HellwalkerEngine.MODID);

    public static final DeferredBlock<Block> EXAMPLE_BLOCK = BLOCKS.registerSimpleBlock("example_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE));


    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
