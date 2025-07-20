package com.jinxedstudios.hellwalker.event;

import com.jinxedstudios.hellwalker.HellwalkerEngine;
import com.jinxedstudios.hellwalker.entities.PossessedScientistEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

@EventBusSubscriber(modid = HellwalkerEngine.MODID)
public class DamageHandler {

    @SubscribeEvent
    public static void onLivingDamage(LivingIncomingDamageEvent event) {
        if (event.getEntity() instanceof PossessedScientistEntity) {
            if ("drown".equals(event.getSource().getMsgId())) {
                event.setCanceled(true); // Cancel drowning damage dynamically
            }
        }
    }
}
