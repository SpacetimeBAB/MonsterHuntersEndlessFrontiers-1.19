package net.spacetimebab.mhef.quest.rewards;

import com.mojang.serialization.Codec;
import net.spacetimebab.mhef.init.QuestInit;
import net.spacetimebab.mhef.quest.api.Reward;

public class ItemReward implements Reward {


    private final String item;
    private final int quantity;

    public ItemReward(String item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    @Override
    public Codec<? extends Reward> codec() {
        return QuestInit.ITEM_REWARD.get();
    }

    public static Integer quantity(ItemReward o) {
        return o.quantity;
    }

    public static String item(ItemReward o) {
        return o.item;
    }
}
