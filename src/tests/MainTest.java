package tests;

import main.Main;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static main.Main.*;
import static org.junit.Assert.*;

public class MainTest {

    private static int[][] data;

    @Before
    public void setUp() throws Exception {
        data = Main.readData(Main.fileName);
    }

    @Test
         public void readFileTest() throws FileNotFoundException {
        assertEquals(1945, readData(Main.fileName)[0][0]);
    }

    @Test
    public void computePercentageTest() {
        assertEquals((100/3),computePercentage(10, 20),0.001 );
    }

    @Test
    public void findBiggestBoysPercentageTest() {
        assertEquals(1962, findBiggestBoysPercentageYear(data));
    }


}