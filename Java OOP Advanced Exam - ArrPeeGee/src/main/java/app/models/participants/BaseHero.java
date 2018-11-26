package app.models.participants;

import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.Config;

public abstract class BaseHero extends BaseParticipant implements Hero {

    private int strength;
    private int dexterity;
    private int intelligence;
    private int level;

    private double health;
    private String name;
    private boolean isAlive;
    private double gold;

    protected BaseHero(){
        this.isAlive = true;
        this.level = 1;
        this.gold = Config.HERO_START_GOLD;
    }

    public double getReward(){
        return this.gold;
    }

    @Override
    public  void giveReward(Targetable targetable) {
        targetable.receiveReward(this.gold);
        this.gold = 0;
    }

    @Override
    public void receiveReward(double reward) {
        this.gold += reward;
    }

    public int getStrength() {
        return strength;
    }

    public  void setStrength(int strength) {
        this.strength = strength;
        this.setHealth(strength * Config.HERO_HEALTH_MULTIPLIER);
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void levelUp() {
        this.setHealth(this.getHealth() * Config.HERO_HEALTH_MULTIPLIER);
        this.setStrength(this.getStrength() * 2);
        this.setDexterity(this.getDexterity() * 2);
        this.setIntelligence(this.getIntelligence() * 2);
        this.level += 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("  Name: %s | Class: %s", this.getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("  Health: %.2f | Damage: %.2f", this.getHealth(), this.getDamage()))
                .append(System.lineSeparator())
                .append(String.format("  %d STR | %d DEX | %d INT | %.2f Gold", this.getStrength(),
                        this.getDexterity(), this.getIntelligence(), this.gold));

        return sb.toString();
    }
}
