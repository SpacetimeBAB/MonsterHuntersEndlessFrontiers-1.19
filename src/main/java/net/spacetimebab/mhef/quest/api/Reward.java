package net.spacetimebab.mhef.quest.api;

import com.mojang.serialization.Codec;
import net.minecraft.util.ExtraCodecs;
import net.spacetimebab.mhef.init.QuestInit;

import java.util.List;
import java.util.function.Function;

public interface Reward {

    Codec<Reward> DIRECT_CODEC = ExtraCodecs.lazyInitializedCodec(() -> QuestInit.REWARD_SUPPLIER.get().getCodec())
            .dispatch(Reward::codec, Function.identity());

    Codec<? extends Reward> codec();
}
