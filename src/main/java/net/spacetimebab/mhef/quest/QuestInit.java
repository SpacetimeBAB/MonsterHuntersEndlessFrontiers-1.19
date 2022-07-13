package net.spacetimebab.mhef.quest;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;
import net.spacetimebab.mhef.MHEF;

import java.util.function.Supplier;

public class QuestInit {
    public static final DeferredRegister<Codec<? extends Quest>> QUESTS = DeferredRegister.create(new ResourceLocation(MHEF.MOD_ID, "quests"), MHEF.MOD_ID);
    public static final DeferredRegister<Codec<? extends Reward>> REWARDS = DeferredRegister.create(new ResourceLocation(MHEF.MOD_ID, "reward"), MHEF.MOD_ID);
    public static final DeferredRegister<Codec<? extends QuestObjective>> OBJECTIVES = DeferredRegister.create(new ResourceLocation(MHEF.MOD_ID, "objective"), MHEF.MOD_ID);
    public static final Supplier<IForgeRegistry<Codec<? extends Quest>>> QUEST_SUPPLIER = QUESTS.makeRegistry(() -> new RegistryBuilder<Codec<? extends Quest>>().hasTags());
    public static final Supplier<IForgeRegistry<Codec<? extends Reward>>> REWARD_SUPPLIER = REWARDS.makeRegistry(() -> new RegistryBuilder<Codec<? extends Reward>>().hasTags());
    public static final Supplier<IForgeRegistry<Codec<? extends QuestObjective>>> OBJECTIVES_SUPPLIER = OBJECTIVES.makeRegistry(() -> new RegistryBuilder<Codec<? extends QuestObjective>>().hasTags());


    public static final RegistryObject<Codec<KillObjective>> KILL_OBJECTIVE = OBJECTIVES.register("kill", () -> RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.fieldOf("entity").forGetter(KillObjective::getEntity),
            Codec.INT.fieldOf("amount").forGetter(KillObjective::getAmount)
            ).apply(instance, KillObjective::new)));

    public static final RegistryObject<Codec<CollectionObjective>> COLLECT_OBJECTIVE = OBJECTIVES.register("collect", () -> RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.fieldOf("item").forGetter(CollectionObjective::getItem),
            Codec.INT.fieldOf("amount").forGetter(CollectionObjective::getAmount)
            ).apply(instance, CollectionObjective::new)));

    public static final RegistryObject<Codec<ItemReward>> ITEM_REWARD = REWARDS.register("item", () -> RecordCodecBuilder.create(builder1 ->
            builder1.group(
                    Codec.STRING.fieldOf("item").forGetter(ItemReward::item),
                    Codec.INT.fieldOf("quantity").forGetter(ItemReward::quantity)
            ).apply(builder1, ItemReward::new)
    ));
    public static final RegistryObject<Codec<ExperienceReward>> EXPERIENCE_REWARD = REWARDS.register("experience", () -> RecordCodecBuilder.create(builder1 ->
            builder1.group(
                    Codec.INT.fieldOf("quantity").forGetter(ExperienceReward::quantity)
            ).apply(builder1, ExperienceReward::new)
    ));
    public static final RegistryObject<Codec<HuntQuest>> HUNT_QUESTS = QUESTS.register("hunt", () ->
            RecordCodecBuilder.create(builder ->
                    builder.group(
                            Codec.STRING.fieldOf("name").forGetter(HuntQuest::name),
                            Codec.STRING.fieldOf("description").forGetter(HuntQuest::description),
                            Codec.STRING.fieldOf("rarity").forGetter(HuntQuest::rarity),
                            Codec.list(Reward.DIRECT_CODEC).fieldOf("rewards").forGetter(HuntQuest::rewards),
                            Codec.list(KILL_OBJECTIVE.get()).fieldOf("objectives").forGetter(HuntQuest::objectives)
                    ).apply(builder, HuntQuest::new)
            )
    );
    public static final RegistryObject<Codec<CollectionQuest>> COLLECTION_QUESTS = QUESTS.register("collection", () ->
            RecordCodecBuilder.create(builder ->
                    builder.group(
                            Codec.STRING.fieldOf("name").forGetter(CollectionQuest::name),
                            Codec.STRING.fieldOf("description").forGetter(CollectionQuest::description),
                            Codec.STRING.fieldOf("rarity").forGetter(CollectionQuest::rarity),
                            Codec.list(Reward.DIRECT_CODEC).fieldOf("rewards").forGetter(CollectionQuest::rewards),
                            Codec.list(COLLECT_OBJECTIVE.get()).fieldOf("objectives").forGetter(CollectionQuest::objectives)
                    ).apply(builder, CollectionQuest::new)
            )
    );


    public static IForgeRegistry<Codec<? extends Quest>> getQuestRegistry() {
        return QUEST_SUPPLIER.get();
    }
    public static IForgeRegistry<Codec<? extends Reward>> getRewardRegistry() {
        return REWARD_SUPPLIER.get();
    }
    public static IForgeRegistry<Codec<? extends QuestObjective>> getObjectiveRegistry() {
        return OBJECTIVES_SUPPLIER.get();
    }
}
