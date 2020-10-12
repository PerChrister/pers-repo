package items;

import heroes.Hero;
import heroes.HeroType;

public interface Items {
    public void levelUp(Hero hero, ArmorType armorType, SlotType slotType, WeaponType weaponType);
}
