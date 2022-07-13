package net.spacetimebab.mhef.cap.quest;

import dev._100media.capabilitysyncer.core.LevelCapability;
import dev._100media.capabilitysyncer.network.LevelCapabilityStatusPacket;
import dev._100media.capabilitysyncer.network.SimpleLevelCapabilityStatusPacket;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.simple.SimpleChannel;
import net.spacetimebab.mhef.quest.QuestInfo;
import net.spacetimebab.mhef.network.NetworkHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestHolder extends LevelCapability {

    private Map<String, QuestInfo> particles = new HashMap<>();

    protected QuestHolder(Level level) {
        super(level);
    }


    @Override
    public CompoundTag serializeNBT(boolean savingToDisk) {
        CompoundTag tag = new CompoundTag();
        particles.forEach((name,particleInfo) -> particleInfo.saveInfo(name,tag));
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt, boolean readingFromDisk) {
        nbt.getAllKeys().forEach(key -> {
            particles.put(key,(QuestInfo.loadInfo(nbt.getCompound(key))));
        });
    }


    public void addParticle(QuestInfo particleInfo) {
        particles.put(particleInfo.getName(), particleInfo);
        this.updateTracking();
    }
    public void removeParticle(QuestInfo particleInfo) {
        particles.remove(particleInfo.getName());
        this.updateTracking();
    }
    public QuestInfo getParticle(String name) {
        return particles.get(name);
    }
    public List<QuestInfo> getParticles() {
        return new ArrayList<>(particles.values());
    }


    @Override
    public LevelCapabilityStatusPacket createUpdatePacket() {
        return new SimpleLevelCapabilityStatusPacket(QuestHolderAttacher.QUEST_RL,this);
    }

    @Override
    public SimpleChannel getNetworkChannel() {
        return NetworkHandler.CHANNEL;
    }
}
