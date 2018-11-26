package onehitdungeon.models.items;

import onehitdungeon.interfaces.ArmorItem;
import onehitdungeon.interfaces.Item;
import onehitdungeon.interfaces.OffhandItem;
import onehitdungeon.interfaces.WeaponItem;

public abstract class Items implements ArmorItem, WeaponItem, OffhandItem, Item {

    private Integer battlePower;
    private Double priceForUpgrade;

    protected Items(Integer battlePower, Double priceForUpgrade) {
        this.battlePower = battlePower;
        this.priceForUpgrade = priceForUpgrade;
    }

    @Override
    public Integer getBattlePower() {
        return this.battlePower;
    }

    @Override
    public Double getPriceForUpgrade() {
        return this.priceForUpgrade;
    }
}
