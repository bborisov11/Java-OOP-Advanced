package onehitdungeon.manager;

import onehitdungeon.interfaces.DungeonManager;
import onehitdungeon.interfaces.Hero;
import onehitdungeon.interfaces.HeroTrainer;
import onehitdungeon.models.heroes.MageHero;
import onehitdungeon.models.heroes.PaladinHero;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DungeonManagerImpl implements DungeonManager {
    private Map<String, Hero> heroes;
    private HeroTrainer heroTrainer;
    private Hero currentlySelectedHero;
    private Double currentFoeBattlePower;
    private Double goldEarnedFromDefeating;
    private int dungeonLevel;

    public DungeonManagerImpl(HeroTrainer heroTrainer) {
        this.heroes = new LinkedHashMap<>();
        this.heroTrainer = heroTrainer;
        this.currentFoeBattlePower = 20.0;
        this.goldEarnedFromDefeating = 15.0;
        this.dungeonLevel = 1;
    }

    @Override
    public String hero(List<String> arguments) {
        String heroType = arguments.get(0);
        String name = arguments.get(1);
        Hero currentHero = null;
        if(heroType.equals("Paladin")) {
            currentHero = new PaladinHero(name);
            this.heroes.putIfAbsent(name, currentHero);
        }
        else {
            currentHero = new MageHero(name);
            this.heroes.putIfAbsent(name, currentHero);
        }
        if(this.heroes.size() == 1) {
            this.currentlySelectedHero = currentHero;
        }
        int index = currentHero.getClass().getSimpleName().indexOf("Hero");
        return String.format("Successfully added %s - %s.",currentHero.getClass().getSimpleName()
                .substring(0,index), name);
    }

    @Override
    public String select(List<String> arguments) {
        this.currentlySelectedHero = this.heroes.get(arguments.get(0));
        int index = this.currentlySelectedHero.getClass().getSimpleName().indexOf("Hero");
        return String.format("Successfully selected %s - %s.",
                this.currentlySelectedHero.getClass().getSimpleName().substring(0,index),
                this.currentlySelectedHero.getName());
    }

    @Override
    public String status(List<String> arguments) {
        return this.currentlySelectedHero.toString();
    }

    @Override
    public String fight(List<String> arguments) {
        String message = "";
        Integer asd = this.currentlySelectedHero.getTotalBattlePower();
        if(this.currentlySelectedHero.getTotalBattlePower() > this.currentFoeBattlePower) {
            this.currentlySelectedHero.earnGold(this.goldEarnedFromDefeating);
            message = String.format("Fight won. You’ve gained %.2f gold."
                    ,this.goldEarnedFromDefeating);
        } else {
            this.goldEarnedFromDefeating /= 2;
            this.currentFoeBattlePower /= 2;
            this.dungeonLevel--;
            message = "Fight lost. You've returned to the previous level.";
        }
        return message;
    }

    @Override
    public String advance(List<String> arguments) {
        this.goldEarnedFromDefeating *= 2;
        this.currentFoeBattlePower *= 2;
        this.dungeonLevel++;
        return String.format("Successfully advanced to dungeon level %d."
                ,this.dungeonLevel);
    }

    @Override
    public String train(List<String> arguments) {
        Double currentTotalPriceForUpgrade = this.currentlySelectedHero.getTotalPriceForUpgrade();
        if(this.currentlySelectedHero.getGold() >= currentTotalPriceForUpgrade) {
            this.heroTrainer.trainHero(this.currentlySelectedHero);
            this.currentlySelectedHero.payGold(currentTotalPriceForUpgrade);
            return String.format("Successfully trained hero. Current total battle power: %d."
            ,this.currentlySelectedHero.getTotalBattlePower());
        } else {
            return String.format("Insufficient gold for training. Needed %.2f. Got %.2f.",
                    currentTotalPriceForUpgrade - this.currentlySelectedHero.getGold(),
                    this.currentlySelectedHero.getGold());
        }
    }

    @Override
    public String quit(List<String> arguments) {
        StringBuilder builder = new StringBuilder();

        for (Hero hero : this.heroes.values()) {
            int index = hero.getClass().getSimpleName().indexOf("Hero");
            builder.append(String.format("%s %s - %d (BP)",
                    hero.getClass().getSimpleName().substring(0, index), hero.getName(), hero.getTotalBattlePower()))
            .append(System.lineSeparator());
        }
        builder.append("####################")
                .append(System.lineSeparator())
                .append(String.format("Dungeon level reached: %d",
                this.dungeonLevel));

        return builder.toString();
    }
}
