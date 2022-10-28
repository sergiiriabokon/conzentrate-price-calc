package com.conzentrate.calc;

import com.conzentrate.data.Args;
import com.conzentrate.App;

public class CurrencyTranslator {
    public double translate(Args args, double price) {
        double translated = price * args.getInputCurrency().rate / args.getOutputCurrency().rate;
        return App.roundPrice(translated);
    }
}
