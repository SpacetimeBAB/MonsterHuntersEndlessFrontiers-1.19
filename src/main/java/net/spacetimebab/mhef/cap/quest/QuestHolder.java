package net.spacetimebab.mhef.cap.quest;

import dev._100media.capabilitysyncer.core.LevelCapability;
import dev._100media.capabilitysyncer.core.PlayerCapability;
import dev._100media.capabilitysyncer.network.EntityCapabilityStatusPacket;
import dev._100media.capabilitysyncer.network.LevelCapabilityStatusPacket;
import dev._100media.capabilitysyncer.network.SimpleEntityCapabilityStatusPacket;
import dev._100media.capabilitysyncer.network.SimpleLevelCapabilityStatusPacket;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.util.datafix.fixes.ItemStackTagFix;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.registries.ForgeRegistries;
import net.spacetimebab.mhef.network.NetworkHandler;
import net.spacetimebab.mhef.quest.QuestInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestHolder extends PlayerCapability {

    private int questsCompleted = 0;
    private QuestInfo questBoardQuest = null;
    private List<QuestInfo> quests = new ArrayList<>();

    protected QuestHolder(Player level) {
        super(level);
    }


    @Override
    public CompoundTag serializeNBT(boolean savingToDisk) {
        CompoundTag tag = new CompoundTag();
        if(questBoardQuest != null) {
            tag.put("questBoardQuest", questBoardQuest.serializeNBT());
        }
        tag.putInt("questsSize", quests.size());
        for(int i = 0; i < quests.size(); i++) {
            tag.put("quests" + i, quests.get(i).serializeNBT());
        }
        tag.putInt("questsCompleted", questsCompleted);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt, boolean readingFromDisk) {
        if(nbt.contains("questBoardQuest")) {
            questBoardQuest = QuestInfo.deserializeNBT(nbt.getCompound("questBoardQuest"));
        }
        quests.clear();
        for(int i = 0; i < nbt.getInt("questsSize"); i++) {
            QuestInfo quest = QuestInfo.deserializeNBT(nbt.getCompound("quests" + i));
            quests.add(quest);
        }
        questsCompleted = nbt.getInt("questsCompleted");
    }

    @Override
    public EntityCapabilityStatusPacket createUpdatePacket() {
        return new SimpleEntityCapabilityStatusPacket(player.getId(),QuestHolderAttacher.QUEST_RL,this);
    }

    @Override
    public SimpleChannel getNetworkChannel() {
        return NetworkHandler.CHANNEL;
    }

    public void updateQuests(ItemStack stack) {
        questBoardQuest.updateObjective(ForgeRegistries.ITEMS.getKey(stack.getItem()).toString(), stack.getCount());
        quests.forEach(quest -> quest.updateObjective(stack.getItem().toString(), stack.getCount()));
        updateTracking();
    }

    public int getQuestsCompleted() {
        return questsCompleted;
    }

    public void setQuestsCompleted(int questsCompleted) {
        this.questsCompleted = questsCompleted;
    }

    public QuestInfo getQuestBoardQuest() {
        return questBoardQuest;
    }

    public void setQuestBoardQuest(QuestInfo questBoardQuest) {
        this.questBoardQuest = questBoardQuest;
        updateTracking();
    }

    public List<QuestInfo> getQuests() {
        return quests;
    }

    public void setQuests(List<QuestInfo> quests) {
        this.quests = quests;
        updateTracking();
    }
}
