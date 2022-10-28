package com.conzentrate.data;

public class Args {
    private int _amount;
    private double _price;
    private PriceType _priceType;
    private CountryCode _countryCode;
    private Currency _inputCurrency;
    private Currency _outputCurrency;

    public Args(int amount, 
                double price, 
                PriceType priceType,
                CountryCode countryCode,
                Currency inputCurrency,
                Currency outputCurrency) {
        this._amount = amount;
        this._price = price;
        this._priceType = priceType;
        this._countryCode = countryCode;
        this._inputCurrency = inputCurrency;
        this._outputCurrency = outputCurrency;
    }

    public int getAmount() {
        return this._amount;
    }

    public double getPrice() {
        return this._price;
    }

    public PriceType getPriceType() {
        return this._priceType;
    }

    public CountryCode getCountryCode() {
        return this._countryCode;
    }

    public Currency getInputCurrency() {
        return this._inputCurrency;
    }

    public Currency getOutputCurrency() {
        return this._outputCurrency;
    }

    @Override
    public String toString() {
        return this._amount + " " + this._price + " " + this._priceType;
    }
}
