package net.spacetimebab.mhef.quest;

import com.mojang.serialization.Codec;
import net.minecraft.util.ExtraCodecs;

import java.util.function.Function;

public interface QuestObjective {
    Codec<QuestObjective> DIRECT_CODEC = ExtraCodecs.lazyInitializedCodec(() -> QuestInit.OBJECTIVES_SUPPLIER.get().getCodec())
            .dispatch(QuestObjective::codec, Function.identity());
    Codec<? extends QuestObjective> codec();
}
