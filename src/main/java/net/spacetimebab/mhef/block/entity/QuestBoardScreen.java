package net.spacetimebab.mhef.block.entity;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.spacetimebab.mhef.MHEF;

@OnlyIn(Dist.CLIENT)
public class QuestBoardScreen extends AbstractContainerScreen<QuestBoardMenu> {
    private boolean widthTooNarrow;
    private final ResourceLocation texture;
    private static final ResourceLocation TEXTURE = new ResourceLocation(MHEF.MOD_ID, "textures/gui/quest_board.png");

    public QuestBoardScreen(QuestBoardMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.texture = TEXTURE;
    }


    public void init() {
        super.init();
        this.widthTooNarrow = this.width < 379;
        this.leftPos = (this.width - this.imageWidth) / 2;
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    public void containerTick() {
        super.containerTick();
    }

    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pPoseStack);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);

        this.renderTooltip(pPoseStack, pMouseX, pMouseY);
    }

    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pX, int pY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, this.texture);
        int i = this.leftPos;
        int j = this.topPos;
        this.blit(pPoseStack, i, j, 0, 0, this.imageWidth, this.imageHeight);

    }

    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
        return this.widthTooNarrow /*&& this.recipeBookComponent.isVisible()*/ ? true : super.mouseClicked(pMouseX, pMouseY, pButton);
    }


    protected void slotClicked(Slot pSlot, int pSlotId, int pMouseButton, ClickType pType) {
        super.slotClicked(pSlot, pSlotId, pMouseButton, pType);
    }

    public boolean keyPressed(int pKeyCode, int pScanCode, int pModifiers) {
        return /*this.recipeBookComponent.keyPressed(pKeyCode, pScanCode, pModifiers) ? false : */super.keyPressed(pKeyCode, pScanCode, pModifiers);
    }

    protected boolean hasClickedOutside(double pMouseX, double pMouseY, int pGuiLeft, int pGuiTop, int pMouseButton) {
        return pMouseX < (double) pGuiLeft || pMouseY < (double) pGuiTop || pMouseX >= (double) (pGuiLeft + this.imageWidth) || pMouseY >= (double) (pGuiTop + this.imageHeight);
    }

    public boolean charTyped(char pCodePoint, int pModifiers) {
        return super.charTyped(pCodePoint, pModifiers);
    }


    public void removed() {
        super.removed();
    }
}