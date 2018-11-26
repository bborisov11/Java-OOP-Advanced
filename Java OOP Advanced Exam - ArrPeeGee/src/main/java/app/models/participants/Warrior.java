package app.models.participants;

import app.contracts.Hero;
import app.models.Config;
public class Warrior extends BaseHero {

    public Warrior() {
        this.setStrength(Config.WARRIOR_BASE_STRENGTH);
         this.setDexterity(Config.WARRIOR_BASE_DEXTERITY);
         this.setIntelligence(Config.WARRIOR_BASE_INTELLIGENCE);
    }

    @Override
    public double getDamage() {
        return (this.getStrength() * 2) + this.getDexterity();
    }
}
