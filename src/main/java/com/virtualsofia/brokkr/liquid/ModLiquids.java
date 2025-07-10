package com.virtualsofia.brokkr.liquid;

import com.virtualsofia.brokkr.Brokkr;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import com.tterrag.registrate.builders.FluidBuilder.FluidTypeFactory;
import com.tterrag.registrate.util.entry.FluidEntry;

public class ModLiquids {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Brokkr.MODID);

    public static final DeferredBlock moltenIron = BLOCKS.registerSimpleBlock("molten_iron",BlockBehaviour.Properties.of().liquid());

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
