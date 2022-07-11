package net.spacetimebab.mhef.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.spacetimebab.mhef.MHEF;
import net.spacetimebab.mhef.entity.custom.*;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, MHEF.MOD_ID);

    public static final RegistryObject<EntityType<VelocipreyEntity>> VELOCIPREY =
            ENTITY_TYPES.register("velociprey",
                    () -> EntityType.Builder.of(VelocipreyEntity::new, MobCategory.MONSTER)
                            .sized(2.5f, 2.5f)
                            .build(new ResourceLocation(MHEF.MOD_ID, "velociprey").toString()));
    public static final RegistryObject<EntityType<VelocidromeEntity>> VELOCIDROME =
            ENTITY_TYPES.register("velocidrome",
                    () -> EntityType.Builder.of(VelocidromeEntity::new, MobCategory.MONSTER)
                            .sized(2.5f, 2.5f)
                            .build(new ResourceLocation(MHEF.MOD_ID, "velocidrome").toString()));

    public static final RegistryObject<EntityType<NargacugaEntity>> NARGACUGA =
            ENTITY_TYPES.register("nargacuga",
                    () -> EntityType.Builder.of(NargacugaEntity::new, MobCategory.MONSTER)
                            .sized(3f, 3f)
                            .build(new ResourceLocation(MHEF.MOD_ID, "nargacuga").toString()));
    public static final RegistryObject<EntityType<AptonothEntity>> APTONOTH =
            ENTITY_TYPES.register("aptonoth",
                    () -> EntityType.Builder.of(AptonothEntity::new, MobCategory.MONSTER)
                            .sized(3f, 3f)
                            .build(new ResourceLocation(MHEF.MOD_ID, "aptonoth").toString()));
    public static final RegistryObject<EntityType<GastodonEntity>> GASTODON =
            ENTITY_TYPES.register("gastodon",
                    () -> EntityType.Builder.of(GastodonEntity::new, MobCategory.MONSTER)
                            .sized(2.3f, 1f)
                            .build(new ResourceLocation(MHEF.MOD_ID, "gastodon").toString()));
    public static final RegistryObject<EntityType<PopoEntity>> POPO =
            ENTITY_TYPES.register("popo",
                    () -> EntityType.Builder.of(PopoEntity::new, MobCategory.MONSTER)
                            .sized(3f, 3f)
                            .build(new ResourceLocation(MHEF.MOD_ID, "popo").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
