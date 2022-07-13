package net.spacetimebab.mhef.quest;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.nbt.CompoundTag;

import java.util.Arrays;
import java.util.List;

public class QuestInfo {


    private static <O> List<String> getRewards(O o) {
        return List.of("");
    }

    private static <O> String getRarity(O o) {
        return "";
    }

    QuestInfo(String name, String description, String rarity,String rewards) {

    }




    private static <O> String getDescription(O o) {
        return "";
    }

    public static QuestInfo loadInfo(CompoundTag compound) {
        return new QuestInfo("","","","");
    }

    public void saveInfo(String name, CompoundTag tag) {
    }

    public String getName() {
        return "";
    }
}
