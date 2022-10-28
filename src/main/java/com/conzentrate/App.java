package com.conzentrate;

import com.conzentrate.util.ArgsFactory;
import com.conzentrate.data.Args;
import com.conzentrate.calc.BaseCost;
import com.conzentrate.calc.FreightCost;
import com.conzentrate.calc.VAT;
import com.conzentrate.calc.CurrencyTranslator;

/**
 * App for calucalting prices
 *
 */
public class App 
{

    public static double roundPrice(double price) {
        return Math.round(price * 100) / 100.0;
    }

    public static void main( String[] cliArgs)
    {
        System.out.println( "Conzentrate Test Task!" );

        Args args = new ArgsFactory().parseArgs(cliArgs);
        double price = new BaseCost().calculate(args) + new FreightCost().calculate(args);
        price = App.roundPrice(price);

        double priceAfterVAT = new VAT().calculate(args, price);
        double priceVATWithCurrency = new CurrencyTranslator().translate(args, priceAfterVAT);

        System.out.println(args);
        System.out.printf("Price is %.2f %s \n", priceVATWithCurrency, args.getOutputCurrency().toString());
    }
}
