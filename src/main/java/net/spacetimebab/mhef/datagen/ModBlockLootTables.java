package net.spacetimebab.mhef.datagen;

import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraftforge.registries.RegistryObject;
import net.spacetimebab.mhef.init.BlockInit;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ModBlockLootTables extends BlockLoot {

    private static List<Block> EXCLUSION = Arrays.asList(

    );

    @Override
    protected void addTables() {
        BlockInit.BLOCKS.getEntries().stream()
                .map(RegistryObject::get)
                .filter(block -> block.asItem() != Items.AIR && !(block instanceof DropExperienceBlock) && !EXCLUSION.contains(block))
                .forEach(this::dropSelf);
//        commonRareDrops(BlockInit.AMBER_ORE_STONE.get(), ItemInit.AMBER.get(),ItemInit.AMBER_MOSQUITO.get());
//        commonRareDrops(BlockInit.AMBER_ORE_DEEPSLATE.get(), ItemInit.AMBER.get(),ItemInit.AMBER_MOSQUITO.get());
//        add(BlockInit.FOSSIL_ORE_DEEPSLATE.get(),createOreDrop(BlockInit.FOSSIL_ORE_DEEPSLATE.get(), ItemInit.FOSSIL.get()));
//        add(BlockInit.FOSSIL_ORE_STONE.get(),createOreDrop(BlockInit.FOSSIL_ORE_STONE.get(), ItemInit.FOSSIL.get()));
    }
    public void commonRareDrops(Block block, Item common, Item rare){
        add(block,createSilkTouchDispatchTable(block,
                applyExplosionCondition(block,
                        LootItem.lootTableItem(rare).
                                when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.1F, 0.14285715F, 0.25F, 1.0F))
                                .otherwise(LootItem.lootTableItem(common)))));
    }
    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).filter(block -> block.asItem() != Items.AIR && !(block instanceof DropExperienceBlock) /*&& !EXCLUSION.contains(block)*/).collect(Collectors.toList());
    }

}
