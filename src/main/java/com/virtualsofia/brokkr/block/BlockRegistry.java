package com.virtualsofia.brokkr.block;

import com.virtualsofia.brokkr.Brokkr;
import com.virtualsofia.brokkr.fluid.TestFluid;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import com.virtualsofia.brokkr.fluid.FluidRegistry;

public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Brokkr.MODID);


    public static final DeferredBlock<LiquidBlock> TEST_FLUID_BLOCK
            = BLOCKS.register("test_fluid_block",
            () -> new LiquidBlock((FlowingFluid) FluidRegistry.SOURCE_TEST_FLUID,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA).speedFactor(0.5f).noLootTable()));
    
}


