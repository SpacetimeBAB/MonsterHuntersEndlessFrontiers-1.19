package net.spacetimebab.mhef;

import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.spacetimebab.mhef.elements.ElementAttributes;
import net.spacetimebab.mhef.init.EnchantmentsInit;
import net.spacetimebab.mhef.init.EntityInit;
import net.spacetimebab.mhef.init.ItemInit;
import net.spacetimebab.mhef.init.QuestInit;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MHEF.MOD_ID)
public class MHEF
{
    public static final String MOD_ID = "mhef";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    public MHEF()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        EntityInit.register(modEventBus);

        GeckoLib.initialize();

        ElementAttributes.register(modEventBus);
        QuestInit.QUESTS.register(modEventBus);
        QuestInit.REWARDS.register(modEventBus);
        QuestInit.OBJECTIVES.register(modEventBus);
        EnchantmentsInit.register(modEventBus);



        // Register ourselves for server and other game events we are interested in

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
