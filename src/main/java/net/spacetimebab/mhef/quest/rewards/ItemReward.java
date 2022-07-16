package net.spacetimebab.mhef.quest.rewards;

import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import net.spacetimebab.mhef.init.QuestInit;
import net.spacetimebab.mhef.quest.api.Reward;

public class ItemReward implements Reward {


    private final String item;
    private final int quantity;

    public ItemReward(String item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    @Override
    public Codec<? extends Reward> codec() {
        return QuestInit.ITEM_REWARD.get();
    }

    public static Integer quantity(ItemReward o) {
        return o.quantity;
    }

    public static String item(ItemReward o) {
        return o.item;
    }
    public ItemStack getItem(){
        return new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(item)),quantity);
    }
}
