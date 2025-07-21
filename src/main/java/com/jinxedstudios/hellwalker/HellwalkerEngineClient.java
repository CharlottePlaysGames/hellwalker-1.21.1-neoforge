package com.jinxedstudios.hellwalker;

import com.jinxedstudios.hellwalker.entities.HellwalkerEntities;
import com.jinxedstudios.hellwalker.entities.PossessedScientistRenderer;
import com.jinxedstudios.hellwalker.entities.UnwillingRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = HellwalkerEngine.MODID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = HellwalkerEngine.MODID, value = Dist.CLIENT)
public class HellwalkerEngineClient {
    public HellwalkerEngineClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);

    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        HellwalkerEngine.LOGGER.info("HELLO FROM CLIENT SETUP");
        HellwalkerEngine.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        EntityRenderers.register(HellwalkerEntities.POSSESSED_SCIENTIST.get(), PossessedScientistRenderer::new);
        EntityRenderers.register(HellwalkerEntities.UNWILLING.get(), UnwillingRenderer::new);
    }
}
