package com.virtualsofia.brokkr.fluid;

import com.virtualsofia.brokkr.Brokkr;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.pathfinder.PathType;
import net.neoforged.neoforge.common.SoundAction;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.joml.Vector3f;


import java.util.function.Supplier;

public class ModFluidTypes {
    public static final ResourceLocation TEST_FLUID_STILL_RL
            = ResourceLocation.fromNamespaceAndPath(Brokkr.MODID, "block/test_fluid_still");
    public static final ResourceLocation TEST_FLUID_FLOWING_RL
            = ResourceLocation.fromNamespaceAndPath(Brokkr.MODID, "block/test_fluid_flow");
    public static final ResourceLocation TEST_FLUID_OVERLAY_RL
            = ResourceLocation.fromNamespaceAndPath(Brokkr.MODID, "misc/in_test_fluid_overlay");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, Brokkr.MODID);

    public static final Supplier<FluidType> TEST_FLUID = register("test_fluid",
            FluidType.Properties.create()
                    .canSwim(false)
                    .pathType(PathType.DAMAGE_FIRE)
                    .adjacentPathType(PathType.DANGER_FIRE)
                    .lightLevel(5)
                    .density(3000)
                    .viscosity(10)
                    .supportsBoating(true)
                    .canConvertToSource(false)
                    .canDrown(false)
                    .canPushEntity(true)
                    .motionScale(0.01f)
                    .sound(SoundAction.get("splash"), SoundEvents.HONEY_DRINK)
                    .sound(SoundAction.get("swim"), SoundEvents.HONEY_BLOCK_SLIDE)
                    .sound(SoundAction.get("wade"), SoundEvents.HONEY_DRINK));

    private static Supplier<FluidType> register(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name,
                () -> new BaseFluidType(TEST_FLUID_STILL_RL, TEST_FLUID_FLOWING_RL, TEST_FLUID_OVERLAY_RL,
                        0xA1085b61, new Vector3f(4f / 255f, 34f / 255f, 36f / 255f), properties));
    }
}