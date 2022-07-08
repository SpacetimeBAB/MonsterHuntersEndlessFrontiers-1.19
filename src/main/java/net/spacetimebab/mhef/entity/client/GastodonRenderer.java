package net.spacetimebab.mhef.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.spacetimebab.mhef.MHEF;
import net.spacetimebab.mhef.entity.custom.GastodonEntity;
import net.spacetimebab.mhef.entity.custom.VelocipreyEntity;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GastodonRenderer extends GeoEntityRenderer<GastodonEntity> {

    public GastodonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GastodonModel() );
        this.shadowRadius = 2f;
    }
    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull GastodonEntity instance) {
        return new ResourceLocation(MHEF.MOD_ID, "textures/entity/gastodon/gastodonnew.png");
    }

    @Override
    public RenderType getRenderType(GastodonEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1F, 1F, 1F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
