package net.spacetimebab.mhef.quest;

import com.mojang.serialization.Codec;

import java.util.List;

public class HuntQuest implements Quest {
    private final String name;
    private final String description;
    private final String rarity;
    private final List<Reward> rewards;
    private final List<KillObjective> objectives;

    public HuntQuest(String name, String description, String rarity, List<Reward> rewards, List<KillObjective> objectives) {
        this.name = name;
        this.description = description;
        this.rarity = rarity;
        this.rewards = rewards;
        this.objectives = objectives;
    }

    public static String name(HuntQuest o) {
        return o.name;
    }

    public static String description(HuntQuest o) {
        return o.description;
    }

    public static String rarity(HuntQuest o) {
        return o.rarity;
    }

    @Override
    public Codec<? extends Quest> codec() {
        return QuestInit.HUNT_QUESTS.get();
    }

    public static List<Reward> rewards(HuntQuest o) {
        return o.rewards;
    }
    public static List<KillObjective> objectives(HuntQuest o) {
        return o.objectives;
    }

}
