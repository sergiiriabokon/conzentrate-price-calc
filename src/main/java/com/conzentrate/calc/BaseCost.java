package com.conzentrate.calc;

import com.conzentrate.data.Args;

public class BaseCost {
    public Double calculate(Args args) {
        return args.getAmount() * args.getPrice();
    }
}
