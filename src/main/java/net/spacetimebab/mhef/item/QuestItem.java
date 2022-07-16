package net.spacetimebab.mhef.item;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.spacetimebab.mhef.cap.quest.QuestHolderAttacher;
import net.spacetimebab.mhef.init.BlockInit;
import net.spacetimebab.mhef.quest.Quests;
import net.spacetimebab.mhef.quest.api.Quest;
import net.spacetimebab.mhef.quest.client.QuestViewScreen;
import net.spacetimebab.mhef.quest.rewards.ExperienceReward;
import net.spacetimebab.mhef.quest.rewards.ItemReward;

public class QuestItem extends Item {

    public QuestItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(pPlayer.getMainHandItem().is(this)) {
            if (pLevel.isClientSide) {
                Quest quest = Quests.QUESTS.get(new ResourceLocation(pPlayer.getMainHandItem().getOrCreateTag().getString("quest")));
                Minecraft.getInstance().setScreen(new QuestViewScreen(quest));
            }
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide){
            if(pContext.getHand()==InteractionHand.MAIN_HAND) {
                if (pContext.getLevel().getBlockState(pContext.getClickedPos()).is((BlockInit.QUEST_BOARD.get()))) {
                    QuestHolderAttacher.getQuest(pContext.getPlayer()).ifPresent(questHolder -> {
                        Quest quest = Quests.QUESTS.get(new ResourceLocation(pContext.getPlayer().getMainHandItem().getOrCreateTag().getString("quest")));
                        if (questHolder.getQuestBoardQuest() != null) {
                            if (questHolder.getQuestBoardQuest().isForQuest(quest)) {
                                if (questHolder.getQuestBoardQuest().isCompleted(quest)) {
                                    quest.getRewards().forEach(reward -> {
                                        if (reward instanceof ItemReward itemReward) {
                                            pContext.getPlayer().addItem(itemReward.getItem());
                                        } else if (reward instanceof ExperienceReward experienceReward) {
                                            pContext.getPlayer().giveExperiencePoints(experienceReward.getQuantity());
                                        }
                                    });
                                    quest.complete(pContext.getPlayer());
                                    pContext.getPlayer().getMainHandItem().shrink(1);
                                }
                            }
                        }
                    });
                }
            }
        }
        return InteractionResult.CONSUME;
    }
}
