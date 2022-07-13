package net.spacetimebab.mhef.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.spacetimebab.mhef.MHEF;
import net.spacetimebab.mhef.init.EntityInit;
import net.spacetimebab.mhef.entity.custom.*;

@Mod.EventBusSubscriber(modid = MHEF.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(EntityInit.VELOCIPREY.get(), VelocipreyEntity.attributes().build());
        event.put(EntityInit.VELOCIDROME.get(), VelocidromeEntity.attributes().build());
        event.put(EntityInit.NARGACUGA.get(),NargacugaEntity.attributes().build());
        event.put(EntityInit.APTONOTH.get(), AptonothEntity.attributes().build());
        event.put(EntityInit.GASTODON.get(), GastodonEntity.attributes().build());
        event.put(EntityInit.POPO.get(),PopoEntity.attributes().build());

    }
}
