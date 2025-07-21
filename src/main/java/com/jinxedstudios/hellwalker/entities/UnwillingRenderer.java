package com.jinxedstudios.hellwalker.entities;

import com.jinxedstudios.hellwalker.HellwalkerEngine;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class UnwillingRenderer extends MobRenderer<UnwillingEntity, UnwillingModel<UnwillingEntity>> {
    public UnwillingRenderer(EntityRendererProvider.Context context) {
        super(context, new UnwillingModel<>(context.bakeLayer(UnwillingModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(UnwillingEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(HellwalkerEngine.MODID, "textures/entity/unwilling.png");
    }
}
