package net.spacetimebab.mhef.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.spacetimebab.mhef.MHEF;
import net.spacetimebab.mhef.entity.ModEntityTypes;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MHEF.MOD_ID);

    public static final RegistryObject<Item> VELOCIPREY_SCALE = ITEMS.register("velociprey_scale",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> VELOCIPREY_CLAW = ITEMS.register("velociprey_claw",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> VELOCIPREY_TALONS = ITEMS.register("velociprey_talons",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> VELOCIPREY_HIDE = ITEMS.register("velociprey_hide",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> VELOCIDROME_SCALE = ITEMS.register("velocidrome_scale",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> VELOCIDROME_CLAW = ITEMS.register("velocidrome_claw",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> VELOCIDROME_TALONS = ITEMS.register("velocidrome_talons",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> VELOCIDROME_HIDE = ITEMS.register("velocidrome_hide",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> SHRIEKING_SAC = ITEMS.register("shrieking_sac",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> VELOCIPREY_SPAWN_EGG = ITEMS.register("velociprey_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.VELOCIPREY, 0x614141, 0xDC0000,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> VELOCIDROME_SPAWN_EGG = ITEMS.register("velocidrome_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.VELOCIDROME, 0xDFCC8F, 0x2D2611,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> DROME_RUSH_DAGGER = ITEMS.register("drome_rush_dagger",
            () -> new SwordItem(ModTiers.DROME_RUSH, 0,0.0f,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> NARGACUGA_SPAWN_EGG = ITEMS.register("nargacuga_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.NARGACUGA, 0x535353, 0xB8A840,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> APTONOTH_SPAWN_EGG = ITEMS.register("aptonoth_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.APTONOTH, 0xB26D10, 0xB8C20F,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> GASTODON_SPAWN_EGG = ITEMS.register("gastodon_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GASTODON, 0x5998C6, 0x19424A,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }




}
