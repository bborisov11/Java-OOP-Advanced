package hell.entities.models.heroes;

import hell.interfaces.Inventory;

public class Wizard extends BaseHero{

    private static final long WIZARD_STRENGTH = 25;
    private static final long WIZARD_AGILITY = 25;
    private static final long WIZARD_INTELLIGENCE = 100;
    private static final long WIZARD_HIT_POINTS = 100;
    private static final long WIZARD_DAMAGE = 250;

    public Wizard(String name, Inventory inventory) {
        super(name, WIZARD_STRENGTH, WIZARD_AGILITY,
                WIZARD_INTELLIGENCE, WIZARD_HIT_POINTS, WIZARD_DAMAGE, inventory);
    }
}
