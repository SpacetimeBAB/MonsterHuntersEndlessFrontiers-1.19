package net.spacetimebab.mhef.quest.types;

import com.mojang.serialization.Codec;
import net.spacetimebab.mhef.quest.objectives.CollectionObjective;
import net.spacetimebab.mhef.init.QuestInit;
import net.spacetimebab.mhef.quest.api.Quest;
import net.spacetimebab.mhef.quest.api.Reward;

import java.util.List;

public class CollectionQuest implements Quest {
    private final String name;
    private final String description;
    private final String rarity;
    private final List<Reward> rewards;
    private final List<CollectionObjective> objectives;

    public CollectionQuest(String name, String description, String rarity, List<Reward> rewards, List<CollectionObjective> objectives) {
        this.name = name;
        this.description = description;
        this.rarity = rarity;
        this.rewards = rewards;
        this.objectives = objectives;
    }

    public static String name(CollectionQuest o) {
        return o.name;
    }

    public static String description(CollectionQuest o) {
        return o.description;
    }

    public static String rarity(CollectionQuest o) {
        return o.rarity;
    }

    @Override
    public Codec<? extends Quest> codec() {
        return QuestInit.COLLECTION_QUESTS.get();
    }

    public static List<Reward> rewards(CollectionQuest o) {
        return o.rewards;
    }

    public static List<CollectionObjective> objectives(CollectionQuest o) {
        return o.objectives;
    }
}
