package net.spacetimebab.mhef.elements;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;

public class DragonElementDamageSource extends DamageSource{
    public void setDragonElement(boolean dragonElement) {
        isDragonElement = dragonElement;
    }

    private boolean isDragonElement;

    public DragonElementDamageSource(String p_19333_) {
        super(p_19333_);
    }
    public DragonElementDamageSource setDragonElement(){
        this.isDragonElement = true;
        return this;
    }


    public static DamageSource DragonElement(){
        return (new EntityDamageSource("DragonElement",null));
    }

    public boolean isDragonElement(){
        return this.isDragonElement();
    }



}
