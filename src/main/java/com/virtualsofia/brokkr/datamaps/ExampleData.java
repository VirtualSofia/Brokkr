package com.virtualsofia.brokkr.datamaps;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.datamaps.DataMapType;

public record ExampleData(float amount, float chance) {
    public static final Codec<ExampleData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.FLOAT.fieldOf("amount").forGetter(ExampleData::amount),
            Codec.floatRange(0, 1).fieldOf("chance").forGetter(ExampleData::chance)
    ).apply(instance, ExampleData::new));


    // In this example, we register the data map for the minecraft:item registry, hence we use Item as the generic.
// Adjust the types accordingly if you want to create a data map for a different registry.
    public static final DataMapType<Item, ExampleData> EXAMPLE_DATA = DataMapType.builder(
            // The ID of the data map. Data map files for this data map will be located at
            // <yourmodid>:examplemod/data_maps/item/example_data.json.
            ResourceLocation.fromNamespaceAndPath("brokkr", "example_data"),
            // The registry to register the data map for.
            Registries.ITEM,
            // The codec of the data map entries.
            ExampleData.CODEC
    ).build();
}