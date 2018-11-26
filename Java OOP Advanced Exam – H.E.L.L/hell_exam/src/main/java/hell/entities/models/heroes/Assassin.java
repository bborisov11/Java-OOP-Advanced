package hell.entities.models.heroes;

import hell.interfaces.Inventory;

public class Assassin extends BaseHero {

    private static final long ASSASSIN_STRENGTH = 25;
    private static final long ASSASSIN_AGILITY = 100;
    private static final long ASSASSIN_INTELLIGENCE = 15;
    private static final long ASSASSIN_HIT_POINTS = 150;
    private static final long ASSASSIN_DAMAGE = 300;

    public Assassin(String name, Inventory inventory) {
        super(name, ASSASSIN_STRENGTH, ASSASSIN_AGILITY,
                ASSASSIN_INTELLIGENCE, ASSASSIN_HIT_POINTS,
                ASSASSIN_DAMAGE, inventory);
    }
}
