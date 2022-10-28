package com.conzentrate.data;

public enum Currency {
    DKK(100.0),
    NOK(73.50),
    SEK(70.23),
    GBP(891.07),
    EUR(743.93);
    
    public final Double rate;

    private Currency(Double val) {
        this.rate = val;
    }
}
