package net.spacetimebab.mhef.elements;

import net.minecraft.world.damagesource.DamageSource;

public class NoxiousPoisonDamageSource extends DamageSource {
    public void setNoxiousPoison(boolean noxiousPoison) {
        isNoxiousPoison = noxiousPoison;
    }

    private boolean isNoxiousPoison;

    public NoxiousPoisonDamageSource(String p_19333_) {
        super(p_19333_);
    }
    public NoxiousPoisonDamageSource setDragonBlight(){
        this.isNoxiousPoison = true;
        return this;
    }


    public static DamageSource NoxiousPoison(){
        return (new DamageSource("NoxiousPoison")).bypassArmor();
    }

    public boolean isDragonBlight(){
        return this.isNoxiousPoison;
    }



}
