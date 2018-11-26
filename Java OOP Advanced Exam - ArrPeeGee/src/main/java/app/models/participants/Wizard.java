package app.models.participants;

import app.models.Config;

public class Wizard extends BaseHero {

    public Wizard() {
        this.setStrength(Config.WIZARD_BASE_STRENGTH);
        this.setDexterity(Config.WIZARD_BASE_DEXTERITY);
        this.setIntelligence(Config.WIZARD_BASE_INTELLIGENCE);
    }

    @Override
    public double getDamage() {
       return  (this.getIntelligence() * 5) + this.getDexterity();
    }
}
