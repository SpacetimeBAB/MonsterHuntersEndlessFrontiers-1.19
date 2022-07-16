package net.spacetimebab.mhef.quest.api;

import com.mojang.serialization.Codec;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.entity.player.Player;
import net.spacetimebab.mhef.init.QuestInit;

import java.util.List;
import java.util.function.Function;

public interface Quest {

    Codec<Quest> DIRECT_CODEC = ExtraCodecs.lazyInitializedCodec(() -> QuestInit.QUEST_SUPPLIER.get().getCodec())
            .dispatch(Quest::codec, Function.identity());

    QuestRarity getRarity();
    Codec<? extends Quest> codec();

    String getName();
    String getDescription();
    List<? extends QuestObjective> getObjectives();
    List<? extends Reward> getRewards();
    void complete(Player player);
}
