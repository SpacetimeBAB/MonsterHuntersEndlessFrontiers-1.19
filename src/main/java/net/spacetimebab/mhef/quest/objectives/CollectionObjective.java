package net.spacetimebab.mhef.quest.objectives;

import com.mojang.serialization.Codec;
import net.spacetimebab.mhef.init.QuestInit;
import net.spacetimebab.mhef.quest.api.QuestObjective;

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

    public static Integer quantity(CollectionObjective o) {
        return o.amount;
    }

    public static String item(CollectionObjective o) {
        return o.item;
    }

    public static String getName(CollectionObjective o) {
        return o.item;
    }
}
