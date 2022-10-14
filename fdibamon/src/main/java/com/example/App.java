package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main( String[] args )
    {
        Fdibamon jan = new Fdibamon("Jan", 50, 60);
        Fdibamon rado = new Fdibamon("Rado", 20, 30);
        Fdibamon klaus = new Fdibamon("Klaus", 10, 3);
        Fdibamon mathias = new Fdibamon("Mathias", 30, 50);
        Fdibamon nikolay = new Fdibamon("Nikolay", 5, 15);
        
        List<Fdibamon> fdibamons = new ArrayList<Fdibamon>();
        fdibamons.add(jan);
        fdibamons.add(rado);
        fdibamons.add(klaus);
        fdibamons.add(mathias);
        fdibamons.add(nikolay);

        System.out.println("Folgende Fdibamons stehen zur Auswahl: Jan, Rado, Klaus, Mathias, Nikolay");

        Scanner scanner = new Scanner(System.in);
        Fdibamon fdibamon1 = getChosenFdibamon(fdibamons, scanner);
        Fdibamon fdibamon2 = getChosenFdibamon(fdibamons, scanner);
        scanner.close();


        System.out.println("Ihre gewählten Fdibamons: " + fdibamon1 + ", " + fdibamon2);
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
}
