package net.spacetimebab.mhef.quest;

import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Function;

public interface Reward {

    Codec<Reward> DIRECT_CODEC = ExtraCodecs.lazyInitializedCodec(() -> QuestInit.REWARD_SUPPLIER.get().getCodec())
            .dispatch(Reward::codec, Function.identity());


    Codec<? extends Reward> codec();
}
