package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main( String[] args )
    {
        List<Fdibamon> fdibamons = initializeFdibamons();

        System.out.println("Folgende Fdibamons stehen zur Auswahl: Jan, Rado, Klaus, Mathias, Nikolay");

        printEmptyLine();

        Scanner scanner = new Scanner(System.in);
        Fdibamon fdibamon1 = getChosenFdibamon(fdibamons, scanner);
        Fdibamon fdibamon2 = getChosenFdibamon(fdibamons, scanner);
        scanner.close();

        System.out.println("Ihre gewählten Fdibamons: " + fdibamon1 + ", " + fdibamon2);

        printEmptyLine();

        System.out.println("Der Kampf beginnt!");

        Fdibamon winner = fight(fdibamon1, fdibamon2);

        printEmptyLine();

        if (winner != null) {
            System.out.println("Der Gewinner ist " + winner + "!");
        } else {
            System.out.println("Der Kampf ist unentschieden!");
        }
    }

    public static Fdibamon fight(Fdibamon fdibamon1, Fdibamon fdibamon2) {
        boolean areBothFdibamonsStillAlive = true;
        int round = 1;

        do {
            printEmptyLine();
            System.out.println("Runde " + round);

            fdibamon1.attack(fdibamon2);
            fdibamon2.attack(fdibamon1);

            System.out.println("Hitpoints of Fdibamon " + fdibamon1 + ": " + fdibamon1.hitpoints);
            System.out.println("Hitpoints of Fdibamon " + fdibamon2 + ": " + fdibamon2.hitpoints);

            areBothFdibamonsStillAlive = fdibamon1.hitpoints > 0 && fdibamon2.hitpoints > 0;
            round++;
        } while (areBothFdibamonsStillAlive);

        Fdibamon winner = getWinner(fdibamon1, fdibamon2);

        return winner;
    }

    private static Fdibamon getWinner(Fdibamon fdibamon1, Fdibamon fdibamon2) {
        if (fdibamon1.hitpoints > fdibamon2.hitpoints) {
            return fdibamon1;
        } else if (fdibamon2.hitpoints > fdibamon1.hitpoints) {
            return fdibamon2;
        } else {
            return null;
        }
    }

    public static Fdibamon getFdibamonFromList(List<Fdibamon> fdibamons, String name) {
        Fdibamon fdibamon = null;
        for (Fdibamon f : fdibamons) {
            if (name.equals(f.name)) {
                fdibamon = f;
            }
        }

        return fdibamon;
    }

    public static Fdibamon getChosenFdibamon(List<Fdibamon> fdibamons, Scanner scanner) {
        String name = "";
        Fdibamon fdibamon = null;
        while (fdibamon == null) {
            System.out.println("Wählen Sie ein Fdibamon aus:");
            name = scanner.nextLine();

            fdibamon = getFdibamonFromList(fdibamons, name);

            if (fdibamon == null) {
                System.out.println("Das eingegebene Fdibamon existiert nicht. Bitte versuchen Sie es noch einmal!");
            }
        }
        return fdibamon;
    }

    public static List<Fdibamon> initializeFdibamons() {
        List<Fdibamon> fdibamons = new ArrayList<Fdibamon>();

        Fdibamon jan = new Fdibamon("Jan", 300, 20);
        Fdibamon rado = new Fdibamon("Rado", 200, 30);
        Fdibamon klaus = new Fdibamon("Klaus", 50, 3);
        Fdibamon mathias = new Fdibamon("Mathias", 400, 50);
        Fdibamon nikolay = new Fdibamon("Nikolay", 40, 15);
        
        fdibamons.add(jan);
        fdibamons.add(rado);
        fdibamons.add(klaus);
        fdibamons.add(mathias);
        fdibamons.add(nikolay);

        return fdibamons;
    }

    private static void printEmptyLine() {
        System.out.println("\n");
    }
}
