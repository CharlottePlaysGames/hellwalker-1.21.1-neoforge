package com.jinxedstudios.hellwalker.items;

import com.jinxedstudios.hellwalker.HellwalkerEngine;
import com.jinxedstudios.hellwalker.entities.HellwalkerEntities;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HellwalkerItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(HellwalkerEngine.MODID);

  //  public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item", new Item.Properties().food(new FoodProperties.Builder()
       //     .alwaysEdible().nutrition(1).saturationModifier(2f).build()));

    public static final DeferredItem<Item> BLUE_ACCESS_KEY = ITEMS.registerSimpleItem("blue_access_key", new Item.Properties());
    public static final DeferredItem<Item> YELLOW_ACCESS_KEY = ITEMS.registerSimpleItem("yellow_access_key", new Item.Properties());
    public static final DeferredItem<Item> PRAETOR_TOKEN = ITEMS.registerSimpleItem("praetor_token", new Item.Properties());
    public static final DeferredItem<Item> DATA_LOG = ITEMS.registerSimpleItem("data_log", new Item.Properties());
    public static final DeferredItem<Item> POSSESSED_SCIENTIST_SPAWN_EGG = ITEMS.register("possessed_scientist_spawn_egg", () -> new DeferredSpawnEggItem(HellwalkerEntities.POSSESSED_SCIENTIST, 0xffffff, 0xffffff, new Item.Properties()));
    //public static final DeferredItem<BlockItem> EXAMPLE_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("example_block", EXAMPLE_BLOCK);



    public static void register(IEventBus modEventBus) {
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
    }
}
