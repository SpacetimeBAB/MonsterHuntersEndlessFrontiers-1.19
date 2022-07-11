package net.spacetimebab.mhef.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.spacetimebab.mhef.MHEF;
import net.spacetimebab.mhef.entity.ModEntityTypes;
import net.spacetimebab.mhef.entity.custom.*;

@Mod.EventBusSubscriber(modid = MHEF.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.VELOCIPREY.get(), VelocipreyEntity.attributes().build());
        event.put(ModEntityTypes.VELOCIDROME.get(), VelocidromeEntity.attributes().build());
        event.put(ModEntityTypes.NARGACUGA.get(),NargacugaEntity.attributes().build());
        event.put(ModEntityTypes.APTONOTH.get(), AptonothEntity.attributes().build());
        event.put(ModEntityTypes.GASTODON.get(), GastodonEntity.attributes().build());
        event.put(ModEntityTypes.POPO.get(),PopoEntity.attributes().build());

    }
}
