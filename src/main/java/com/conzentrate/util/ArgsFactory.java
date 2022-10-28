package com.conzentrate.util;

import com.conzentrate.data.Args;
import com.conzentrate.data.PriceType;

public class ArgsFactory {
    private static Args DEFAULT_ARGS = new Args(0, 0, PriceType.BOOK);
    
    public static Args parseArgs(String[] args) {
        Args argsObj = ArgsFactory.DEFAULT_ARGS;

        if (3 >= args.length) {
            argsObj = new Args(Integer.parseInt(args[0]), 
                            Double.parseDouble(args[1]),
                            "ONLINE".equals(args[2].toUpperCase())
                                ? PriceType.ONLINE
                                : PriceType.BOOK);
        }
        return argsObj;
    }
}
