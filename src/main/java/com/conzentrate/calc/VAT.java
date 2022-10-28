package com.conzentrate.calc;

import com.conzentrate.App;
import com.conzentrate.data.Args;
import com.conzentrate.data.CountryCode;
import com.conzentrate.data.PriceType;

public class VAT {

    public double calculate(Args args, Double price) {
        double vatFactor = this.getVAT(args) + 1.0;
        double result = vatFactor * price;
        
        return App.roundPrice(result);
    }

    private double getVAT(Args args) {
        double vat = .25;
        switch(args.getCountryCode()) {
            case DK:
            case NO:
            case SE:
                vat = 0.25;
            break;

            case GB:
                vat = 0.20;
            break;

            case DE: 
                vat = args.getPriceType() == PriceType.ONLINE 
                        ? 19 
                        : 12;
            break;

            default:
                vat = 0.25;
            break;
        }

        return vat;
    }
}
