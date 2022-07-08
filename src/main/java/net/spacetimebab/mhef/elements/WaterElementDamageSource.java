package net.spacetimebab.mhef.elements;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;

public class WaterElementDamageSource extends DamageSource{
    public void setWaterElement(boolean waterElement) {
        isWaterElement = waterElement;
    }

    private boolean isWaterElement;

    public WaterElementDamageSource(String p_19333_) {
        super(p_19333_);
    }
    public WaterElementDamageSource setWaterElement(){
        this.isWaterElement = true;
        return this;
    }


    public static DamageSource WaterElement(){
        return (new EntityDamageSource("WaterElement",null));
    }

    public boolean isWaterElement(){
        return this.isWaterElement;
    }



}
