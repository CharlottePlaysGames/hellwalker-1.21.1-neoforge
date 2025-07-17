package com.jinxedstudios.hellwalker.creativetabs;

import com.jinxedstudios.hellwalker.HellwalkerEngine;
import com.jinxedstudios.hellwalker.items.HellwalkerItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HellwalkerCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HellwalkerEngine.MODID);


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> HELLWALKER_ITEMS = CREATIVE_MODE_TABS.register("hellwalker_items", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.hellwalker_items")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> HellwalkerItems.BLUE_ACCESS_KEY.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(HellwalkerItems.BLUE_ACCESS_KEY.get());
                output.accept(HellwalkerItems.YELLOW_ACCESS_KEY.get());
                output.accept(HellwalkerItems.PRAETOR_TOKEN.get());
                output.accept(HellwalkerItems.DATA_LOG.get());
            }).build());
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> HELLWALKER_BLOCKS = CREATIVE_MODE_TABS.register("hellwalker_blocks", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.hellwalker_blocks")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> HellwalkerItems.BLUE_ACCESS_KEY.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
            }).build());
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> HELLWALKER_ENEMIES = CREATIVE_MODE_TABS.register("hellwalker_enemies", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.hellwalker_enemies")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> HellwalkerItems.BLUE_ACCESS_KEY.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
            }).build());
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> HELLWALKER_WEAPONS = CREATIVE_MODE_TABS.register("hellwalker_weapons", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.hellwalker_weapons")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> HellwalkerItems.BLUE_ACCESS_KEY.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
            }).build());
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> HELLWALKER_ARMOR = CREATIVE_MODE_TABS.register("hellwalker_armor", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.hellwalker_armor")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> HellwalkerItems.BLUE_ACCESS_KEY.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
            }).build());



    public static void register(IEventBus modEventBus) {
        CREATIVE_MODE_TABS.register(modEventBus);


    }
}
