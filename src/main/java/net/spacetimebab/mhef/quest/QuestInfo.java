package net.spacetimebab.mhef.quest;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.spacetimebab.mhef.quest.api.Quest;
import net.spacetimebab.mhef.quest.api.QuestObjective;
import net.spacetimebab.mhef.quest.objectives.CollectionObjective;
import net.spacetimebab.mhef.quest.objectives.KillObjective;

import java.util.Objects;

public class QuestInfo {
    private ResourceLocation questId;
    private Object2IntMap<String> objectives;

    public QuestInfo(ResourceLocation questId, Object2IntMap<String> objectives) {
        this.objectives = objectives;
        this.questId = questId;
    }


    public void updateObjective(String name, int amount) {
        if(objectives.containsKey(name)) {
            objectives.put(name, objectives.get(name) + amount);
        }
    }
    public int checkObjective(Item name) {
        String key = ForgeRegistries.ITEMS.getKey(name).toString();
        if(objectives.containsKey(key)) {
            return objectives.getInt(key);
        }
        return 0;
    }
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putString("questId", questId.toString());
        objectives.forEach(
                tag::putInt
        );
        return tag;
    }
    public static QuestInfo deserializeNBT(CompoundTag nbt) {
        Object2IntMap<String> objectives = new Object2IntOpenHashMap<>();
        nbt.getAllKeys().forEach(key -> {
            if(!Objects.equals(key, "questId")) {
                objectives.put(key, nbt.getInt(key));
            }
        });
        return new QuestInfo(new ResourceLocation(nbt.getString("questId")), objectives);
    }

    public boolean isForQuest(Quest quest) {
        return Quests.QUESTS.get(this.questId) != null && Quests.QUESTS.get(this.questId).equals(quest);
    }
    public boolean isCompleted(Quest quest) {
        for(QuestObjective obj : quest.getObjectives()){
            if(obj instanceof CollectionObjective collectionObjective){
                if(objectives.get(collectionObjective.getItemName()) < collectionObjective.getAmount()){
                    return false;
                }
            }
            if(obj instanceof KillObjective killObjective){
                if(objectives.get(killObjective.getEntity()) < killObjective.getAmount()){
                    return false;
                }
            }
        }
        return true;
    }
}
