package net.spacetimebab.mhef.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.spacetimebab.mhef.MHEF;
import net.spacetimebab.mhef.entity.custom.AptonothEntity;
import net.spacetimebab.mhef.entity.custom.NargacugaEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AptonothModel extends AnimatedGeoModel<AptonothEntity> {

    @Override
    public ResourceLocation getModelResource(AptonothEntity object) {
        return new ResourceLocation(MHEF.MOD_ID, "geo/aptonoth.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AptonothEntity object) {
        return new ResourceLocation(MHEF.MOD_ID, "textures/entity/aptonoth/aptonoth.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AptonothEntity animatable) {
        return new ResourceLocation(MHEF.MOD_ID, "animations/aptonoth.animation.json");
    }
}
