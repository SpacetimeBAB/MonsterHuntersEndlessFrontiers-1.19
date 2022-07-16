package net.spacetimebab.mhef.init;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.spacetimebab.mhef.MHEF;
import net.spacetimebab.mhef.block.entity.QuestBoardMenu;

public class ContainerInit {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, MHEF.MOD_ID);

    public static RegistryObject<MenuType<QuestBoardMenu>> QUEST_BOARD_MENU = MENU_TYPES.register("quest_board_menu", ()-> IForgeMenuType.create(QuestBoardMenu::new));
}
