package app.models.participants;

import app.contracts.Targetable;
import app.models.Config;

public class Boss extends BaseParticipant {
    private String name;
    private double health;
    private double damage;
    private double gold;
    private int level;

    public Boss() {
        this.gold = Config.BOSS_GOLD;
        this.setHealth(Config.BOSS_HEALTH);
        this.level = 1;
    }

    @Override
    public void giveReward(Targetable targetable) {
        targetable.receiveReward(this.gold);
    }

    @Override
    public void receiveReward(double reward) {
        this.gold += reward * 1.1;
    }

    @Override
    public void levelUp() {
        this.setHealth(Config.BOSS_HEALTH);
        this.level += 1;
    }
}
