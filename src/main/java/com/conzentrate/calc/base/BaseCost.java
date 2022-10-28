package com.conzentrate.calc.base;

import com.conzentrate.data.Args;
import com.conzentrate.App;

public class BaseCost implements IBaseCost {
    public double calculate(Args args) {
        double price = args.getAmount() * args.getPrice();
        return App.roundPrice(price);
    }
}
