package net.spacetimebab.mhef.event;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.spacetimebab.mhef.MHEF;
import net.spacetimebab.mhef.block.entity.QuestBoardScreen;
import net.spacetimebab.mhef.init.ContainerInit;
import net.spacetimebab.mhef.init.EntityInit;
import net.spacetimebab.mhef.entity.client.*;

@Mod.EventBusSubscriber(modid = MHEF.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    @SubscribeEvent
    public static void clientSetup(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.VELOCIPREY.get(), VelocipreyRenderer::new);
        event.registerEntityRenderer(EntityInit.VELOCIDROME.get(), VelocidromeRenderer::new);
        event.registerEntityRenderer(EntityInit.NARGACUGA.get(), NargacugaRenderer::new);
        event.registerEntityRenderer(EntityInit.APTONOTH.get(), AptonothRenderer::new);
        event.registerEntityRenderer(EntityInit.GASTODON.get(), GastodonRenderer::new);
        event.registerEntityRenderer(EntityInit.POPO.get(),PopoRenderer::new);
        event.registerEntityRenderer(EntityInit.ANJANATH.get(),AnjanathRenderer::new);
    }
    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        MenuScreens.register(ContainerInit.QUEST_BOARD_MENU.get(), QuestBoardScreen::new);
    }
}
