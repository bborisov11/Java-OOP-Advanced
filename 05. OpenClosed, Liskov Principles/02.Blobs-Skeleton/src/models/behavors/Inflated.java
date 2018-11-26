package models.behavors;

import models.Blob;

public class Inflated extends AbstractBehavior {

    private static final int INFLATED_HEALTH_LOSES = 10;
    private static final int INFLATED_HEALTH_BONUS = 50;

    private int sourceInitialDamage;

    public void trigger(Blob source) {
        this.sourceInitialDamage = source.getDamage();
        super.setIsTriggered(true);
        this.applyRecurrentEffect(source);
    }

    public void applyRecurrentEffect(Blob source) {
        if (super.toDelayRecurrentEffect()) {
            source.setHealth(source.getHealth() + INFLATED_HEALTH_BONUS);
            super.setToDelayRecurrentEffect(false);
        } else {
           source.setHealth(source.getHealth() - INFLATED_HEALTH_LOSES);
        }
    }

    public boolean toDelayRecurrentEffect() {
        return super.toDelayRecurrentEffect;
    }

    public void setToDelayRecurrentEffect(boolean toDelayRecurrentEffect){
        super.toDelayRecurrentEffect = toDelayRecurrentEffect;
    }
}
