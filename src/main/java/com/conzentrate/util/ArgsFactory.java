package com.conzentrate.util;

import com.conzentrate.data.Args;
import com.conzentrate.data.CountryCode;
import com.conzentrate.data.PriceType;
import com.conzentrate.data.Currency;

public class ArgsFactory {
    private static Currency DEFAULT_INPUT_CURRENCY = Currency.DKK;
    private static String INPUT_CURRENCY_KEY = "--input-currency=";

    private static Currency DEFAULT_OUTPUT_CURRENCY = Currency.DKK;
    private static String OUTPUT_CURRENCY_KEY = "--output-currency=";

    private static CountryCode DEFAULT_COUNTRY_CODE = CountryCode.DEFAULT;
    private static String COUNTRY_CODE_KEY = "--vat=";
    
    private static Args DEFAULT_ARGS = new Args(0, 0, PriceType.BOOK, DEFAULT_COUNTRY_CODE, DEFAULT_INPUT_CURRENCY, DEFAULT_OUTPUT_CURRENCY );
    
    private Currency findInputCurrency(String[] args) {
       return this.findCurrency(args, 
                                    INPUT_CURRENCY_KEY, 
                                    DEFAULT_INPUT_CURRENCY);
    }

    private Currency findOutputCurrency(String[] args) {
        return this.findCurrency(args, 
                                     OUTPUT_CURRENCY_KEY, 
                                     DEFAULT_OUTPUT_CURRENCY);
     }

    private Currency findCurrency(String[] args, String key, Currency byDefault) {
        Currency result = byDefault;
        for(String arg : args) {
            if (arg.contains(key)) {
                result = Currency.valueOf(arg
                                            .replace(key, "")
                                            .trim());
            }
        }
        return result;
    }

    private CountryCode findCountryCode(String[] args) {
        CountryCode result = DEFAULT_COUNTRY_CODE;
        String key = COUNTRY_CODE_KEY;
        for(String arg : args) {
            if (arg.contains(key)) {
                result = CountryCode.valueOf(arg
                                            .replace(key, "")
                                            .trim());
            }
        }
        return result;
    }

    public Args parseArgs(String[] args) {
        Args argsObj = ArgsFactory.DEFAULT_ARGS;

        if (args.length >= 3) {
            argsObj = new Args(Integer.parseInt(args[0]), 
                            Double.parseDouble(args[1]),
                            "ONLINE".equals(args[2].toUpperCase())
                                ? PriceType.ONLINE
                                : PriceType.BOOK,
                            findCountryCode(args),
                            findInputCurrency(args),
                            findOutputCurrency(args));
        }
        return argsObj;
    }
}
