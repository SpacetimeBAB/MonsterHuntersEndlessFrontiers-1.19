package net.spacetimebab.mhef.enchantment;

import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.ProtectionEnchantment;
import net.spacetimebab.mhef.init.EnchantmentsInit;

public class ElementalResistanceEnchantments extends ProtectionEnchantment {
    public final ElementalResistanceEnchantments.Type type;




    public ElementalResistanceEnchantments(Rarity pRarity, Type type, Type pType, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pType, pApplicableSlots);
        this.type = type;
    }


    public int getMinCost(int pEnchantmentLevel) {
        return this.type.getMinCost() + (pEnchantmentLevel - 1) * this.type.getLevelCost();
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return this.getMinCost(pEnchantmentLevel) + this.type.getLevelCost();
    }

    public int getMaxLevel() {
        return 8;
    }

    public int getModDamageProtection(int pLevel, DamageSource pSource) {


        boolean equals = equals(ModType.ELEMENTAL_FIRE);

        if (pSource.isBypassInvul()) {
            return 0;
        } else if (this.type equals( ModType.ELEMENTAL_FIRE); {
            return pLevel;
        }
        return pLevel;
    }



    public boolean checkCompatibility(Enchantment pEnch) {
        if (pEnch instanceof ElementalResistanceEnchantments elementalResistanceEnchantments) {
            if (this.type == elementalResistanceEnchantments.type) {
                return false;
            }
        }
            return super.checkCompatibility(pEnch);
        }

    public static int getElementalFireAfterDampener(LivingEntity pLivingEntity, int pLevel) {
        int i = EnchantmentHelper.getEnchantmentLevel(EnchantmentsInit.ELEMENTAL_FIRE_PROTECTION, pLivingEntity);
        if (i > 0) {
            pLevel -= Mth.floor((float)pLevel * (float)i * 0.15F);
        }

        return pLevel;
    }
}




