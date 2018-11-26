package hell;

import hell.entities.io.ConsoleReader;
import hell.entities.io.ConsoleWriter;
import hell.entities.miscellaneous.HeroInventory;
import hell.entities.models.items.CommonItem;
import hell.entities.models.items.RecipeItem;
import hell.interfaces.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();
        Map<String, Hero> heroes = new LinkedHashMap<>();
        while (true) {
            String command = interpretCommands(reader, heroes);

            writer.writeLine(command);

            if ("Quit".equals(command)) {
                break;
            }
        }
    }

    private static String interpretCommands(InputReader reader, Map<String,Hero> heroes) {
        String[] args = reader.readLine().split("\\s+");
        String commandName = args[0];
        switch (commandName) {
            case "Hero":
                try {
                    Class<?> heroClass = Class.forName("hell.entities.models.heroes." + args[2]);
                    Constructor heroConstructor = heroClass
                            .getDeclaredConstructor(String.class, Inventory.class);
                    heroConstructor.setAccessible(true);
                    Hero hero = (Hero) heroConstructor.newInstance
                            (args[1], new HeroInventory());
                    heroes.putIfAbsent(hero.getName(), hero);
                    return String.format("Created %s - %s",
                            hero.getClass().getSimpleName(), hero.getName());
                } catch (ClassNotFoundException
                        | NoSuchMethodException
                        | IllegalAccessException
                        | InvocationTargetException
                        | InstantiationException e) {
                    return null;
                }
            case "Item":
                String itemName = args[1];
                String heroName = args[2];
                int strengthBonus = Integer.parseInt(args[3]);
                int agilityBonus = Integer.parseInt(args[4]);
                int intelligenceBonus = Integer.parseInt(args[5]);
                int hitPointsBonus = Integer.parseInt(args[6]);
                int damageBonus = Integer.parseInt(args[7]);

                Item item = new CommonItem(itemName, strengthBonus, agilityBonus
                        , intelligenceBonus, hitPointsBonus, damageBonus);

                heroes.get(heroName).addItem(item);

                return String.format(
                        "Added item - %s to Hero - %s",
                        itemName, heroName);
            case "Recipe":
                itemName = args[1];
                heroName = args[2];
                strengthBonus = Integer.parseInt(args[3]);
                agilityBonus = Integer.parseInt(args[4]);
                intelligenceBonus = Integer.parseInt(args[5]);
                hitPointsBonus = Integer.parseInt(args[6]);
                damageBonus = Integer.parseInt(args[7]);
                String[] array = Arrays.stream(args).skip(8).toArray(String[]::new);

                Recipe recipe = new RecipeItem(itemName, strengthBonus, agilityBonus
                        , intelligenceBonus, hitPointsBonus, damageBonus, array);

                heroes.get(heroName).addRecipe(recipe);
                return String.format(
                        "Added recipe - %s to Hero - %s"
                        , itemName, heroName);
            case "Inspect":
                return heroes.get(args[1]).toString();
            case "Quit":
                StringBuilder builder = new StringBuilder();
                final int[] count = {1};

                heroes.values()
                        .stream()
                        .sorted(Comparator
                                .comparing((Hero x) -> x.getStrength() +
                                                x.getAgility() + x.getIntelligence(),
                                        Comparator.reverseOrder())
                                .thenComparing(y -> y.getHitPoints() + y.getDamage()
                                        , Comparator.reverseOrder()))
                        .forEach(x -> builder.append(count[0]++)
                                .append(". ").append(x.getClass().getSimpleName())
                                .append(": ").append(x.getName())
                                .append(System.lineSeparator())
                                .append(String.format("###HitPoints: %d", x.getHitPoints())).append(System.lineSeparator())
                                .append(String.format("###Damage: %d", x.getDamage())).append(System.lineSeparator())
                                .append(String.format("###Strength: %d", x.getStrength())).append(System.lineSeparator())
                                .append(String.format("###Agility: %d", x.getAgility())).append(System.lineSeparator())
                                .append(String.format("###Intelligence: %d", x.getIntelligence())).append(System.lineSeparator())
                                .append(x.getItems().size() == 0 ? "###Items: None" : "###Items: " +
                                        String.join(", ", x.getItems().stream().map(Item::getName)
                                                .collect(Collectors.toList())))
                        .append(System.lineSeparator()));
            return builder.toString();
            default:
                return "Wrong input";
        }
    }
}
