package net.spacetimebab.mhef.datagen;

import com.google.common.base.Preconditions;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.spacetimebab.mhef.MHEF;
import net.spacetimebab.mhef.init.BlockInit;
import net.spacetimebab.mhef.init.ItemInit;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class ModItemModelProvider extends ItemModelProvider {
    private final ExistingFileHelper existingFileHelper;
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, MHEF.MOD_ID, existingFileHelper);
        this.existingFileHelper = existingFileHelper;
    }

    @Override
    protected void registerModels() {

//        Stream.of()
//                .map(Supplier::get)
//                .forEach(this::simpleHandHeldModel);


//        ItemInit.ITEMS.getEntries().stream().filter(item -> item.getId().getPath().contains("dna") || item.getId().getPath().contains("egg"))
//                .map(Supplier::get)
//                .forEach(this::simpleGeneratedModel);

        Stream.of(
                        ItemInit.COMMON_QUEST,
                        ItemInit.HIGH_QUEST,
                        ItemInit.MASTER_QUEST,
                        ItemInit.TEMPERED_QUEST
                ).map(Supplier::get)
                .forEach(this::simpleGeneratedModel);


        Stream.of(
                        BlockInit.QUEST_BOARD
                )
                .map(Supplier::get)
                .forEach(this::simpleBlockItemModel);
    }

    protected ItemModelBuilder simpleBlockItemModel(Block block) {
        String name = getName(block);
        ModelFile.UncheckedModelFile ret = new ModelFile.UncheckedModelFile(extendWithFolder(modLoc("block/" + name)));
        return getBuilder(name).parent(ret);
//        return withExistingParent(name,);
    }

    protected ItemModelBuilder simpleGeneratedModel(Item item) {
        return simpleModel(item, mcLoc("item/generated"));
    }

    protected ItemModelBuilder simpleHandHeldModel(Item item) {
        return simpleModel(item, mcLoc("item/handheld"));
    }

    protected ItemModelBuilder simpleModel(Item item, ResourceLocation parent) {
        String name = getName(item);
        return singleTexture(name, parent, "layer0", modLoc("item/" + name));
    }


    protected String getName(Item item) {
        return ForgeRegistries.ITEMS.getKey(item).getPath();
    }

    protected String getName(Block item) {
        return ForgeRegistries.BLOCKS.getKey(item).getPath();
    }

    @Override
    public ItemModelBuilder getBuilder(String path) {
        Preconditions.checkNotNull(path, "Path must not be null");
        ResourceLocation outputLoc = extendWithFolder(path.contains(":") ? new ResourceLocation(path) : new ResourceLocation(modid, path));
        this.existingFileHelper.trackGenerated(outputLoc, MODEL);
        return generatedModels.computeIfAbsent(outputLoc, loc -> new ItemModelBuilder(loc, existingFileHelper));
    }

    private ResourceLocation extendWithFolder(ResourceLocation rl) {
        if (rl.getPath().contains("/")) {
            return rl;
        }
        return new ResourceLocation(rl.getNamespace(), folder + "/" + rl.getPath());
    }
}
