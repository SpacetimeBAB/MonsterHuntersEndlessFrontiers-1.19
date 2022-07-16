package net.spacetimebab.mhef.quest.api;

import com.mojang.serialization.Codec;
import net.minecraft.util.ExtraCodecs;
import net.spacetimebab.mhef.init.QuestInit;

import java.util.function.Function;

public interface QuestObjective {
    Codec<QuestObjective> DIRECT_CODEC = ExtraCodecs.lazyInitializedCodec(() -> QuestInit.OBJECTIVES_SUPPLIER.get().getCodec())
            .dispatch(QuestObjective::codec, Function.identity());
    Codec<? extends QuestObjective> codec();

    int getAmount();
}
