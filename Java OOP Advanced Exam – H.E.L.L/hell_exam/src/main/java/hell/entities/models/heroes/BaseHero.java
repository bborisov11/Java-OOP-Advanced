package hell.entities.models.heroes;

import hell.entities.miscellaneous.ItemCollection;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class BaseHero implements Hero {
    private String name;
    private long strength;
    private long agility;
    private long intelligence;
    private long hitPoints;
    private long damage;
    private Inventory inventory;

    protected BaseHero(String name, long strength, long agility, long intelligence, long hitPoints, long damage, Inventory inventory) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = inventory;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength + this.inventory.getTotalStrengthBonus();
    }

    @Override
    public long getAgility() {
        return this.agility + this.inventory.getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence() {
        return this.intelligence +
                this.inventory.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints + this.inventory.getTotalHitPointsBonus();
    }

    @Override
    public long getDamage() {
        return this.damage + this.inventory.getTotalDamageBonus();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Item> getItems() {
        try {
            Field[] fields = this.inventory.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(ItemCollection.class)) {
                    field.setAccessible(true);
                    Map<String, Item> currentMap = (Map<String, Item>) field.get(this.inventory);
                    return currentMap.values();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

        @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }

    @Override
    public String toString() {
        StringBuilder heroBuilder = new StringBuilder();
        heroBuilder.append(String.format("Hero: %s, Class: %s"
                , this.name, this.getClass().getSimpleName())).append(System.lineSeparator())
        .append(String.format("HitPoints: %d, Damage: %d",this.getHitPoints(), this.getDamage()))
        .append(System.lineSeparator())
        .append(String.format("Strength: %d",this.getStrength())).append(System.lineSeparator())
        .append(String.format("Agility: %d",this.getAgility())).append(System.lineSeparator())
        .append(String.format("Intelligence: %d",this.getIntelligence())).append(System.lineSeparator())
        .append(this.getItems().size() == 0 ? "Items: None" :
                String.join("\n", this.getItems().stream().map(Object::toString)
                        .collect(Collectors.toList())));

        return heroBuilder.toString();
    }
}
