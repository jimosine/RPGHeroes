package org.example;

public class Main {
    public static void main(String[] args) {
        Mage heroJim = new Mage("Jim");
        heroJim.displayStats();
        heroJim.levelUp();
        System.out.println("\n");
        heroJim.displayStats();
    }

}