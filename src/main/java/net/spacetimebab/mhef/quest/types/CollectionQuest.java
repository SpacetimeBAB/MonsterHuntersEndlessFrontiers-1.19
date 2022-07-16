package net.spacetimebab.mhef.quest.types;

import com.mojang.serialization.Codec;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.spacetimebab.mhef.quest.api.QuestObjective;
import net.spacetimebab.mhef.quest.api.QuestRarity;
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

    public QuestRarity getRarity() {
        return QuestRarity.getByDescription(rarity);
    }
    public static String rarity(CollectionQuest o) {
        return o.rarity;
    }

    @Override
    public Codec<? extends Quest> codec() {
        return QuestInit.COLLECTION_QUESTS.get();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public List<CollectionObjective> getObjectives() {
        return objectives;
    }

    @Override
    public List<? extends Reward> getRewards() {
        return rewards;
    }

    @Override
    public void complete(Player player) {
        objectives.forEach(objective ->{
            int count = objective.getAmount();
            for(ItemStack itemStack : player.getInventory().items){
                if(itemStack.is(objective.getItem().getItem())){
                    if(itemStack.getCount() < count){
                        count -= itemStack.getCount();
                        itemStack.setCount(0);
                    } else {
                        itemStack.shrink(count);
                    }
                }
            }
        });
    }

    public static List<Reward> rewards(CollectionQuest o) {
        return o.rewards;
    }

    public static List<CollectionObjective> objectives(CollectionQuest o) {
        return o.objectives;
    }
}
