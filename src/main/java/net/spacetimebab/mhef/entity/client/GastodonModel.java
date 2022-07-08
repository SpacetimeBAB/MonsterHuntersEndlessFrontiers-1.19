package net.spacetimebab.mhef.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.spacetimebab.mhef.MHEF;
import net.spacetimebab.mhef.entity.custom.GastodonEntity;
import net.spacetimebab.mhef.entity.custom.VelocipreyEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GastodonModel extends AnimatedGeoModel<GastodonEntity> {

    @Override
    public ResourceLocation getModelResource(GastodonEntity object) {
        return new ResourceLocation(MHEF.MOD_ID, "geo/gastodon.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GastodonEntity object) {
        return new ResourceLocation(MHEF.MOD_ID, "textures/entity/gastodon/gastodonnew.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GastodonEntity animatable) {
        return new ResourceLocation(MHEF.MOD_ID, "animations/gastodon.animation.json");
    }
}
