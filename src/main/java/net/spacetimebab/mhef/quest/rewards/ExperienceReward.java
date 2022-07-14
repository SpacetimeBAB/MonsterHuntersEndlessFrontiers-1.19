package net.spacetimebab.mhef.quest.rewards;

import com.mojang.serialization.Codec;
import net.spacetimebab.mhef.init.QuestInit;
import net.spacetimebab.mhef.quest.api.Reward;

public class ExperienceReward implements Reward {
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
