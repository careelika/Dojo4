package tests;

import main.Kata2;
import org.junit.Test;

import java.io.FileNotFoundException;

import static main.Kata2.*;
import static org.junit.Assert.*;

public class KataTest {

    @Test
    public void getPartsTest() {
        assertEquals("Queens Park Rangers", getParts("20\tQueens Park Rangers\t12\t2\t2\t8\t11\t23")[0]);
    }

    @Test
    public void readDataTest() throws FileNotFoundException {
        assertEquals((long)19, (long) readData(fileName).get("Chelsea"));
    }

}