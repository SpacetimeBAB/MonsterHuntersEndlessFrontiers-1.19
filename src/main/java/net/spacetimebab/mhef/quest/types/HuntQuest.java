package net.spacetimebab.mhef.quest.types;

import com.mojang.serialization.Codec;
import net.spacetimebab.mhef.quest.api.QuestRarity;
import net.spacetimebab.mhef.quest.objectives.KillObjective;
import net.spacetimebab.mhef.quest.api.Quest;
import net.spacetimebab.mhef.init.QuestInit;
import net.spacetimebab.mhef.quest.api.Reward;

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

    public QuestRarity getRarity() {
        return QuestRarity.getByDescription(rarity);
    }
    public static String rarity(HuntQuest o) {
        return o.rarity;
    }

    @Override
    public Codec<? extends Quest> codec() {
        return QuestInit.HUNT_QUESTS.get();
    }

    @Override
    public String getName() {
        return name;
    }

    public static List<Reward> rewards(HuntQuest o) {
        return o.rewards;
    }
    public static List<KillObjective> objectives(HuntQuest o) {
        return o.objectives;
    }

}
