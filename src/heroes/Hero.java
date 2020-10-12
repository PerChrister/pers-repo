package heroes;
import com.company.RPG;
import items.*;

import java.util.Scanner;

/*

    Hero class contains the show hero stats, level up method, and gain XP methods.

*/

public class Hero implements Heroes{

    private double health, strength, dexterity, intelligence;

    HeroType heroType;
    Armor armor;
    ArmorType armorType;

    int level = 1;
    int xpToNext = 100;
    int xpLevel = 0;
    int finalXp;

    Scanner scan = new Scanner(System.in);

    // Constructors

    public Hero(HeroType heroType) { this.heroType = heroType; }

    public Hero(Armor armor) { this.armor = armor; }

    public Hero(ArmorType armorType) { this.armorType = armorType; }

    public void equipItem() { }

    @Override
    public void attack() {

    }

    @Override
    public void showHeroStats(Hero hero, HeroType heroType) {
        switch(heroType){
            case Warrior:
                setHealth(150); setStrength(10); setDexterity(3); setIntelligence(1); setLevel(1); setXpLevel(0);
                break;
            case Ranger:
                setHealth(120); setStrength(5); setDexterity(10);setIntelligence(2); setLevel(1); setXpLevel(0);
                break;
            case Mage:
                setHealth(100); setStrength(2); setDexterity(3); setIntelligence(10); setLevel(1); setXpLevel(0);
                break;
        }
        System.out.println(
                heroType+" Stats: \n"+
                        "Health: "+health+" \n"+
                        "Strength: "+strength+" \n"+
                        "Dexterity: "+dexterity+" \n"+
                        "Intelligence: "+intelligence+" \n"+
                        "Level: "+level
        );
        RPG rpg = new RPG();
        rpg.firstQuest(hero);
    }

    @Override
    public void levelUp(Hero hero, HeroType heroType) {
        switch(heroType){
            case Warrior:
                setHealth(health += 30); setStrength(strength += 5); setDexterity(dexterity += 2); setIntelligence(intelligence += 1);
                break;
            case Ranger:
                setHealth(health += 20); setStrength(strength += 2); setDexterity(dexterity += 5); setIntelligence(intelligence += 1);
                break;
            case Mage:
                setHealth(health += 15); setStrength(strength += 1); setDexterity(dexterity += 2); setIntelligence(intelligence += 5);
                break;
        }
        System.out.println(
                heroType+" New Stats: \n"+
                        "Health: "+health+" \n"+
                        "Strength: "+strength+" \n"+
                        "Dexterity: "+dexterity+" \n"+
                        "Intelligence: "+intelligence+" \n"+
                        "Level: "+level+" \n"+
                        "XP Level: "+xpLevel+" \n"+
                        "--------------------"
        );
    }

    @Override
    public void gainXP(int xpGain, Hero hero) {
        finalXp = xpLevel + xpGain;
        do {
            if(finalXp >= xpToNext){
                System.out.println("LEVEL UP!");
                finalXp = finalXp - xpToNext;
                xpLevel = finalXp;
                xpToNext = (int) (xpToNext + Math.ceil((xpToNext *.1)));
                level = level + 1;
                System.out.println("YOUR LEVEL NOW IS :" + level);
                System.out.println("Xp now is "+ finalXp + " / " + xpToNext);
                showCurrentStats(hero);
                levelUp(hero, heroType);
            } else{
                System.out.println("XP GAINED IS " + xpGain + "XP");
                System.out.println("Xp now is "+ finalXp + " / " + xpToNext);
                System.out.println("END");
            }
        }
        while (xpToNext <= finalXp);
    }

    public void showCurrentStats(Hero hero){
        switch(heroType){
            case Warrior:
                setHealth(150); setStrength(10); setDexterity(3); setIntelligence(1); setLevel(1); setXpLevel(0);
                break;
            case Ranger:
                setHealth(120); setStrength(5); setDexterity(10);setIntelligence(2); setLevel(1); setXpLevel(0);
                break;
            case Mage:
                setHealth(100); setStrength(2); setDexterity(3); setIntelligence(10); setLevel(1); setXpLevel(0);
                break;
        }
    }

    // Getters and Setters

    public double getHealth() { return health; }

    public void setHealth(double health) { this.health = health; }

    public double getStrength() { return strength; }

    public void setStrength(double strength) { this.strength = strength;}

    public double getDexterity() { return dexterity; }

    public void setDexterity(double dexterity) { this.dexterity = dexterity; }

    public double getIntelligence() { return intelligence; }

    public void setIntelligence(double intelligence) { this.intelligence = intelligence; }

    public int getXpLevel() { return xpLevel; }

    public void setXpLevel(int xpLevel) { this.xpLevel = xpLevel; }

    public int getLevel() { return level; }

    public void setLevel(int level) { this.level = level; }
}
