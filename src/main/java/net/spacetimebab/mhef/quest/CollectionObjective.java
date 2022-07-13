package net.spacetimebab.mhef.quest;

import com.mojang.serialization.Codec;

public class CollectionObjective implements QuestObjective {


    private final String item;
    private Integer amount;

    public CollectionObjective(String item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    @Override
    public Codec<? extends QuestObjective> codec() {
        return QuestInit.COLLECT_OBJECTIVE.get();
    }

    public static Integer getAmount(CollectionObjective o) {
        return o.amount;
    }

    public static String getItem(CollectionObjective o) {
        return o.item;
    }

    public static String getName(CollectionObjective o) {
        return o.item;
    }
}
