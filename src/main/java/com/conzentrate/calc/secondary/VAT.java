package com.conzentrate.calc.secondary;

import com.conzentrate.App;
import com.conzentrate.data.Args;
import com.conzentrate.data.CountryCode;
import com.conzentrate.data.PriceType;

public class VAT implements ISecondaryCost {
    
    private static final double SCANDINAVIAN_VAT  = 0.25;
    private static final double GREAT_BRITAIN_VAT = 0.20;
    private static final double GERMAN_ONLINE_VAT = 0.19;
    private static final double GERMAN_BOOK_VAT   = 0.12;
    private static final double DEFAULT_VAT       = 0;

    public double calculate(Args args, double price) {
        double vatFactor = this.getVAT(args) + 1.0;
        double result = vatFactor * price;

        return App.roundPrice(result);
    }

    private double getVAT(Args args) {
        double vat = 0;
        switch(args.getCountryCode()) {
            case DK:
            case NO:
            case SE:
                vat = SCANDINAVIAN_VAT;
            break;

            case GB:
                vat = GREAT_BRITAIN_VAT;
            break;

            case DE: 
                vat = args.getPriceType() == PriceType.ONLINE 
                        ? GERMAN_ONLINE_VAT 
                        : GERMAN_BOOK_VAT;
            break;

            default:
                vat = DEFAULT_VAT;
        }

        return vat;
    }
}
