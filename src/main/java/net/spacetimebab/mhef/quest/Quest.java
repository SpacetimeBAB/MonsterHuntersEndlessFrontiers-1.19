package net.spacetimebab.mhef.quest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.storage.loot.Deserializers;
import net.minecraftforge.common.world.BiomeModifier;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public interface Quest {

    Codec<Quest> DIRECT_CODEC = ExtraCodecs.lazyInitializedCodec(() -> QuestInit.QUEST_SUPPLIER.get().getCodec())
            .dispatch(Quest::codec, Function.identity());


    Codec<? extends Quest> codec();

}
