package onehitdungeon.models.heroes;

import onehitdungeon.interfaces.ArmorItem;
import onehitdungeon.interfaces.Hero;
import onehitdungeon.interfaces.OffhandItem;
import onehitdungeon.interfaces.WeaponItem;

public abstract class Heroes implements Hero {

    private String name;
    private WeaponItem weaponItem;
    private OffhandItem offhandItem;
    private ArmorItem armorItem;
    private Double gold;
    protected Integer timesTrained;

    protected Heroes(String name, WeaponItem weaponItem, OffhandItem offhandItem, ArmorItem armorItem) {
        this.name = name;
        this.weaponItem = weaponItem;
        this.offhandItem = offhandItem;
        this.armorItem = armorItem;
        this.gold = 0.0;
        this.timesTrained = 1;
    }

    @Override
    public String getHeroClass() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Double getGold() {
        return this.gold;
    }

    @Override
    public void earnGold(Double gold) {
        this.gold += gold;
    }

    @Override
    public void payGold(Double gold) {
        this.gold -= gold;
    }

    @Override
    public WeaponItem getWeapon() {
        return this.weaponItem;
    }

    @Override
    public OffhandItem getOffhand() {
        return this.offhandItem;
    }

    @Override
    public ArmorItem getArmor() {
        return this.armorItem;
    }

    @Override
    public Double getTotalPriceForUpgrade() {
        this.timesTrained++;
        return this.weaponItem.getPriceForUpgrade() +
                this.armorItem.getPriceForUpgrade() +
                this.offhandItem.getPriceForUpgrade();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
                builder
                .append("####################").append(System.lineSeparator())
                .append(String.format("Gold: %.2f", this.gold)).append(System.lineSeparator())
                .append(String.format("Upgrade cost: %.2f",
                        this.weaponItem.getPriceForUpgrade() +
                                this.armorItem.getPriceForUpgrade() +
                                this.offhandItem.getPriceForUpgrade()));
        return builder.toString();
    }
}
