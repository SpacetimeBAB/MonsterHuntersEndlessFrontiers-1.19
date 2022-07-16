package net.spacetimebab.mhef.cap.quest;

import dev._100media.capabilitysyncer.core.CapabilityAttacher;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
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

    public static QuestHolder getQuestUnwrap(Player player) {
        return getQuest(player).orElse(null);
    }

    public static LazyOptional<QuestHolder> getQuest(Player player) {
        return player.getCapability(QUEST_CAPABILITY);
    }

    private static void attach(AttachCapabilitiesEvent<Entity> event, Player player) {
        genericAttachCapability(event, new QuestHolder(player), QUEST_CAPABILITY, QUEST_RL);
    }

    public static void register() {
        CapabilityAttacher.registerCapability(CAPABILITY_CLASS);
        CapabilityAttacher.registerPlayerAttacher(QuestHolderAttacher::attach, QuestHolderAttacher::getQuest,true);
    }

}
