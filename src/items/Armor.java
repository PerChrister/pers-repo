package items;
import heroes.Hero;
import com.company.RPG;

import java.util.Scanner;

/*

    Armor class contains the choose and show armor methods, and level up method

*/

public class Armor implements Items{

    private int level;
    private double health, strength, dexterity, intelligence;
    private double bodyScale = .8;
    private double legsScale = .6;

    Scanner scan = new Scanner(System.in);

    ArmorType armorType;
    SlotType slotType;
    WeaponType weaponType;
    RPG rpg = new RPG();

    // Constructors
    public Armor(ArmorType armorType) {
        this.armorType = armorType;
    }

    public Armor() { }

    public ArmorType getArmorType() { return armorType; }

    public void chooseArmor(Hero hero, WeaponType container){
        System.out.println("1. Cloth");
        System.out.println("2. Leather");
        System.out.println("3. Plate");

        int choice = scan.nextInt();

        if (choice == 1) {
            chooseGearSlot();
            int nextChoice = scan.nextInt();
            switch (nextChoice) {
                case 1:
                    slotType = slotType.Head;
                    showArmorStats(hero, armorType.Cloth, slotType);
                    break;
                case 2:
                    slotType = slotType.Body;
                    showArmorStats(hero, armorType.Cloth, slotType);
                    break;
                case 3:
                    slotType = slotType.Legs;
                    showArmorStats(hero, armorType.Cloth, slotType);
                    break;
            }
        } else if (choice == 2){
            chooseGearSlot();
            int nextChoice = scan.nextInt();
            switch (nextChoice) {
                case 1:
                    slotType = slotType.Head;
                    showArmorStats(hero, armorType.Leather, slotType);
                    break;
                case 2:
                    slotType = slotType.Body;
                    showArmorStats(hero, armorType.Leather, slotType);
                    break;
                case 3:
                    slotType = slotType.Legs;
                    showArmorStats(hero, armorType.Leather, slotType);
                    break;
            }
        } else if (choice == 3){
            chooseGearSlot();
            int nextChoice = scan.nextInt();
                switch (nextChoice) {
                    case 1:
                        slotType = slotType.Head;
                        showArmorStats(hero, armorType.Plate, slotType);
                        break;
                    case 2:
                        slotType = slotType.Body;
                        showArmorStats(hero, armorType.Plate, slotType);
                        break;
                    case 3:
                        slotType = slotType.Legs;
                        showArmorStats(hero, armorType.Plate, slotType);
                        break;
                }
            } else {
                System.out.println("Error");
            }

    }

    public void showArmorStats(Hero hero, ArmorType armorType, SlotType slotType) {
        switch (slotType){
            case Head:
                setHealth(10); setIntelligence(3); setDexterity(1); setLevel(1);
                break;
            case Body:
                setHealth(health += 20*bodyScale); setDexterity(dexterity += 3*bodyScale); setStrength(strength += 1*bodyScale); setLevel(1);
                break;
            case Legs:
                setHealth(health += 30*legsScale); setStrength(strength += 3*legsScale); setDexterity(dexterity += 1*legsScale); setLevel(1);
                break;
        }
        System.out.println(
                armorType+" Stats: \n"+
                        "Health: "+health+" \n"+
                        "Strength: "+strength+" \n"+
                        "Dexterity: "+dexterity+" \n"+
                        "Intelligence: "+intelligence+" \n"+
                        "Level: "+level
        );
        System.out.println("Level up armor?");
        char choice = scan.next().charAt(0);
        if (choice == 'Y' || choice == 'y'){
            levelUp(hero, armorType, slotType, weaponType);
        } else {
            System.out.println("Well then! On to the next quest!");
        }
    }

    @Override
    public void levelUp(Hero hero, ArmorType armorType, SlotType slotType, WeaponType weaponType) {
        switch (armorType){
            case Cloth:
                setHealth(health += 5); setIntelligence(intelligence += 2); setDexterity(dexterity += 1); setLevel(level++);
                break;
            case Leather:
                setHealth(health += 8*bodyScale); setDexterity(dexterity += 2*bodyScale); setStrength(strength += 1*bodyScale); setLevel(level++);
                break;
            case Plate:
               setHealth(health += 12*legsScale); setStrength(strength += 2*legsScale); setDexterity(dexterity += 1*legsScale); setLevel(level++);
                break;
        }
        System.out.println(
                armorType+" New Stats: \n"+
                        "Health: "+health+" \n"+
                        "Strength: "+strength+" \n"+
                        "Dexterity: "+dexterity+" \n"+
                        "Intelligence: "+intelligence+" \n"+
                        "Level: "+level
        );
            System.out.println("Well then! On to the next quest!");
            rpg.nextQuest(hero);
    }

    public void chooseGearSlot(){
        System.out.println("Choose where to equip gear: ");
        System.out.println("1. Head");
        System.out.println("2. Body");
        System.out.println("3. Legs");
    }

    // Getters and Setters

    public int getLevel() { return level; }

    public void setLevel(int level) { this.level = level; }

    public double getHealth() { return health; }

    public void setHealth(double health) { this.health = health; }

    public double getStrength() { return strength; }

    public void setStrength(double strength) { this.strength = strength; }

    public double getDexterity() { return dexterity; }

    public void setDexterity(double dexterity) { this.dexterity = dexterity; }

    public double getIntelligence() { return intelligence; }

    public void setIntelligence(double intelligence) { this.intelligence = intelligence; }

    public double getBodyScale() { return bodyScale; }

    public void setBodyScale(double bodyScale) { this.bodyScale = bodyScale; }

    public double getLegsScale() { return legsScale; }

    public void setLegsScale(double legsScale) { this.legsScale = legsScale; }
}
