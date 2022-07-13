package net.spacetimebab.mhef.network;

import dev._100media.capabilitysyncer.network.SimpleLevelCapabilityStatusPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.spacetimebab.mhef.MHEF;
import net.spacetimebab.mhef.cap.quest.QuestHolderAttacher;

import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class NetworkHandler {
    private static final String PROTOCOL_VERSION = "1.6";
    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(MHEF.MOD_ID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );
    private static int nextId = 0;

    public static void register() {
        Stream.<BiConsumer<SimpleChannel, Integer>>builder()
                .add((channel, id) -> SimpleLevelCapabilityStatusPacket.register(QuestHolderAttacher.QUEST_RL, QuestHolderAttacher::getQuestUnwrap, channel, id))
                .build().forEach(consumer -> consumer.accept(CHANNEL, getNextId()));
    }

    private static int getNextId() {
        return nextId++;
    }
}