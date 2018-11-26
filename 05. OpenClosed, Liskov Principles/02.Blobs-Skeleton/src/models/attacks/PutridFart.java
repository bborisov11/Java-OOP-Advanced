package models.attacks;

import models.Blob;

public class PutridFart extends AbstractAttack {
    private Blob target;

    public void execute(Blob source, Blob target) {
        this.target = target;
        this.respond(source.getDamage());
    }

    @Override
    public void attack(Blob source, Blob target) {
        this.attackAffectTarget(source, target);
    }

    private void attackAffectTarget(Blob source, Blob target) {
        this.respond(source.getDamage());
    }

    public void respond(int damage) {
        int currentHealth = this.target.getHealth();
        currentHealth -= damage;
        this.target.setHealth(currentHealth);
    }
}
