package net.spacetimebab.mhef.init;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ProtectionEnchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.spacetimebab.mhef.MHEF;
import net.spacetimebab.mhef.enchantment.ElementalResistanceEnchantments;
import net.spacetimebab.mhef.enchantment.ModType;


public class EnchantmentsInit {
    private static final EquipmentSlot[] ARMOR_SLOTS = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};

    public static final DeferredRegister<Enchantment> ENCHANTMENTS
                = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MHEF.MOD_ID);
    public static final RegistryObject<Enchantment> ELEMENTAL_FIRE_PROTECTION =
            ENCHANTMENTS.register("elemental_fire_protection", ()->new ElementalResistanceEnchantments(Enchantment.Rarity.UNCOMMON,
                    ProtectionEnchantment.Type.FIRE, ARMOR_SLOTS));

    private static Enchantment register(String elemental_fire_protection, ElementalResistanceEnchantments elementalResistanceEnchantments) {
        return null;
    }


    public static void register(IEventBus eventBus) {
            ENCHANTMENTS.register(eventBus);
        }
}
