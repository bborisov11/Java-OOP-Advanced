package hell.entities.miscellaneous;

import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HeroInventoryTest {
   private Inventory inventory;
   private int maxInt = 10;

    @Before
    public void setUp() throws Exception {
        this.inventory = new HeroInventory();
    }

    public void createThreeItems() {
        Item commonItem = Mockito.mock(Item.class);
        Mockito.when(commonItem.getName()).thenReturn("Gosho");
        Mockito.when(commonItem.getStrengthBonus()).thenReturn(maxInt);
        Mockito.when(commonItem.getAgilityBonus()).thenReturn(maxInt);
        Mockito.when(commonItem.getIntelligenceBonus()).thenReturn(maxInt);
        Mockito.when(commonItem.getHitPointsBonus()).thenReturn(maxInt);
        Mockito.when(commonItem.getDamageBonus()).thenReturn(maxInt);

        Item commonItem1 = Mockito.mock(Item.class);
        Mockito.when(commonItem1.getName()).thenReturn("Stamat");
        Mockito.when(commonItem1.getStrengthBonus()).thenReturn(maxInt);
        Mockito.when(commonItem1.getAgilityBonus()).thenReturn(maxInt);
        Mockito.when(commonItem1.getIntelligenceBonus()).thenReturn(maxInt);
        Mockito.when(commonItem1.getHitPointsBonus()).thenReturn(maxInt);
        Mockito.when(commonItem1.getDamageBonus()).thenReturn(maxInt);

        Item commonItem2 = Mockito.mock(Item.class);
        Mockito.when(commonItem2.getName()).thenReturn("Prakash");
        Mockito.when(commonItem2.getStrengthBonus()).thenReturn(maxInt);
        Mockito.when(commonItem2.getAgilityBonus()).thenReturn(maxInt);
        Mockito.when(commonItem2.getIntelligenceBonus()).thenReturn(maxInt);
        Mockito.when(commonItem2.getHitPointsBonus()).thenReturn(maxInt);
        Mockito.when(commonItem2.getDamageBonus()).thenReturn(maxInt);

        this.inventory.addCommonItem(commonItem);
        this.inventory.addCommonItem(commonItem1);
        this.inventory.addCommonItem(commonItem2);
    }

    @Test
    public void getTotalStrengthBonus() throws Exception {
        createThreeItems();
        Assert.assertEquals(3L * maxInt, this.inventory.getTotalStrengthBonus());
    }

    @Test
    public void getTotalAgilityBonus() throws Exception {
        createThreeItems();
        Assert.assertEquals(3L * maxInt, this.inventory.getTotalAgilityBonus());
    }

    @Test
    public void getTotalIntelligenceBonus() throws Exception {
        createThreeItems();
        Assert.assertEquals(3L * maxInt, this.inventory.getTotalIntelligenceBonus());
    }

    @Test
    public void getTotalHitPointsBonus() throws Exception {
        createThreeItems();
        Assert.assertEquals(3L * maxInt, this.inventory.getTotalHitPointsBonus());
    }

    @Test
    public void getTotalDamageBonus() throws Exception {
        createThreeItems();
        Assert.assertEquals(3L * maxInt, this.inventory.getTotalDamageBonus());
    }

    @Test
    public void addCommonItem() {
        createThreeItems();
        Recipe recipe = Mockito.mock(Recipe.class);
        List<String> list = new ArrayList<>();
        list.add("Gosho");
        list.add("Stamat");
        list.add("Pesho");
        Mockito.when(recipe.getRequiredItems()).thenReturn(list);
        this.inventory.addRecipeItem(recipe);
        Item item = Mockito.mock(Item.class);
        Mockito.when(item.getName()).thenReturn("Pesho");
        this.inventory.addCommonItem(item);
        int size = 0;
        for (Field field : this.inventory.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(ItemCollection.class)) {
                field.setAccessible(true);
                Map<String, Item> map = null;
                try {
                    map = (Map<String, Item>) field.get(this.inventory);
                    size = map.size();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        Assert.assertEquals(2, size);
    }

    @Test
    public void addRecipeItem() {
        Recipe recipe = Mockito.mock(Recipe.class);
        this.inventory.addRecipeItem(recipe);
        int actualSize = 0;
        Field field = null;
        try {
            field = this.inventory.getClass().getDeclaredField("recipeItems");

            field.setAccessible(true);

            Map<String, Recipe> recipes = (Map<String, Recipe>) field.get(this.inventory);
            actualSize = recipes.size();

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(1, actualSize);

    }
}



