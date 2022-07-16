package net.spacetimebab.mhef.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.spacetimebab.mhef.MHEF;
import net.spacetimebab.mhef.item.ModTiers;
import net.spacetimebab.mhef.item.QuestItem;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MHEF.MOD_ID);


    public static final RegistryObject<Item> COMMON_QUEST = ITEMS.register("common_quest", () -> new QuestItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> HIGH_QUEST = ITEMS.register("high_quest", () -> new QuestItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> MASTER_QUEST = ITEMS.register("master_quest", () -> new QuestItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> TEMPERED_QUEST = ITEMS.register("tempered_quest", () -> new QuestItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));



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
            () -> new ForgeSpawnEggItem(EntityInit.VELOCIPREY, 0x614141, 0xDC0000,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> VELOCIDROME_SPAWN_EGG = ITEMS.register("velocidrome_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.VELOCIDROME, 0xDFCC8F, 0x2D2611,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> DROME_RUSH_DAGGER = ITEMS.register("drome_rush_dagger",
            () -> new SwordItem(ModTiers.DROME_RUSH, 0,0.0f,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> NARGACUGA_SPAWN_EGG = ITEMS.register("nargacuga_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.NARGACUGA, 0x535353, 0xB8A840,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> APTONOTH_SPAWN_EGG = ITEMS.register("aptonoth_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.APTONOTH, 0xB26D10, 0xB8C20F,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> GASTODON_SPAWN_EGG = ITEMS.register("gastodon_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.GASTODON, 0x5998C6, 0x19424A,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> ANCIENT_BONE = ITEMS.register("ancient_bone",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> POPO_SPAWN_EGG = ITEMS.register("popo_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.POPO, 0x4D3D2D, 0xC27007,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


    public static Item.Properties getItemProperties() {
        return new Item.Properties().tab(CreativeModeTab.TAB_MISC);
    }
}
