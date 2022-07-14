package net.spacetimebab.mhef.quest.objectives;

import com.mojang.serialization.Codec;
import net.spacetimebab.mhef.init.QuestInit;
import net.spacetimebab.mhef.quest.api.QuestObjective;

public class KillObjective implements QuestObjective {


    private final String entity;
    private Integer amount;

    public KillObjective(String entity, int amount) {
        this.entity = entity;
        this.amount = amount;
    }

    @Override
    public Codec<? extends QuestObjective> codec() {
        return QuestInit.KILL_OBJECTIVE.get();
    }

    public static Integer amount(KillObjective o) {
        return o.amount;
    }

    public static String entity(KillObjective o) {
        return o.entity;
    }

    public static String getName(KillObjective o) {
        return o.entity;
    }
}
