package app.models.participants;

import app.contracts.Targetable;
import app.models.Config;

public abstract class BaseParticipant implements Targetable {

    private String name;
    private double health;
    private double damage;
    private double gold;

    protected BaseParticipant() {
        this.gold = Config.BOSS_GOLD;
        this.setHealth(Config.BOSS_HEALTH);
        this.damage = Config.BOSS_DAMAGE;
    }

    @Override
    public String attack(Targetable target) {
        if (!this.isAlive()) {
            return this.getName() + " is dead! Cannot attack.";
        }

        if (!target.isAlive()){
            return target.getName() + " is dead! Cannot be attacked.";
        }

        target.takeDamage(this.getDamage());

        String result = this.getName() + " attacked!";
        if (!target.isAlive()) {
            this.levelUp();
            target.giveReward(this);
            result += String.format(" %s has been slain by %s.", target.getName(), this.getName());
        }

        return result;
    }
    @Override
    public void takeDamage(double damage) {
        this.setHealth(this.getHealth() - damage);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public double getDamage() {
       return this.damage;
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public double getGold() {
        return this.gold;
    }

    @Override
    public void setHealth(double health) {
        this.health = health;
    }

    @Override
    public abstract void giveReward(Targetable targetable);

    @Override
    public abstract void receiveReward(double reward);

    @Override
    public abstract void levelUp();

    @Override
    public boolean isAlive() {
        if(this.getHealth() <= 0) {
            return false;
        }
        return true;
    }
}
