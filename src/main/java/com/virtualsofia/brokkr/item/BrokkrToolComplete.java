package com.virtualsofia.brokkr.item;

import net.minecraft.world.item.Item;

import java.util.List;

public class BrokkrToolComplete extends Item {
    public BrokkrToolComplete(Properties properties) {
        super(properties
                .stacksTo(1)
        );

    }
    public record ToolPieceComponent(String material, String part) {}
    public record ToolComponent(List<ToolPieceComponent> pieces) {}
}
