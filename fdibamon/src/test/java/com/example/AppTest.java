package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AppTest 
{
    @Test
    public void fdibamonsShouldBeEqual() {
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
        
        Fdibamon fdibamon = App.getFdibamonFromList(fdibamons, "Rado");
        assertEqual(fdibamon, rado);
    }

    private void assertEqual(Fdibamon fdibamon, Fdibamon rado) {
    }

    @Test
    public void fdibamonsShouldNotBeEqual() {
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
        
        Fdibamon fdibamon = App.getFdibamonFromList(fdibamons, "Rado");
        assertNotEquals(fdibamon, klaus);
    }

    @Test
    public void fdibamonsShouldBeNull() {
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
        
        Fdibamon fdibamon = App.getFdibamonFromList(fdibamons, "NotAName");
        assertEquals(fdibamon, null);
    }
}
