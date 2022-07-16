package net.spacetimebab.mhef.quest.client;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec2;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.spacetimebab.mhef.MHEF;
import net.spacetimebab.mhef.cap.quest.QuestHolder;
import net.spacetimebab.mhef.cap.quest.QuestHolderAttacher;
import net.spacetimebab.mhef.quest.QuestInfo;
import net.spacetimebab.mhef.quest.api.Quest;
import net.spacetimebab.mhef.quest.api.QuestObjective;
import net.spacetimebab.mhef.quest.api.Reward;
import net.spacetimebab.mhef.quest.objectives.CollectionObjective;
import net.spacetimebab.mhef.quest.rewards.ItemReward;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.IntFunction;

@OnlyIn(Dist.CLIENT)
public class QuestViewScreen extends Screen {
    public static final ResourceLocation BOOK_LOCATION = new ResourceLocation(MHEF.MOD_ID, "textures/gui/quest.png");
    private final Map<Vec2, ItemStack> OBJECTIVE_TOOLTIP_ITEMS = new HashMap<>();
    private final Map<Vec2, ItemStack> REWARD_TOOLTIP_ITEMS = new HashMap<>();
    private Quest quest;
    private QuestInfo questInfo;
    private List<FormattedCharSequence> cachedPageComponents = Collections.emptyList();
    private List<FormattedCharSequence> cachedTitleComponents = Collections.emptyList();

    public QuestViewScreen(Quest quest) {
        super(NarratorChatListener.NO_TITLE);
        this.quest = quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }


    protected void init() {
        this.createMenuControls();
        this.cachedTitleComponents = this.font.split(FormattedText.of(quest.getName()), 114);
        this.cachedPageComponents = this.font.split(FormattedText.of(quest.getDescription()), 160);
        QuestHolderAttacher.getQuest(this.minecraft.player).ifPresent(attacher -> {
            if(attacher.getQuestBoardQuest().isForQuest(quest)){
                questInfo = attacher.getQuestBoardQuest();
            }
            attacher.getQuests().forEach(questInfo -> {
                if(questInfo.isForQuest(quest)){
                    this.questInfo = questInfo;
                }
            });
        });
    }

