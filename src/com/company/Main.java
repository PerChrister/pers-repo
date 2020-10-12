package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("---------------------");
        System.out.println("RPG Character Simulator Application");
        System.out.println("Welcome to the Tavern of lost souls. " +
                "You look like a strong adventurer that would be able to help us in this town.");
        System.out.println("Would you like to help us, adventurer?(Y/N)");

        char choice = scan.next().charAt(0);
        System.out.println("---------------------");

        if (choice == 'Y' || choice == 'y'){
            System.out.println("Great!");
            RPG rpg = new RPG();
            rpg.mainMenu();
        } else {
            System.out.println("Thanks for participating, adventurer!");
        }
    }
}
