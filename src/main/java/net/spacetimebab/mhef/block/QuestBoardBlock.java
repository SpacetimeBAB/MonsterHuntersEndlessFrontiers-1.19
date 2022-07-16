package net.spacetimebab.mhef.block;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.FurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.spacetimebab.mhef.block.entity.QuestBoardBlockEntity;
import net.spacetimebab.mhef.cap.quest.QuestHolderAttacher;
import net.spacetimebab.mhef.init.BlockInit;
import net.spacetimebab.mhef.init.ItemInit;
import net.spacetimebab.mhef.quest.QuestInfo;
import net.spacetimebab.mhef.quest.Quests;
import net.spacetimebab.mhef.quest.api.Quest;
import net.spacetimebab.mhef.quest.objectives.CollectionObjective;
import net.spacetimebab.mhef.quest.objectives.KillObjective;
import org.jetbrains.annotations.Nullable;

public class QuestBoardBlock extends BaseEntityBlock {
    public QuestBoardBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            this.openContainer(pLevel, pPos, pPlayer);
            return InteractionResult.CONSUME;
        }
    }

    public void giveQuest(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit){
        if (pPlayer.getMainHandItem().isEmpty() && !pLevel.isClientSide) {
            QuestHolderAttacher.getQuest(pPlayer).ifPresent(questHolder -> {
                ResourceLocation questId = Quests.QUESTS.keySet().stream().toList().get(pLevel.random.nextInt(Quests.QUESTS.keySet().size()));
                Quest quest = Quests.QUESTS.get(questId);
                ItemStack stack = new ItemStack(getItem(quest));
                stack.getOrCreateTag().putString("quest", questId.toString());
                stack.setHoverName(Component.translatable(quest.getName()));
                pPlayer.setItemInHand(InteractionHand.MAIN_HAND, stack);
                Object2IntMap<String> objmap = new Object2IntOpenHashMap<>();
                quest.getObjectives().forEach(objective ->{
                    if(objective instanceof CollectionObjective collectionObjective) {
                        String item = collectionObjective.getItemName();
                        objmap.put(item, 0);
                    } else if (objective instanceof KillObjective killObjective) {
//                        objmap.put(killObjective.ge(), 0);
                    }
                });
                questHolder.setQuestBoardQuest(new QuestInfo(questId, objmap));
            });
        }
    }

    protected void openContainer(Level pLevel, BlockPos pPos, Player pPlayer) {
        BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            pPlayer.openMenu((MenuProvider)blockentity);
    }
    public Item getItem(Quest quest) {
        return switch (quest.getRarity()) {
            case HIGH -> ItemInit.HIGH_QUEST.get();
            case MASTER -> ItemInit.MASTER_QUEST.get();
            case COMMON -> ItemInit.COMMON_QUEST.get();
            case TEMPERED -> ItemInit.TEMPERED_QUEST.get();
        };
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new QuestBoardBlockEntity(pPos,pState);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @javax.annotation.Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createFurnaceTicker(Level p_151988_, BlockEntityType<T> p_151989_, BlockEntityType<? extends QuestBoardBlockEntity> p_151990_) {
        return p_151988_.isClientSide ? null : createTickerHelper(p_151989_, p_151990_, QuestBoardBlockEntity::serverTick);
    }
    @javax.annotation.Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createFurnaceTicker(pLevel, pBlockEntityType, BlockInit.QUEST_BOARD_BLOCK_ENTITY.get());
    }

}
