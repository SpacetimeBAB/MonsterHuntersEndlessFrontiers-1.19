package net.spacetimebab.mhef.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.spacetimebab.mhef.MHEF;
import net.spacetimebab.mhef.entity.custom.NargacugaEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class NargacugaModel extends AnimatedGeoModel<NargacugaEntity> {

    @Override
    public ResourceLocation getModelResource(NargacugaEntity object) {
        return new ResourceLocation(MHEF.MOD_ID, "geo/nargacuga.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NargacugaEntity object) {
        return new ResourceLocation(MHEF.MOD_ID, "textures/entity/nargacuga/nargacuga.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NargacugaEntity animatable) {
        return new ResourceLocation(MHEF.MOD_ID, "animations/nargacuga.animation.json");
    }
}
