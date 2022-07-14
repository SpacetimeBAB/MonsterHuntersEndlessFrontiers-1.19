package net.spacetimebab.mhef.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.spacetimebab.mhef.init.BlockInit;

import static net.spacetimebab.mhef.MHEF.MOD_ID;

public class ModBlockStateProvider extends BlockStateProvider {

    private final ExistingFileHelper existingFileHelper;

    public ModBlockStateProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, MOD_ID, existingFileHelper);
        this.existingFileHelper = existingFileHelper;
    }


    @Override
    protected void registerStatesAndModels() {
//        DinoEggBlock.MOD_EGGS.forEach(this::egg);
//        egg(DinoEggBlock.MOD_EGGS.get(0));
        simpleCubeTopSideBlockState(BlockInit.QUEST_BOARD.get());
    }

    protected void simpleCubeBottomTopBlockState(Block block) {
        simpleBlock(block, blockCubeTopModel(block));
    }
    protected void simpleCubeTopSideBlockState(Block block) {
        simpleBlock(block, blockCubeTopSideModel(block));
    }


    protected BlockModelBuilder blockCubeTopModel(Block block) {
        String name = getName(block);
        return models().cubeBottomTop(name, modLoc("block/" + name + "_side"), modLoc("block/" + name + "_bottom"), modLoc("block/" + name + "_top"));
    }
    protected BlockModelBuilder blockCubeTopSideModel(Block block) {
        String name = getName(block);
        return models().cubeBottomTop(name, modLoc("block/" + name + "_side"), modLoc("block/" + name + "_top"), modLoc("block/" + name + "_top"));
    }

    protected String getName(Block item) {
        return ForgeRegistries.BLOCKS.getKey(item).getPath();
    }


    public ModelBuilder<BlockModelBuilder> withOutExistingParent(String name, ResourceLocation parent) {
        return models().getBuilder(name).parent(nonExistingFile(parent));
    }

    public ModelFile.UncheckedModelFile nonExistingFile(ResourceLocation path) {
        ModelFile.UncheckedModelFile ret = new ModelFile.UncheckedModelFile(path);
        ret.assertExistence();
        return ret;
    }
    public BlockModelBuilder singleTexture(String name, ResourceLocation parent, String textureKey, ResourceLocation texture) {
        return withOutExistingParent(name, parent)
                .texture(textureKey, texture);
    }
}
