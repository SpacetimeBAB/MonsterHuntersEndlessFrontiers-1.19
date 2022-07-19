package net.spacetimebab.mhef.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.spacetimebab.mhef.MHEF;
import net.spacetimebab.mhef.effect.DragonBlightEffect;
import net.spacetimebab.mhef.effect.NoxiousPoisonEffect;
import net.spacetimebab.mhef.effect.ParalyzedEffect;

public class EffectInit{
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create( ForgeRegistries.MOB_EFFECTS, MHEF.MOD_ID);

    public static final RegistryObject<MobEffect> PARALYZED_EFFECT = MOB_EFFECTS.register("paralyzed",
            () -> new ParalyzedEffect(MobEffectCategory.HARMFUL, 3124687));
    public static final RegistryObject<MobEffect> DRAGON_BLIGHT_EFFECT = MOB_EFFECTS.register("dragon_blight",
            () -> new DragonBlightEffect(MobEffectCategory.HARMFUL, 3124687));
    public static final RegistryObject<MobEffect> NOXIOUS_POISON = MOB_EFFECTS.register("noxious_poison",
            () -> new NoxiousPoisonEffect(MobEffectCategory.HARMFUL,5149489));



    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }
}
