package net.spacetimebab.mhef.event;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.spacetimebab.mhef.MHEF;
import net.spacetimebab.mhef.init.EntityInit;
import net.spacetimebab.mhef.entity.client.*;

@Mod.EventBusSubscriber(modid = MHEF.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {
    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        EntityRenderers.register(EntityInit.VELOCIPREY.get(), VelocipreyRenderer::new);
        EntityRenderers.register(EntityInit.VELOCIDROME.get(), VelocidromeRenderer::new);
        EntityRenderers.register(EntityInit.NARGACUGA.get(), NargacugaRenderer::new);
        EntityRenderers.register(EntityInit.APTONOTH.get(), AptonothRenderer::new);
        EntityRenderers.register(EntityInit.GASTODON.get(), GastodonRenderer::new);
        EntityRenderers.register(EntityInit.POPO.get(),PopoRenderer::new);
    }
}
