package com.jinxedstudios.hellwalker.entities;

import com.jinxedstudios.hellwalker.HellwalkerEngine;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class HellwalkerEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, HellwalkerEngine.MODID);

    public static final Supplier<EntityType<PossessedScientistEntity>> POSSESSED_SCIENTIST =
            ENTITY_TYPES.register("possessed_scientist", () -> EntityType.Builder.of(PossessedScientistEntity::new, MobCategory.MONSTER)
                    .sized(1f, 1.8f).build("possessed_scientist"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);

    }
}