package onehitdungeon.models.heroes;

import onehitdungeon.models.items.ArmorItem;
import onehitdungeon.models.items.OffhandItem;
import onehitdungeon.models.items.WeaponItem;

public class PaladinHero extends Heroes {
    public PaladinHero(String name) {
        super(name, new WeaponItem(20,10.0),
                new OffhandItem(10, 10.0),
                new ArmorItem(25, 20.0));
    }
    @Override
    public Integer getTotalBattlePower() {
        Integer asd =
                ((this.getWeapon().getBattlePower() + this.getOffhand().getBattlePower()
                        + this.getArmor().getBattlePower()) * 4) / 9;
        return asd;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
            return builder.append(String.format("%s - Lvl. %d Paladin",this.getName(),this.timesTrained))
                    .append(System.lineSeparator())
                    .append(String.format("* Mace - %d (BP)",this.getWeapon().getBattlePower()))
                    .append(System.lineSeparator())
                    .append(String.format("* Shield - %d (BP)",this.getOffhand().getBattlePower()))
                    .append(System.lineSeparator())
                    .append(String.format("* Cuirass - %d (BP)",this.getArmor().getBattlePower()))
                    .append(System.lineSeparator())
                    .append(super.toString()).toString();
    }
}
