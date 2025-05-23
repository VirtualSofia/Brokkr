package com.virtualsofia.brokkr.block;

import com.virtualsofia.brokkr.Brokkr;
import com.virtualsofia.brokkr.fluid.TestFluid;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import com.virtualsofia.brokkr.fluid.FluidRegistry;

public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Brokkr.MODID);

    //The TestFluidBlock class should be able to work for any fluid, could be changed to BaseFluidBlock
    public static final DeferredBlock<TestFluidBlock> TEST_FLUID_BLOCK
            = BLOCKS.register("test_fluid_block",
            () -> new TestFluidBlock(FluidRegistry.SOURCE_TEST_FLUID,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA).speedFactor(0.5f).noLootTable()));
    
}


