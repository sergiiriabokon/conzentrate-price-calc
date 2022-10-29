package com.conzentrate;

import java.util.List;
import java.util.ArrayList;
import com.conzentrate.util.ArgsFactory;
import com.conzentrate.data.Args;
import com.conzentrate.calc.base.IBaseCost;
import com.conzentrate.calc.secondary.ISecondaryCost;
import com.conzentrate.calc.PriceBuilder;

/**
 * App for calucalting prices
 *
 */
public class App 
{
    public double calculate(Args args) {
        Configuration conf = new Configuration();
        PriceBuilder priceBuilder = new PriceBuilder(conf.getBaseCosts(), 
                                                     conf.getSecondaryCosts());
        return priceBuilder.calculate(args);
    }

    public static double roundPrice(double price) {
        return Math.round(price * 100) / 100.0;
    }

    public static void main( String[] cliArgs )
    {
        Args args = ArgsFactory.getInstance().parseArgs(cliArgs);
        double price = new App().calculate(args);

        System.out.printf("%.2f %s \n", 
                          price, 
                          args.getOutputCurrency().toString());
    }
}
