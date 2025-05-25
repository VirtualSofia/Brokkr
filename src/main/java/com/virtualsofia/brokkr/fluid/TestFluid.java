package com.virtualsofia.brokkr.fluid;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import org.jetbrains.annotations.NotNull;

public class TestFluid extends BaseFlowingFluid {


    protected TestFluid(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isSource(@NotNull FluidState state) {
        return false;
    }

    @Override
    public int getAmount(FluidState state) {
        return state.getValue(LEVEL);
    }

    public @NotNull Item getBucket() {
        return Items.AIR;
    }

    public static class Source extends TestFluid
    {
        public Source(Properties properties) {
            super(properties);
        }
        public int getAmount(FluidState state) {
            return 8;
        }
        public boolean isSource(@NotNull FluidState state) {
            return true;
        }
    }

    public static class Flowing extends TestFluid
    {
        public Flowing(Properties properties) {
            super(properties);
            registerDefaultState(getStateDefinition().any().setValue(LEVEL, 7));
        }
        protected void createFluidStateDefinition(StateDefinition.@NotNull Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

    }
}
