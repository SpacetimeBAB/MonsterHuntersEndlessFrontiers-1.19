package net.spacetimebab.mhef.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.spacetimebab.mhef.MHEF;
import net.spacetimebab.mhef.entity.custom.AnjanathEntity;
import net.spacetimebab.mhef.entity.custom.VelocidromeEntity;
import net.spacetimebab.mhef.entity.custom.VelocipreyEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AnjanathModel extends AnimatedGeoModel<AnjanathEntity> {

    @Override
    public ResourceLocation getModelResource(AnjanathEntity object) {
        return new ResourceLocation(MHEF.MOD_ID, "geo/anjanath.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AnjanathEntity object) {
        return new ResourceLocation(MHEF.MOD_ID, "textures/entity/anjanath/anjanath.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AnjanathEntity animatable) {
        return new ResourceLocation(MHEF.MOD_ID, "animations/anjanath.animation.json");
    }
}
