package net.spacetimebab.mhef.block.entity;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.spacetimebab.mhef.init.ContainerInit;

public class QuestBoardMenu extends AbstractContainerMenu {
   private final Container container;
   protected final Level level;


   public QuestBoardMenu(int p_39532_, Inventory p_39533_, FriendlyByteBuf buf) {
      this(ContainerInit.QUEST_BOARD_MENU.get(), p_39532_, p_39533_);
   }
   public QuestBoardMenu(MenuType<?> p_38960_, int p_38963_, Inventory p_38964_) {
      this(p_38960_, p_38963_, p_38964_, new SimpleContainer(5));
   }

   protected QuestBoardMenu(MenuType<?> p_38966_, int p_38969_, Inventory p_38970_, Container p_38971_) {
      super(p_38966_, p_38969_);
      this.container = p_38971_;
      this.level = p_38970_.player.level;
      this.addSlot(new Slot(p_38971_, 0, 11, 25));
      this.addSlot(new Slot( p_38971_, 1, 44, 50));
      this.addSlot(new Slot( p_38971_, 2, 77, 33));
      this.addSlot(new Slot( p_38971_, 3, 110, 29));
      this.addSlot(new Slot( p_38971_, 4, 143, 56));

      for (int i = 0; i < 3; ++i) {
         for (int j = 0; j < 9; ++j) {
            this.addSlot(new Slot(p_38970_, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
         }
      }

      for (int k = 0; k < 9; ++k) {
         this.addSlot(new Slot(p_38970_, k, 8 + k * 18, 142));
      }

   }

   public void fillCraftSlotsStackedContents(StackedContents pItemHelper) {
      if (this.container instanceof StackedContentsCompatible) {
         ((StackedContentsCompatible) this.container).fillStackedContents(pItemHelper);
      }

   }

   public void clearCraftingContent() {
      this.getSlot(0).set(ItemStack.EMPTY);
      this.getSlot(2).set(ItemStack.EMPTY);
   }






   public int getSize() {
      return 5;
   }

   /**
    * Determines whether supplied player can use this container
    */
   public boolean stillValid(Player pPlayer) {
      return this.container.stillValid(pPlayer);
   }

   /**
    * Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player
    * inventory and the other inventory(s).
    */
   public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
      ItemStack itemstack = ItemStack.EMPTY;
      Slot slot = this.slots.get(pIndex);
      if (slot != null && slot.hasItem()) {
         ItemStack itemstack1 = slot.getItem();
         itemstack = itemstack1.copy();
         if (pIndex == 2) {
            if (!this.moveItemStackTo(itemstack1, 3, 39, true)) {
               return ItemStack.EMPTY;
            }

            slot.onQuickCraft(itemstack1, itemstack);
         } else if (pIndex != 1 && pIndex != 0) {
            if (pIndex >= 3 && pIndex < 30) {
               if (!this.moveItemStackTo(itemstack1, 30, 39, false)) {
                  return ItemStack.EMPTY;
               }
            } else if (pIndex >= 30 && pIndex < 39 && !this.moveItemStackTo(itemstack1, 3, 30, false)) {
               return ItemStack.EMPTY;
            }
         } else if (!this.moveItemStackTo(itemstack1, 3, 39, false)) {
            return ItemStack.EMPTY;
         }

         if (itemstack1.isEmpty()) {
            slot.set(ItemStack.EMPTY);
         } else {
            slot.setChanged();
         }

         if (itemstack1.getCount() == itemstack.getCount()) {
            return ItemStack.EMPTY;
         }

         slot.onTake(pPlayer, itemstack1);
      }

      return itemstack;
   }







}