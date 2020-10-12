package com.company;

import heroes.Hero;
import heroes.HeroType;
import items.Weapon;
import items.WeaponType;

import java.util.Scanner;

/*

    RPG class contains the main menu and quest methods. It also contains the choose hero and choose weapon methods.

*/

public class RPG {
    Scanner scan = new Scanner(System.in);
    Hero hero;
    Weapon weapon = new Weapon();
    HeroType heroType;
    WeaponType weaponType;

    public void mainMenu(){

        System.out.println("---------------------");
        System.out.println("Who are you, adventurer? ");

        String name = scan.nextLine();
        System.out.println("---------------------");

        System.out.println("Welcome, " + name);
        chooseHero();
    }

    public void chooseHero() {

        System.out.println("Choose your class!");
        System.out.println("1. Warrior");
        System.out.println("2. Ranger");
        System.out.println("3. Mage");

        int choice = scan.nextInt();

        switch(choice){
            case 1:
                hero = new Hero(heroType.Warrior); // Saves the value of Warrior in order to be used by other methods
                hero.showHeroStats(hero, heroType.Warrior);
                break;
            case 2:
                hero = new Hero(heroType.Ranger); // Saves the value of Ranger in order to be used by other methods
                hero.showHeroStats(hero, heroType.Ranger);
                break;
            case 3:
                hero = new Hero(heroType.Mage); // Saves the value of Mage in order to be used by other methods
                hero.showHeroStats(hero, heroType.Mage);
                break;
        }
    }

    public void firstQuest(Hero hero){
        System.out.println("Greetings, summoner! Your adventure awaits you!\n" +
                "My name is Thorbjörn, the swordsmaster of Vikingstad.\n" +
                "I have a quest for you!\n" +
                "Do you accept it?(Y/N)");
        char choice = scan.next().charAt(0);
        System.out.println("---------------------");

        if (choice == 'Y' || choice == 'y'){
            firstEncounter(hero);
        } else {
            System.out.println("Thanks for participating, adventurer!");
        }
    }

    public void firstEncounter(Hero hero){
        System.out.println("Great adventurer! You now look strong enough to handle the threat \n" +
                "that has been harassing our village.\n" +
                "There is a werewolf attacking our farmers and stealing sheep from our barns. \n" +
                "it needs to be taken out. \n");
        System.out.println("I will give you a potion that will bring you to EVEN greater strength\n");

        hero.gainXP(100, hero); // First quest that lets the user gain 100XP to show that both XP gaining and level up functions work

        System.out.println("- You drink the potion and suddenly feel a surge of power rising. \n");

        System.out.println("Choose your first weapon!");
        chooseFirstWeapon(hero, weaponType);
    }
    public void chooseFirstWeapon(Hero hero, WeaponType weaponType){ // Lets user choose a basic weapon to show its base damage and level

        System.out.println("1. Knife");
        System.out.println("2. Bow");
        System.out.println("3. Wand");

        int choice = scan.nextInt();

        switch (choice){
            case 1:
                weapon.showWeaponStats(hero, weaponType.Melee);
                break;
            case 2:
                weapon.showWeaponStats(hero, weaponType.Ranged);
                break;
            case 3:
                weapon.showWeaponStats(hero, weaponType.Magic);
                break;
        }
    }


    public void nextQuest(Hero hero){
        // I was supposed to show the combined stats of hero and armor/item but I didn't manage.
    }
}

