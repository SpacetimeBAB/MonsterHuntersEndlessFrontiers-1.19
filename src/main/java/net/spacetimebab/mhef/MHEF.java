package net.spacetimebab.mhef;

import com.mojang.logging.LogUtils;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.spacetimebab.mhef.datagen.*;
import net.spacetimebab.mhef.elements.ElementAttributes;
import net.spacetimebab.mhef.init.*;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MHEF.MOD_ID)
@Mod.EventBusSubscriber(modid = MHEF.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
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
        BlockInit.BLOCKS.register(modEventBus);


        // Register ourselves for server and other game events we are interested in

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeServer(), new ModRecipeProvider(generator));
        generator.addProvider(event.includeServer(), new ModLootTableProvider(generator));
        generator.addProvider(event.includeServer(), new ModSoundProvider(generator, MOD_ID, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(generator, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(generator, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModLangProvider(generator, MOD_ID, "en_us"));
    }
}
