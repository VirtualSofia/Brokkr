package com.virtualsofia.brokkr.item;

import com.virtualsofia.brokkr.Brokkr;
import com.virtualsofia.brokkr.datamaps.ExampleData;
import net.minecraft.core.Holder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import static com.virtualsofia.brokkr.datamaps.ExampleData.EXAMPLE_DATA;

public class TestItem extends Item {
    public TestItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {

        Holder<Item> holder = context.getItemInHand().getItemHolder();
        ExampleData data = holder.getData(EXAMPLE_DATA);
        if (data != null) {
            Brokkr.LOGGER.info("test" + String.valueOf(data.chance()));
        }
        else {
            Brokkr.LOGGER.info("Fail");
        }
        return InteractionResult.SUCCESS;


    }
}
