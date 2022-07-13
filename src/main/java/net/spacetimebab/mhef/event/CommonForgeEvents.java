package net.spacetimebab.mhef.event;

import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.spacetimebab.mhef.MHEF;
import net.spacetimebab.mhef.quest.QuestReloadListener;

@Mod.EventBusSubscriber(modid = MHEF.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonForgeEvents {
    @SubscribeEvent
    public static void onRegisterReloadListeners(AddReloadListenerEvent event) {
        event.addListener(new QuestReloadListener());
    }
}
