package com.virtualsofia.brokkr.fluid;

import com.virtualsofia.brokkr.Brokkr;
import com.virtualsofia.brokkr.block.ModBlocks;
import com.virtualsofia.brokkr.fluid.ModFluidTypes;
import com.virtualsofia.brokkr.fluid.TestFluid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredRegister;


import java.util.function.Supplier;

public class FluidRegistry {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(BuiltInRegistries.FLUID, Brokkr.MODID);


    public static final Supplier<BaseFlowingFluid> SOURCE_TEST_FLUID
            = FLUIDS.register("test_fluid",
            () -> new TestFluid.Source(FluidRegistry.TEST_FLUID_PROPERTIES));

    public static final Supplier<BaseFlowingFluid> FLOWING_TEST_FLUID
            = FLUIDS.register("flowing_test_fluid",
            () -> new TestFluid.Flowing(FluidRegistry.TEST_FLUID_PROPERTIES));

    public static final BaseFlowingFluid.Properties TEST_FLUID_PROPERTIES
            = new BaseFlowingFluid.Properties(
            ModFluidTypes.TEST_FLUID, SOURCE_TEST_FLUID, FLOWING_TEST_FLUID)
            .slopeFindDistance(4)
            .levelDecreasePerBlock(1)
            .tickRate(30)
            .block(ModBlocks.TEST_FLUID_BLOCK);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}