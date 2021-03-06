package net.spacetimebab.mhef.elements;

import net.minecraft.core.Registry;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.spacetimebab.mhef.MHEF;

public class ElementAttributes {
    public static final Attribute ICE_RESISTANCE = register("generic.ice_resistance", (new RangedAttribute("attribute.name.generic.ice_resistance", 0.0D, 0.0D, 20.0D)).setSyncable(true));
    public static final Attribute LIGHTNING_RESISTANCE = register("generic.lightning_resistance", (new RangedAttribute("attribute.name.generic.lightning_resistance", 0.0D, 0.0D, 20.0D)).setSyncable(true));
    public static final Attribute WATER_RESISTANCE = register("generic.water_resistance", (new RangedAttribute("attribute.name.generic.water_resistance", 0.0D, 0.0D, 20.0D)).setSyncable(true));
    public static final Attribute DRAGON_RESISTANCE = register("generic.dragon_resistance", (new RangedAttribute("attribute.name.generic.dragon_resistance", 0.0D, 0.0D, 20.0D)).setSyncable(true));
    public static final Attribute ELEMENTAL_FIRE_RESISTANCE = register("generic.elemental_fire_resistance", (new RangedAttribute("attribute.name.generic.elemental_fire_resistance", 0.0D, 0.0D, 20.0D)).setSyncable(true));
    public static final Attribute ICE_WEAKNESS = register("generic.ice_weakness", (new RangedAttribute("attribute.name.generic.ice_weakness", 0.0D, 0.0D, 20.0D)).setSyncable(true));
    public static final Attribute LIGHTNING_WEAKNESS = register("generic.lightning_weakness", (new RangedAttribute("attribute.name.generic.lightning_weakness", 0.0D, 0.0D, 20.0D)).setSyncable(true));
    public static final Attribute WATER_WEAKNESS = register("generic.water_weakness", (new RangedAttribute("attribute.name.generic.water_weakness", 0.0D, 0.0D, 20.0D)).setSyncable(true));
    public static final Attribute DRAGON_WEAKNESS = register("generic.dragon_weakness", (new RangedAttribute("attribute.name.generic.dragon_weakness", 0.0D, 0.0D, 20.0D)).setSyncable(true));
    public static final Attribute ELEMENTAL_FIRE_WEAKNESS = register("generic.elemental_fire_weakness", (new RangedAttribute("attribute.name.generic.elemental_fire_weakness", 0.0D, 0.0D, 20.0D)).setSyncable(true));

    private static Attribute register(String s, Attribute setSyncable) {
        return setSyncable;
    }


    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, MHEF.MOD_ID);

    public static void register(IEventBus modEventBus) {
    }
}
