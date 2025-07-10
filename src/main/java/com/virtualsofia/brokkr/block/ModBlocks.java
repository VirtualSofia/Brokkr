package com.virtualsofia.brokkr.block;

import com.virtualsofia.brokkr.Brokkr;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Brokkr.MODID);


    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}


