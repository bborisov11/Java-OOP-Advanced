package onehitdungeon.models.heroes;

import onehitdungeon.models.items.ArmorItem;
import onehitdungeon.models.items.OffhandItem;
import onehitdungeon.models.items.WeaponItem;

public class MageHero extends Heroes {
    public MageHero(String name) {
        super(name,new WeaponItem(45,15.0),
                new OffhandItem(25, 20.0),
                new ArmorItem(10, 25.0));
    }
    @Override
    public Integer getTotalBattlePower() {
        return ((this.getWeapon().getBattlePower() + this.getArmor().getBattlePower() - this.getOffhand().getBattlePower()) * 3) / 4;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        return builder.append(String.format("%s - Lvl. %d Mage", this.getName(), this.timesTrained))
                .append(System.lineSeparator())
                .append(String.format("* Staff - %d (BP)",this.getWeapon().getBattlePower()))
                .append(System.lineSeparator())
                .append(String.format("* Orb - %d (BP)",this.getOffhand().getBattlePower()))
                .append(System.lineSeparator())
                .append(String.format("* Cape - %d (BP)",this.getArmor().getBattlePower()))
                .append(System.lineSeparator()).append(super.toString()).toString();
    }
}
