package com.conzentrate.calc;

import java.util.List;

import com.conzentrate.calc.base.IBaseCost;
import com.conzentrate.calc.secondary.ISecondaryCost;
import com.conzentrate.data.Args;

public class PriceBuilder {
    private List<IBaseCost> _baseCosts;
    private List<ISecondaryCost> _secondaryCosts;

    public PriceBuilder(List<IBaseCost> baseCosts,  List<ISecondaryCost> secondaryCosts) {
        this._baseCosts = baseCosts;
        this._secondaryCosts = secondaryCosts;
    }

    public double calculate(Args args) {
        double price = calculateBaseCosts(args);
        return calculateSecondaryCosts(args, price);
    }

    private double calculateBaseCosts(Args args) {
        double price = 0;

        for(IBaseCost baseCost: this._baseCosts) {
            price += baseCost.calculate(args);
        }

        return price;
    }

    private double calculateSecondaryCosts(Args args, double price) {
        for(ISecondaryCost secondaryCost: this._secondaryCosts) {
            price = secondaryCost.calculate(args, price);
        }
        return price;
    }
}
