package com.conzentrate;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.conzentrate.App;
import com.conzentrate.util.ArgsFactory;
import com.conzentrate.data.Args;

/**
 * Unit test for the App, that emulates CLI commands
 */
public class AppTest 
{
    /**
     * Tests equivalent for calling CLI:
     * java -jar target/conzentrate-price-calc-1.0-SNAPSHOT.jar 23 199.95 book
     */
    @Test
    public void testNoVatBook()
    {
        String[] cliArgs = new String[] {"23", "199.95", "book"};
        Args args = ArgsFactory.getInstance().parseArgs(cliArgs);
        double price = new App().calculate(args);

        int floorPrice = (int) (100 * price); 
        int expectedPrice = 469885;
        assertTrue( floorPrice == expectedPrice );
    }

    /**
     * Tests equivalent for calling CLI:
     * java -jar target/conzentrate-price-calc-1.0-SNAPSHOT.jar 12 139.95 book --output-currency=SEK --vat=DK
     */
    @Test
    public void testVatDKCurrencySEK()
    {
        String[] cliArgs = new String[] {"12", "139.95", "book", "--output-currency=SEK", "--vat=DK"};
        Args args = ArgsFactory.getInstance().parseArgs(cliArgs);
        double price = new App().calculate(args);

        int floorPrice = (int) (100 * price); 
        int expectedPrice = 312260;
        assertTrue( floorPrice == expectedPrice );
    }
}
