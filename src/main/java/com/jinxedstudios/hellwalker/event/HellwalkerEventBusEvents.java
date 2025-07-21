package com.jinxedstudios.hellwalker.event;

import com.jinxedstudios.hellwalker.HellwalkerEngine;
import com.jinxedstudios.hellwalker.entities.*;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.EntityInvulnerabilityCheckEvent;

@EventBusSubscriber(modid = HellwalkerEngine.MODID)
public class HellwalkerEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(PossessedScientistModel.LAYER_LOCATION, PossessedScientistModel::createBodyLayer);
        event.registerLayerDefinition(UnwillingModel.LAYER_LOCATION, UnwillingModel::createBodyLayer);
    }
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(HellwalkerEntities.POSSESSED_SCIENTIST.get(), PossessedScientistEntity.createAttributes().build());
        event.put(HellwalkerEntities.UNWILLING.get(), UnwillingEntity.createAttributes().build());
    }
}