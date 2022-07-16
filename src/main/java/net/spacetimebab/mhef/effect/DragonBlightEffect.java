package net.spacetimebab.mhef.effect;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.spacetimebab.mhef.elements.DragonBlightDamageSource;
import net.spacetimebab.mhef.init.EffectInit;

public class DragonBlightEffect extends MobEffect {
    public DragonBlightEffect(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.level.isClientSide()) {
            pLivingEntity.hurt(DragonBlightDamageSource.DragonBlight(), 2.5F);
        }

    }

    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        if (this == MobEffects.WITHER) {
            int i = 40 >> pAmplifier;
            if (i > 0) {
                return pDuration % i == 0;
            }
        }
        return true;
    }
}