    protected void createMenuControls() {
        this.addRenderableWidget(new Button(this.width / 2 - 100, 196, 200, 20, CommonComponents.GUI_DONE, (p_98299_) -> {
            this.minecraft.setScreen((Screen) null);
        }));
    }


    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pPoseStack);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, BOOK_LOCATION);
        int i = (this.width - 192) / 2;
        int j = 2;
        float yT = 2;
        this.blit(pPoseStack, i, 2, 0, 0, 192, 192);
        int line = 0;
        yT += 18;
        for (int iL = 0; iL < this.cachedTitleComponents.size(); ++iL) {
            FormattedCharSequence component = this.cachedTitleComponents.get(iL);
            float i1 = this.font.width(component) / 2f;
            this.font.draw(pPoseStack, component, (float) (this.width / 2f) - i1, yT, 0);
            yT += 9;
            line++;
        }
        int k = Math.min(128 / 9, this.cachedPageComponents.size());

        pPoseStack.scale(0.75f, 0.75f, 0.75f);
        yT += 3;
        for (int l = 0; l < k; ++l) {
            yT += 9;
            this.font.draw(pPoseStack, this.cachedPageComponents.get(l), (float) (i + 36) * 1.32f, yT, 0);
            line++;
        }
        pPoseStack.scale(1f / 0.75f, 1f / 0.75f, 1f / 0.75f);
        yT -= cachedPageComponents.size() * 2;
        ;
        this.font.draw(pPoseStack, Component.translatable("Objective(s)"), (float) (i + 36), yT, 0);
        this.hLine(pPoseStack, i + 36, i + 192, 32 + line * 9 + 8, 0);
        yT += 9;
        for (QuestObjective objective : quest.getObjectives()) {
            if (objective instanceof CollectionObjective collectionObjective) {
                renderFloatingItem(collectionObjective.getItem(), (i + 36), (int) yT, null);
                OBJECTIVE_TOOLTIP_ITEMS.put(new Vec2(i + 36, (int) yT), collectionObjective.getItem());
            }
            line++;
        }
        yT += 20;
        this.font.draw(pPoseStack, Component.translatable("Rewards(s)"), (float) (i + 36), yT, 0);
        yT += 9;
        this.hLine(pPoseStack, i + 36, i + 192, 32 + line * 9 + 8, 0);
        line++;
        int xoffset = 0;
        for (Reward objective : quest.getRewards()) {
            if (objective instanceof ItemReward collectionObjective) {
                renderFloatingItem(collectionObjective.getItem(), (i + 36) + xoffset, (int) yT, null);
                REWARD_TOOLTIP_ITEMS.put(new Vec2(i + 36 + xoffset, (int) yT), collectionObjective.getItem());
            }
            xoffset += 16;
            line++;
        }


        Style style = this.getClickedComponentStyleAt((double) pMouseX, (double) pMouseY);
        if (style != null) {
            this.renderComponentHoverEffect(pPoseStack, style, pMouseX, pMouseY);
        }

        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pPoseStack, pMouseX, pMouseY);
    }

    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
        if (pButton == 0) {
            Style style = this.getClickedComponentStyleAt(pMouseX, pMouseY);
            if (style != null && this.handleComponentClicked(style)) {
                return true;
            }
        }

        return super.mouseClicked(pMouseX, pMouseY, pButton);
    }

    public boolean handleComponentClicked(Style pStyle) {
        ClickEvent clickevent = pStyle.getClickEvent();
        if (clickevent == null) {
            return false;
        } else {
            boolean flag = super.handleComponentClicked(pStyle);
            if (flag && clickevent.getAction() == ClickEvent.Action.RUN_COMMAND) {
                this.closeScreen();
            }

            return flag;
        }
    }

    protected void closeScreen() {
        this.minecraft.setScreen((Screen) null);
    }

    @Nullable
    public Style getClickedComponentStyleAt(double pMouseX, double pMouseY) {
        if (this.cachedPageComponents.isEmpty()) {
            return null;
        } else {
            int i = Mth.floor(pMouseX - (double) ((this.width - 192) / 2) - 36.0D);
            int j = Mth.floor(pMouseY - 2.0D - 30.0D);
            if (i >= 0 && j >= 0) {
                int k = Math.min(128 / 9, this.cachedPageComponents.size());
                if (i <= 114 && j < 9 * k + k) {
                    int l = j / 9;
                    if (l >= 0 && l < this.cachedPageComponents.size()) {
                        FormattedCharSequence formattedcharsequence = this.cachedPageComponents.get(l);
                        return this.minecraft.font.getSplitter().componentStyleAtWidth(formattedcharsequence, i);
                    } else {
                        return null;
                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
    }

    static List<String> loadPages(CompoundTag pTag) {
        ImmutableList.Builder<String> builder = ImmutableList.builder();
        loadPages(pTag, builder::add);
        return builder.build();
    }

    public static void loadPages(CompoundTag pTag, Consumer<String> pConsumer) {
        ListTag listtag = pTag.getList("pages", 8).copy();
        IntFunction<String> intfunction;
        if (Minecraft.getInstance().isTextFilteringEnabled() && pTag.contains("filtered_pages", 10)) {
            CompoundTag compoundtag = pTag.getCompound("filtered_pages");
            intfunction = (p_169702_) -> {
                String s = String.valueOf(p_169702_);
                return compoundtag.contains(s) ? compoundtag.getString(s) : listtag.getString(p_169702_);
            };
        } else {
            intfunction = listtag::getString;
        }

        for (int i = 0; i < listtag.size(); ++i) {
            pConsumer.accept(intfunction.apply(i));
        }

    }

    private void renderFloatingItem(ItemStack pStack, int pX, int pY, String pAltText) {
        PoseStack posestack = RenderSystem.getModelViewStack();
        posestack.translate(0.0D, 0.0D, 32.0D);
        RenderSystem.applyModelViewMatrix();
        this.setBlitOffset(200);
        this.itemRenderer.blitOffset = 200.0F;
        net.minecraft.client.gui.Font font = net.minecraftforge.client.RenderProperties.get(pStack).getFont(pStack);
        if (font == null) font = this.font;
        this.itemRenderer.renderAndDecorateItem(pStack, pX, pY);
        this.itemRenderer.renderGuiItemDecorations(font, pStack, pX, pY, pAltText);
        this.setBlitOffset(0);
        this.itemRenderer.blitOffset = 0.0F;
    }



    protected void renderTooltip(PoseStack pPoseStack, int pX, int pY) {
        Vec2 vec2 = new Vec2(pX, pY);
        OBJECTIVE_TOOLTIP_ITEMS.forEach((key, value) -> {
            double x = key.x;
            double y = key.y;
            if ((x <= pX && pX <= x + 16) && (y <= pY && pY <= y + 16)) {

                this.renderQuestTooltip(pPoseStack, value, pX, pY, true);
            }
        });
        REWARD_TOOLTIP_ITEMS.forEach((key, value) -> {
            double x = key.x;
            double y = key.y;
            if ((x <= pX && pX <= x + 16) && (y <= pY && pY <= y + 16)) {

                this.renderQuestTooltip(pPoseStack, value, pX, pY, false);
            }
        });
    }
    protected void renderQuestTooltip(PoseStack pPoseStack, ItemStack pItemStack, int pMouseX, int pMouseY, boolean objective) {
        ItemStack tooltipStack = pItemStack;
        List<Component> tooltip = this.getTooltipFromItem(pItemStack);
        if(objective) {
            int progress = questInfo.checkObjective(tooltipStack.getItem());
            String s = progress + "/" + pItemStack.getCount();
            tooltip.add(Component.translatable(s).withStyle(progress == pItemStack.getCount() ? ChatFormatting.DARK_GREEN : ChatFormatting.DARK_RED));
        }
        this.renderTooltip(pPoseStack, tooltip, pItemStack.getTooltipImage(), pMouseX, pMouseY);
        tooltipStack = ItemStack.EMPTY;
    }
}