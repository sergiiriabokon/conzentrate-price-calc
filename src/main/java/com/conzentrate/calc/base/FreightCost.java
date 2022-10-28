package com.conzentrate.calc.base;

import com.conzentrate.data.Args;
import com.conzentrate.App;

public class FreightCost implements IBaseCost {
    private int BASE_FREIGHT = 50;
    private int ADDITIONAL_FREIGHT_PER_10 = 25;

    public double calculate(Args args) {
        double price = 0;

        double additionalFreight = args.getAmount() > 10 
                                        ? ADDITIONAL_FREIGHT_PER_10 *( Math.ceil(args.getAmount() / 10.0) - 1)
                                        : 0;

        price = BASE_FREIGHT + additionalFreight;
        
        return App.roundPrice(price);
    }
}
