package net.spacetimebab.mhef.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.spacetimebab.mhef.MHEF;
import net.spacetimebab.mhef.entity.custom.AptonothEntity;
import net.spacetimebab.mhef.entity.custom.NargacugaEntity;
import net.spacetimebab.mhef.entity.custom.PopoEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PopoModel extends AnimatedGeoModel<PopoEntity> {

    @Override
    public ResourceLocation getModelResource(PopoEntity object) {
        return new ResourceLocation(MHEF.MOD_ID, "geo/popo.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PopoEntity object) {
        return new ResourceLocation(MHEF.MOD_ID, "textures/entity/popo/popo.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PopoEntity animatable) {
        return new ResourceLocation(MHEF.MOD_ID, "animations/popo.animation.json");
    }
}
