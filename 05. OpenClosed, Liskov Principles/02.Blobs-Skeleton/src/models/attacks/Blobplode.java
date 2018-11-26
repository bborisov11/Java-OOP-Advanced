package models.attacks;

import models.Blob;

public class Blobplode extends AbstractAttack {
    private Blob source;
    private Blob target;

    @Override
    public void execute(Blob source, Blob target) {
        this.target = target;
        this.attack(source, target);
    }

    @Override
    public void attack(Blob source, Blob target) {
        this.attackAffectSource(source);
        this.attackAffectTarget(source, target);
    }

    private void attackAffectTarget(Blob source, Blob target) {
        this.respond(source.getDamage() * 2);
    }

    private void attackAffectSource(Blob source) {
        source.setHealth(source.getHealth() - source.getHealth() / 2);
    }

    public void respond(int damage) {
        int currentHealth = this.target.getHealth();
        currentHealth -= damage;
        if(currentHealth > 1) {
            this.target.setHealth(currentHealth);
        }
    }


}
