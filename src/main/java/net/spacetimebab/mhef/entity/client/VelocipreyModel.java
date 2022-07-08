package net.spacetimebab.mhef.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.spacetimebab.mhef.MHEF;
import net.spacetimebab.mhef.entity.custom.VelocipreyEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class VelocipreyModel extends AnimatedGeoModel<VelocipreyEntity> {

    @Override
    public ResourceLocation getModelResource(VelocipreyEntity object) {
        return new ResourceLocation(MHEF.MOD_ID, "geo/velociprey.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(VelocipreyEntity object) {
        return new ResourceLocation(MHEF.MOD_ID, "textures/entity/velociprey/velociprey.png");
    }

    @Override
    public ResourceLocation getAnimationResource(VelocipreyEntity animatable) {
        return new ResourceLocation(MHEF.MOD_ID, "animations/velociprey.animation.json");
    }
}
