package net.spacetimebab.mhef.quest.objectives;

import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import net.spacetimebab.mhef.init.QuestInit;
import net.spacetimebab.mhef.quest.api.QuestObjective;

public class CollectionObjective implements QuestObjective {


    private final String item;
    private Integer amount;

    public CollectionObjective(String item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    @Override
    public Codec<? extends QuestObjective> codec() {
        return QuestInit.COLLECT_OBJECTIVE.get();
    }

    @Override
    public int getAmount() {
        return amount;
    }

    public static Integer quantity(CollectionObjective o) {
        return o.amount;
    }

    public static String item(CollectionObjective o) {
        return o.item;
    }
    public ItemStack getItem(){
        return new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(item)),amount);
    }
    public String getItemName(){
        return item;
    }
    public static String getName(CollectionObjective o) {
        return o.item;
    }
}
