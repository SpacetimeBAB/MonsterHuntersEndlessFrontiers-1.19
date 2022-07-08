package net.spacetimebab.mhef.elements;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;

public class FireElementDamageSource extends DamageSource{
    public void setFireElement(boolean fireElement) {
        isFireElement = fireElement;
    }

    private boolean isFireElement;

    public FireElementDamageSource(String p_19333_) {
        super(p_19333_);
    }
    public FireElementDamageSource setFireElement(){
        this.isFireElement = true;
        return this;
    }


    public static DamageSource FireElement(){
        return (new EntityDamageSource("FireElement",null));
    }

    public boolean isFireElement(){
        return this.isFireElement;
    }



}
