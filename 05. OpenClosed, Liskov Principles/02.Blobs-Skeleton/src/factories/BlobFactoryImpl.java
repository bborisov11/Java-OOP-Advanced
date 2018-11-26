package factories;

import interfaces.BlobFactory;
import models.Blob;
import models.attacks.AbstractAttack;
import models.behavors.AbstractBehavior;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BlobFactoryImpl implements BlobFactory {

    private static final String BEHAVIOR_PATH = "models.behavors.";
    private static final String ATTACK_PATH = "models.attacks.";

    @Override
    public Blob createBlob(String[] data) {
        Class blob = Blob.class;
        String blobName = data[1];
        int blobHealth = Integer.parseInt(data[2]);
        int blobDamage = Integer.parseInt(data[3]);
        try {
            Class behavior = Class.forName(BEHAVIOR_PATH + data[4]);
            AbstractBehavior currentBehavior =
                    (AbstractBehavior) behavior.newInstance();
            Class attack = Class.forName(ATTACK_PATH + data[5]);
            AbstractAttack currentAttack = (AbstractAttack) attack.newInstance();
            Constructor constr = blob.getDeclaredConstructor(String.class,
                    int.class,int.class, AbstractBehavior.class, AbstractAttack.class);
            return (Blob) constr.newInstance(blobName,
                    blobHealth, blobDamage, currentBehavior, currentAttack);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
