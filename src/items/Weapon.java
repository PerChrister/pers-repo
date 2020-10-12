package items;
import heroes.Hero;

import java.util.Scanner;

/*

    Weapon class contains the show weapon method and level up method

*/

public class Weapon implements Items {

   private int level;
   private double baseDamage, damageBoost;
   Scanner scan = new Scanner(System.in);

   ArmorType armorType;
   SlotType slotType;
   WeaponType weaponType;

    // Constructor
    public Weapon() { }

    public void showWeaponStats(Hero hero, WeaponType weaponType) {
        switch(weaponType){
            case Melee:
                setBaseDamage(15); setLevel(1);
                break;
            case Ranged:
                setBaseDamage(5); setLevel(1);
                break;
            case Magic:
                setBaseDamage(20); setLevel(1);
                break;
        }
        System.out.println(
                weaponType+" Stats: \n"+
                        "Base damage: "+baseDamage
        );
        System.out.println("Level up weapon?");
        char choice = scan.next().charAt(0);
        if (choice == 'Y' || choice == 'y'){
            levelUp(hero, armorType, slotType, weaponType);
        } else {
            System.out.println("Well then! On to the next quest!");
        }
    }

    @Override
    public void levelUp(Hero hero, ArmorType armorType, SlotType slotType, WeaponType weaponType) {
        switch(weaponType){
            case Melee:
                setDamageBoost(baseDamage + 1.5);
                setLevel(level++);
                break;
            case Ranged:
                setDamageBoost(baseDamage + 2);
                setLevel(level++);
                break;
            case Magic:
                setDamageBoost(baseDamage + 3);
                setLevel(level++);
                break;
        }
        System.out.println(
                weaponType+" new stats: \n"+
                        "Base damage: "+baseDamage+" \n"+
                        "Damage boost: "+damageBoost
        );
        System.out.println("Time to choose some armor!");
        Armor armor = new Armor();
        armor.chooseArmor(hero, weaponType);
    }

    // Getters and Setters

    public int getLevel() { return level; }

    public void setLevel(int level) { this.level = level; }

    public double getBaseDamage() { return baseDamage; }

    public void setBaseDamage(double baseDamage) { this.baseDamage = baseDamage; }

    public double getDamageBoost() { return damageBoost; }

    public void setDamageBoost(double damageBoost) { this.damageBoost = damageBoost; }

    public Weapon(WeaponType weaponType) { this.weaponType = weaponType; }
}
