package net.spacetimebab.mhef.block;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.spacetimebab.mhef.init.ItemInit;
import net.spacetimebab.mhef.quest.Quests;
import net.spacetimebab.mhef.quest.api.Quest;

public class QuestBoardBlock extends Block {
    public QuestBoardBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(pPlayer.getMainHandItem().isEmpty() && !pLevel.isClientSide) {
            Quest quest = Quests.QUESTS.get(pLevel.random.nextInt(Quests.QUESTS.size()));
            ItemStack stack = new ItemStack(getItem(quest));
            stack.setHoverName(Component.literal(quest.getName()));
            pPlayer.setItemInHand(InteractionHand.MAIN_HAND, stack);
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }


    public Item getItem(Quest quest) {
        return switch (quest.getRarity()) {
            case HIGH -> ItemInit.HIGH_QUEST.get();
            case MASTER -> ItemInit.MASTER_QUEST.get();
            case COMMON -> ItemInit.COMMON_QUEST.get();
            case TEMPERED -> ItemInit.TEMPERED_QUEST.get();
        };
    }

}
