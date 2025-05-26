package com.virtualsofia.brokkr.block;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.pathfinder.PathComputationType;
import org.jetbrains.annotations.NotNull;

public class BaseFluidBlock extends LiquidBlock {
   

    @Deprecated
    public BaseFluidBlock(FlowingFluid flowingFluid, BlockBehaviour.Properties properties) {
        super(flowingFluid, properties);
    }

    public BaseFluidBlock(java.util.function.Supplier<? extends FlowingFluid> supplier,
                          BlockBehaviour.Properties properties) {
        super(supplier.get(), properties);
    }

    @Override
    protected boolean isPathfindable(@NotNull BlockState state, @NotNull PathComputationType type) {
        return false;
    }


}
