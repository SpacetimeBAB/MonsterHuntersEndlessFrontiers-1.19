package net.spacetimebab.mhef.elements;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;

public class DragonBlightDamageSource extends DamageSource {
    public void setDragonBlight(boolean dragonBlight) {
        isDragonBlight = dragonBlight;
    }

    private boolean isDragonBlight;

    public DragonBlightDamageSource(String p_19333_) {
        super(p_19333_);
    }
    public DragonBlightDamageSource setDragonBlight(){
        this.isDragonBlight = true;
        return this;
    }


    public static DamageSource DragonBlight(){
        return (new DamageSource("DragonBlight")).bypassArmor();
    }

    public boolean isDragonBlight(){
        return this.isDragonBlight;
    }



}