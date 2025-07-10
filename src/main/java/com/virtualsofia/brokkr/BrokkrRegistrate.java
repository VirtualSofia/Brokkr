package com.virtualsofia.brokkr;

import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.builders.FluidBuilder;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;

import java.util.function.Consumer;

public class BrokkrRegistrate extends AbstractRegistrate {
    /**
     * Construct a new Registrate for the given mod ID.
     *
     * @param modid The mod ID for which objects will be registered
     */
    protected BrokkrRegistrate(String modid) {
        super(modid);
    }

    public static BrokkrRegistrate create(String modid) {
        return new BrokkrRegistrate(modid);
    }

    /* Fluids */

//    public <T extends BaseFlowingFluid> FluidBuilder<T, BrokkrRegistrate> virtualFluid(String name,
//                                                                                       FluidBuilder.FluidTypeFactory typeFactory, NonNullFunction<BaseFlowingFluid.Properties, T> sourceFactory,
//                                                                                       NonNullFunction<BaseFlowingFluid.Properties, T> flowingFactory) {
//        return entry(name,
//                c -> new VirtualFluidBuilder<>(self(), self(), name, c, ResourceLocation.fromNamespaceAndPath(getModid(), "fluid/" + name + "_still"),
//                        ResourceLocation.fromNamespaceAndPath(getModid(), "fluid/" + name + "_flow"), typeFactory, sourceFactory, flowingFactory));
//    }
//
//    public <T extends BaseFlowingFluid> FluidBuilder<T, BrokkrRegistrate> virtualFluid(String name,
//                                                                                       ResourceLocation still, ResourceLocation flow, FluidBuilder.FluidTypeFactory typeFactory,
//                                                                                       NonNullFunction<BaseFlowingFluid.Properties, T> sourceFactory, NonNullFunction<BaseFlowingFluid.Properties, T> flowingFactory) {
//        return entry(name, c -> new VirtualFluidBuilder<>(self(), self(), name, c, still, flow, typeFactory, sourceFactory, flowingFactory));
//    }
//
//    public FluidBuilder<VirtualFluid, BrokkrRegistrate> virtualFluid(String name) {
//        return entry(name,
//                c -> new VirtualFluidBuilder<>(self(), self(), name, c,
//                        ResourceLocation.fromNamespaceAndPath(getModid(), "fluid/" + name + "_still"), ResourceLocation.fromNamespaceAndPath(getModid(), "fluid/" + name + "_flow"),
//                        BrokkrRegistrate::defaultFluidType, VirtualFluid::createSource, VirtualFluid::createFlowing));
//    }
//
//    public FluidBuilder<VirtualFluid, BrokkrRegistrate> virtualFluid(String name, ResourceLocation still,
//                                                                     ResourceLocation flow) {
//        return entry(name, c -> new VirtualFluidBuilder<>(self(), self(), name, c, still, flow,
//                BrokkrRegistrate::defaultFluidType, VirtualFluid::createSource, VirtualFluid::createFlowing));
//    }

    public FluidBuilder<BaseFlowingFluid.Flowing, BrokkrRegistrate> standardFluid(String name) {
        return fluid(name, ResourceLocation.fromNamespaceAndPath(getModid(), "fluid/" + name + "_still"), ResourceLocation.fromNamespaceAndPath(getModid(), "fluid/" + name + "_flow"));
    }

    public FluidBuilder<BaseFlowingFluid.Flowing, BrokkrRegistrate> standardFluid(String name,
                                                                                  FluidBuilder.FluidTypeFactory typeFactory) {
        return fluid(name, ResourceLocation.fromNamespaceAndPath(getModid(), "fluid/" + name + "_still"), ResourceLocation.fromNamespaceAndPath(getModid(), "fluid/" + name + "_flow"),
                typeFactory);
    }

    public static FluidType defaultFluidType(FluidType.Properties properties, ResourceLocation stillTexture,
                                             ResourceLocation flowingTexture) {
        return new FluidType(properties) {
            @Override
            public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
                consumer.accept(new IClientFluidTypeExtensions() {
                    @Override
                    public ResourceLocation getStillTexture() {
                        return stillTexture;
                    }

                    @Override
                    public ResourceLocation getFlowingTexture() {
                        return flowingTexture;
                    }
                });
            }
        };
    }
}
