package net.spacetimebab.mhef.elements;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;

public class LightningElementDamageSource extends DamageSource{
    public void setLightningElement(boolean lightningElement) {
        isLightningElement = lightningElement;
    }

    private boolean isLightningElement;

    public LightningElementDamageSource(String p_19333_) {
        super(p_19333_);
    }
    public LightningElementDamageSource setLightningElement(){
        this.isLightningElement = true;
        return this;
    }


    public static DamageSource LightningElement(){
        return (new EntityDamageSource("LightningElement",null));
    }

    public boolean isLightningElement(){
        return this.isLightningElement;
    }



}
