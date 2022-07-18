package net.spacetimebab.mhef.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.spacetimebab.mhef.MHEF;
import net.spacetimebab.mhef.entity.custom.ApcerosEntity;
import net.spacetimebab.mhef.entity.custom.AptonothEntity;
import net.spacetimebab.mhef.entity.custom.NargacugaEntity;
import net.spacetimebab.mhef.entity.custom.PopoEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ApcerosModel extends AnimatedGeoModel<ApcerosEntity> {

    @Override
    public ResourceLocation getModelResource(ApcerosEntity object) {
        return new ResourceLocation(MHEF.MOD_ID, "geo/apceros.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ApcerosEntity object) {
        return new ResourceLocation(MHEF.MOD_ID, "textures/entity/apceros/apceros.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ApcerosEntity animatable) {
        return new ResourceLocation(MHEF.MOD_ID, "animations/apceros.animation.json");
    }
}
