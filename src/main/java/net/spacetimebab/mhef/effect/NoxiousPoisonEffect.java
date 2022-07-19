package net.spacetimebab.mhef.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.spacetimebab.mhef.elements.NoxiousPoisonDamageSource;

public class NoxiousPoisonEffect extends MobEffect {
    public NoxiousPoisonEffect(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
    }
    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.level.isClientSide()) {
            pLivingEntity.hurt(NoxiousPoisonDamageSource.NoxiousPoison(), 3.5F);
        }

    }

    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        if (this == MobEffects.POISON) {
            int i = 40 >> pAmplifier;
            if (i > 0) {
                return pDuration % i == 0;
            }
        }
        return true;
    }

}
