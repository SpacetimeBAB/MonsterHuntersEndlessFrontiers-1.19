package net.spacetimebab.mhef.cap.quest;

import dev._100media.capabilitysyncer.core.CapabilityAttacher;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;
import net.spacetimebab.mhef.MHEF;


@Mod.EventBusSubscriber(modid = MHEF.MOD_ID)
public class QuestHolderAttacher extends CapabilityAttacher {

    public static final Capability<QuestHolder> QUEST_CAPABILITY = getCapability(new CapabilityToken<>() {
    });
    public static final ResourceLocation QUEST_RL = new ResourceLocation(MHEF.MOD_ID, "quest");
    private static final Class<QuestHolder> CAPABILITY_CLASS = QuestHolder.class;

    public static QuestHolder getQuestUnwrap(Level player) {
        return getQuest(player).orElse(null);
    }

    public static LazyOptional<QuestHolder> getQuest(Level player) {
        return player.getCapability(QUEST_CAPABILITY);
    }

    private static void attach(AttachCapabilitiesEvent<Level> event, Level player) {
        genericAttachCapability(event, new QuestHolder(player), QUEST_CAPABILITY, QUEST_RL);
    }

    public static void register() {
        CapabilityAttacher.registerCapability(CAPABILITY_CLASS);
        CapabilityAttacher.registerLevelAttacher(Level.class, QuestHolderAttacher::attach, QuestHolderAttacher::getQuest);
    }

}
