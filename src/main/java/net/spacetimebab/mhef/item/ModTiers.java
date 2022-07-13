package net.spacetimebab.mhef.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.spacetimebab.mhef.init.ItemInit;

public class ModTiers {
    public static final ForgeTier DROME_RUSH = new ForgeTier(0,2850,0f,
            4.5f,22, BlockTags.IRON_ORES,
            () -> Ingredient.of(ItemInit.VELOCIDROME_TALONS.get()));
}
