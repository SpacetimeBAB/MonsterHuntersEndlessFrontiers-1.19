package net.spacetimebab.mhef.event;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.spacetimebab.mhef.MHEF;
import net.spacetimebab.mhef.entity.ModEntityTypes;
import net.spacetimebab.mhef.entity.client.*;

@Mod.EventBusSubscriber(modid = MHEF.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {
    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntityTypes.VELOCIPREY.get(), VelocipreyRenderer::new);
        EntityRenderers.register(ModEntityTypes.VELOCIDROME.get(), VelocidromeRenderer::new);
        EntityRenderers.register(ModEntityTypes.NARGACUGA.get(), NargacugaRenderer::new);
        EntityRenderers.register(ModEntityTypes.APTONOTH.get(), AptonothRenderer::new);
        EntityRenderers.register(ModEntityTypes.GASTODON.get(), GastodonRenderer::new);
        EntityRenderers.register(ModEntityTypes.POPO.get(),PopoRenderer::new);
    }
}
