package net.spacetimebab.mhef.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.spacetimebab.mhef.MHEF;
import net.spacetimebab.mhef.block.QuestBoardBlock;
import net.spacetimebab.mhef.block.entity.QuestBoardBlockEntity;

import java.util.function.Function;
import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MHEF.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MHEF.MOD_ID);

    public static final RegistryObject<Block> QUEST_BOARD = registerBlock("quest_board", ()-> new QuestBoardBlock(BlockBehaviour.Properties.of(Material.WOOD)));

    public static final RegistryObject<BlockEntityType<QuestBoardBlockEntity>> QUEST_BOARD_BLOCK_ENTITY = BLOCK_ENTITIES.register("quest_board_block_entity", () -> BlockEntityType.Builder.of(QuestBoardBlockEntity::new, QUEST_BOARD.get()).build(null));
    protected static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        return registerBlock(name, block, b -> () -> new BlockItem(b.get(), ItemInit.getItemProperties()));
    }
//    protected static <T extends Block> RegistryObject<T> registerBottomTopBlock(String name, Supplier<T> block) {
//        return registerBlock(name, block, b -> () -> new BottomTopBlockItem(b.get(), ItemInit.getItemProperties()));
//    }

    protected static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, Function<RegistryObject<T>, Supplier<? extends BlockItem>> item) {
        var reg = BLOCKS.register(name, block);
        ItemInit.ITEMS.register(name, () -> item.apply(reg).get());
        return reg;
    }
}
