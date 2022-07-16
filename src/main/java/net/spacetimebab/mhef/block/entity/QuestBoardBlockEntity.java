package net.spacetimebab.mhef.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.spacetimebab.mhef.init.BlockInit;
import net.spacetimebab.mhef.init.ContainerInit;
import net.spacetimebab.mhef.init.ItemInit;
import net.spacetimebab.mhef.quest.Quests;
import net.spacetimebab.mhef.quest.api.Quest;

import javax.annotation.Nullable;

public class QuestBoardBlockEntity extends BaseContainerBlockEntity {

    protected NonNullList<ItemStack> items = NonNullList.withSize(5, ItemStack.EMPTY);
    private int timeTilRefresh= 0;

    public QuestBoardBlockEntity(BlockPos p_155077_, BlockState p_155078_) {
        super(BlockInit.QUEST_BOARD_BLOCK_ENTITY.get(), p_155077_, p_155078_);
    }

    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(pTag, this.items);
        this.timeTilRefresh = pTag.getInt("TimeTilRefresh");

    }
    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        ContainerHelper.saveAllItems(pTag, this.items);
        pTag.putInt("TimeTilRefresh", this.timeTilRefresh);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("");
    }

    @Override
    protected AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
        return new QuestBoardMenu(ContainerInit.QUEST_BOARD_MENU.get(), pContainerId, pInventory, this);
    }

    @Override
    public int getContainerSize() {
        return 5;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public ItemStack getItem(int pIndex) {
        return items.get(pIndex);
    }

    @Override
    public ItemStack removeItem(int pIndex, int pCount) {
        return ContainerHelper.removeItem(this.items, pIndex, pCount);
    }

    @Override
    public ItemStack removeItemNoUpdate(int pIndex) {
        return ContainerHelper.takeItem(this.items, pIndex);
    }

    @Override
    public void setItem(int pIndex, ItemStack pStack) {
        this.items.set(pIndex, pStack);
        if (pStack.getCount() > this.getMaxStackSize()) {
            pStack.setCount(this.getMaxStackSize());
        }

        this.level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
        this.setChanged();

    }

    @Override
    public boolean stillValid(Player pPlayer) {
        if (this.level.getBlockEntity(this.worldPosition) != this) {
            return false;
        } else {
            return pPlayer.distanceToSqr((double) this.worldPosition.getX() + 0.5D, (double) this.worldPosition.getY() + 0.5D, (double) this.worldPosition.getZ() + 0.5D) <= 64.0D;
        }
    }

    @Override
    public void clearContent() {
        this.items.clear();
    }

    public boolean canPlaceItem(int pIndex, ItemStack pStack) {
        return pIndex > 4;
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, QuestBoardBlockEntity pBlockEntity) {
        if(pBlockEntity.timeTilRefresh > 0) {
            pBlockEntity.timeTilRefresh--;
        } else {
            pBlockEntity.timeTilRefresh = 600;
            pBlockEntity.refresh();
        }
    }

    private void refresh() {
        for(int i = 0; i < this.items.size(); i++) {
            ResourceLocation questId = Quests.QUESTS.keySet().stream().toList().get(level.random.nextInt(Quests.QUESTS.keySet().size()));
            Quest quest = Quests.QUESTS.get(questId);
            ItemStack stack = new ItemStack(getQuestItem(quest));
            stack.getOrCreateTag().putString("quest", questId.toString());
            stack.setHoverName(Component.translatable(quest.getName()));
            this.items.set(i, stack);
        }
    }
    public Item getQuestItem(Quest quest) {
        return switch (quest.getRarity()) {
            case HIGH -> ItemInit.HIGH_QUEST.get();
            case MASTER -> ItemInit.MASTER_QUEST.get();
            case COMMON -> ItemInit.COMMON_QUEST.get();
            case TEMPERED -> ItemInit.TEMPERED_QUEST.get();
        };
    }
}
