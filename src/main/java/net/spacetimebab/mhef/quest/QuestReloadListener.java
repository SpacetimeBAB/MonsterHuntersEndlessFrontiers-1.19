package net.spacetimebab.mhef.quest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuestReloadListener extends SimpleJsonResourceReloadListener {

    private final List<Quest> quests = new ArrayList<>();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public QuestReloadListener() {
        super(GSON, "quests");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> pObject, ResourceManager pResourceManager, ProfilerFiller pProfiler) {
        for (var entry : pObject.entrySet()) {
            Quest.DIRECT_CODEC.parse(JsonOps.INSTANCE, entry.getValue())
                    .result().ifPresent(quest -> {
                                quests.add(quest);
                            }
                    );
        }
    }
}
