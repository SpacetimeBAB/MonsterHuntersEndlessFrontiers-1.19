package net.spacetimebab.mhef.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.spacetimebab.mhef.MHEF;
import net.spacetimebab.mhef.entity.custom.VelocidromeEntity;
import net.spacetimebab.mhef.entity.custom.VelocipreyEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class VelocidromeModel extends AnimatedGeoModel<VelocidromeEntity> {

    @Override
    public ResourceLocation getModelResource(VelocidromeEntity object) {
        return new ResourceLocation(MHEF.MOD_ID, "geo/velocidromenew.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(VelocidromeEntity object) {
        return new ResourceLocation(MHEF.MOD_ID, "textures/entity/velocidrome/velocidromenew123456.png");
    }

    @Override
    public ResourceLocation getAnimationResource(VelocidromeEntity animatable) {
        return new ResourceLocation(MHEF.MOD_ID, "animations/velocidromenew.animation.json");
    }
}
