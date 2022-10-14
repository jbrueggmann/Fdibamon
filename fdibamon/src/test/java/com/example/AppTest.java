package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AppTest 
{
    public static List<Fdibamon> initializeFdibamonsForTesting() {
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

    @Test
    public void fdibamonsShouldBeEqual() {
        List<Fdibamon> fdibamons = initializeFdibamonsForTesting();

        Fdibamon rado = fdibamons.get(1);
        
        Fdibamon fdibamon = App.getFdibamonFromList(fdibamons, "Rado");
        assertEquals(fdibamon, rado);
    }

    @Test
    public void fdibamonsShouldNotBeEqual() {
        List<Fdibamon> fdibamons = initializeFdibamonsForTesting();

        Fdibamon klaus = fdibamons.get(2);
        
        Fdibamon fdibamon = App.getFdibamonFromList(fdibamons, "Rado");
        assertNotEquals(fdibamon, klaus);
    }

    @Test
    public void fdibamonShouldBeNull() {
        List<Fdibamon> fdibamons = initializeFdibamonsForTesting();
        
        Fdibamon fdibamon = App.getFdibamonFromList(fdibamons, "NotAName");
        assertEquals(fdibamon, null);
    }
}
