package com.conzentrate.calc.secondary;

import com.conzentrate.data.Args;

public interface ISecondaryCost {
    /**
     * Calculates a factor basing on CLI arguments. The
     * factor is applied to the previously calculated costs to form 
     * an updated total price.
     * 
     * @param args Apps parameters from CLI arguments
     * @param price previous price
     * 
     * @return an updated total cost calculated  by applying a factor to 
     * the previous price
     */
    public double calculate(Args args, double price);
}
