package panzer.core;

import panzer.contracts.BattleOperator;
import panzer.contracts.Vehicle;

import java.lang.reflect.Field;

public class PanzerBattleOperator implements BattleOperator {
    @Override
    public String battle(Vehicle attacker, Vehicle target) {
        double attackerWeight = attacker.getTotalWeight();
        long attackerAttack = attacker.getTotalAttack();
        long attackerDefense = attacker.getTotalDefense();
        long attackerHitPoints = attacker.getTotalHitPoints();

        double targetWeight = target.getTotalWeight();
        long targetAttack = target.getTotalAttack();
        long targetDefense = target.getTotalDefense();
        long targetHitPoints = target.getTotalHitPoints();

        boolean isAttackerTurn = true;
        boolean isSomeoneDead = isDead(attackerHitPoints) || isDead(targetHitPoints);

        while(!isSomeoneDead) {
            if(isAttackerTurn) {
                targetHitPoints -= (long)Math.max(0, Math.ceil(attackerAttack - (targetDefense + (targetWeight / 2))));
                try {
                    Field field = target.getClass().getSuperclass().getDeclaredField("hitPoints");
                    field.setAccessible(true);
                    field.set(target, targetHitPoints);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                isAttackerTurn = false;
            } else {
                attackerHitPoints -= (long)Math.max(0, Math.ceil(targetAttack - (attackerDefense + (attackerWeight / 2))));
                try {
                    Field field = attacker.getClass().getSuperclass().getDeclaredField("hitPoints");
                    field.setAccessible(true);
                    field.set(attacker, attackerHitPoints);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                isAttackerTurn = true;
            }

            isSomeoneDead = isDead(attackerHitPoints) || isDead(targetHitPoints);
        }

        String result = null;

        if(isDead(attackerHitPoints)) {
            result = target.getModel();
        } else {
            result = attacker.getModel();
        }

        return result;
    }

    private boolean isDead(Long hitPoints) {
        return hitPoints <= 0;
    }
}
