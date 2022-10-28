package com.conzentrate.calc.secondary;

import com.conzentrate.data.Args;
import com.conzentrate.App;

public class CurrencyTranslator implements ISecondaryCost {
    public double calculate(Args args, double price) {
        double translated = price * args.getInputCurrency().rate / args.getOutputCurrency().rate;
        return App.roundPrice(translated);
    }
}
