package net.spacetimebab.mhef.effect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class BaseEffect extends MobEffect {
    public BaseEffect(MobEffectCategory category) {
        super(category, 0xffffff);
    }
}
