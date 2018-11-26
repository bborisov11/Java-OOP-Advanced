package hell.entities.models.heroes;

import hell.interfaces.Inventory;

public class Barbarian extends BaseHero {
    private static final long BARBARIAN_STRENGTH = 90;
    private static final long BARBARIAN_AGILITY = 25;
    private static final long BARBARIAN_INTELLIGENCE = 10;
    private static final long BARBARIAN_HIT_POINTS = 350;
    private static final long BARBARIAN_DAMAGE = 150;

    public Barbarian(String name, Inventory inventory) {
        super(name, BARBARIAN_STRENGTH, BARBARIAN_AGILITY,
                BARBARIAN_INTELLIGENCE, BARBARIAN_HIT_POINTS, BARBARIAN_DAMAGE, inventory);
    }
}
