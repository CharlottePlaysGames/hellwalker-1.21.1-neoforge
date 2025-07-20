package com.jinxedstudios.hellwalker.entities;

import com.jinxedstudios.hellwalker.HellwalkerEngine;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;

public class PossessedScientistRenderer extends MobRenderer<PossessedScientistEntity, PossessedScientistModel<PossessedScientistEntity>> {
    public PossessedScientistRenderer(EntityRendererProvider.Context context) {
        super(context, new PossessedScientistModel<>(context.bakeLayer(PossessedScientistModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(PossessedScientistEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(HellwalkerEngine.MODID, "textures/entity/possessed_scientist.png");
    }
}
