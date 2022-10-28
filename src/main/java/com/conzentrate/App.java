package com.conzentrate;

import com.conzentrate.util.ArgsFactory;
import com.conzentrate.data.Args;
import com.conzentrate.calc.base.BaseCost;
import com.conzentrate.calc.base.FreightCost;
import com.conzentrate.calc.secondary.CurrencyTranslator;
import com.conzentrate.calc.secondary.VAT;

/**
 * App for calucalting prices
 *
 */
public class App 
{
    public static double roundPrice(double price) {
        return Math.round(price * 100) / 100.0;
    }

    public double calculate(Args args) {
        double price = new BaseCost().calculate(args) + new FreightCost().calculate(args);

        double priceAfterVAT = new VAT().calculate(args, price);
        double priceVATWithCurrency = new CurrencyTranslator().calculate(args, priceAfterVAT);
        
        return priceVATWithCurrency;
    }

    public static void main( String[] cliArgs )
    {
        System.out.println( "Conzentrate Test Task!" );

        Args args = ArgsFactory.getInstance().parseArgs(cliArgs);
        double price = new App().calculate(args);

        System.out.printf("Price is %.2f %s \n", 
                          price, 
                          args.getOutputCurrency().toString());
    }
}
