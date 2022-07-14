package net.spacetimebab.mhef.quest.api;

public enum QuestRarity {
    COMMON("common"),
    HIGH("high"),
    MASTER("master"),
    TEMPERED("tempered");

    private final String desc;

    QuestRarity(String desc) {
        this.desc = desc;
    }
    public static QuestRarity getByDescription(String desc) {
        for (QuestRarity rarity : QuestRarity.values()) {
            if (rarity.desc.equals(desc)) {
                return rarity;
            }
        }
        return null;
    }
}
