package net.spacetimebab.mhef.enchantment;

import net.minecraft.world.item.enchantment.ProtectionEnchantment;

public enum ModType  {
    ELEMENTAL_FIRE(10, 8);


    private final int minCost;
    private final int levelCost;

    ModType(int pMinCost, int pLevelCost) {
        this.minCost = pMinCost;
        this.levelCost = pLevelCost;
    }

    public int getMinCost() {
        return this.minCost;
    }

    public int getLevelCost() {
        return this.levelCost;
    }
}
