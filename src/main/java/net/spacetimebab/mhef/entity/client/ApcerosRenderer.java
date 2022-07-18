package net.spacetimebab.mhef.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.spacetimebab.mhef.MHEF;
import net.spacetimebab.mhef.entity.custom.*;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ApcerosRenderer extends GeoEntityRenderer<ApcerosEntity> {

    public ApcerosRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ApcerosModel() );
        this.shadowRadius = 3f;
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull ApcerosEntity instance) {
        return new ResourceLocation(MHEF.MOD_ID, "textures/entity/apceros/apceros.png");
    }

    @Override
    public RenderType getRenderType(ApcerosEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1F, 1F, 1F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }

}
