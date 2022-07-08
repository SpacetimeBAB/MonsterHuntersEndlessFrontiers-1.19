package net.spacetimebab.mhef.elements;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;

public class IceElementDamageSource extends DamageSource{
    public void setIceElement(boolean iceElement) {
        isIceElement = iceElement;
    }

    private boolean isIceElement;

    public IceElementDamageSource(String p_19333_) {
        super(p_19333_);
    }
    public IceElementDamageSource setIceElement(){
        this.isIceElement = true;
        return this;
    }


    public static DamageSource IceElement(){
        return (new EntityDamageSource("IceElement",null));
    }

    public boolean isIceElement(){
        return this.isIceElement;
    }



}
