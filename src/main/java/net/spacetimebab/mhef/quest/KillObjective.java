package net.spacetimebab.mhef.quest;

import com.mojang.serialization.Codec;

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
