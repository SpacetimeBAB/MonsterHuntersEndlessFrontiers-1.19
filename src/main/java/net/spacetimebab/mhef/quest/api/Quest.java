package net.spacetimebab.mhef.quest.api;

import com.mojang.serialization.Codec;
import net.minecraft.util.ExtraCodecs;
import net.spacetimebab.mhef.init.QuestInit;

import java.util.function.Function;

public interface Quest {

    Codec<Quest> DIRECT_CODEC = ExtraCodecs.lazyInitializedCodec(() -> QuestInit.QUEST_SUPPLIER.get().getCodec())
            .dispatch(Quest::codec, Function.identity());


    Codec<? extends Quest> codec();

}
