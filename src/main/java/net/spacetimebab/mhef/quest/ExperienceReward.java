package net.spacetimebab.mhef.quest;

import com.mojang.serialization.Codec;

public class ExperienceReward implements Reward{
    private int quantity;
    public ExperienceReward(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public Codec<? extends Reward> codec() {
        return QuestInit.EXPERIENCE_REWARD.get();
    }

    public static  Integer quantity(ExperienceReward o) {
        return o.quantity;
    }
}
