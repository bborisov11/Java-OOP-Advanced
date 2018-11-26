package core.commands;

import interfaces.BlobFactory;
import interfaces.Repository;
import models.Blob;

public class AttackCommand extends BaseCommand {

    public static final String ATTACK_PATH = "models.attacks.";

    protected AttackCommand(String[] data, BlobFactory factory, Repository repository) {
        super(data, factory, repository);
    }

    @Override
    public void execute() {
       Blob attacker = this.getRepository().getBlob(getData()[1]);
       Blob target = this.getRepository().getBlob(getData()[2]);
        if(attacker.getHealth() > 0 && target.getHealth() > 0) {
            attacker.getAttack().execute(attacker, target);
        }
    }
}
