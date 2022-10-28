package com.conzentrate;

import java.util.List;
import java.util.ArrayList;
import com.conzentrate.calc.base.IBaseCost;
import com.conzentrate.calc.base.BaseCost;
import com.conzentrate.calc.base.FreightCost;
import com.conzentrate.calc.secondary.ISecondaryCost;
import com.conzentrate.calc.secondary.CurrencyTranslator;
import com.conzentrate.calc.secondary.VAT;

public class Configuration {
    
    public List<IBaseCost> getBaseCosts() {
        List<IBaseCost> baseCosts = new ArrayList<IBaseCost>();

        baseCosts.add(new BaseCost());
        baseCosts.add(new FreightCost());

        return baseCosts;
    }

    public List<ISecondaryCost> getSecondaryCosts() {
        List<ISecondaryCost> secondaryCosts = new ArrayList<ISecondaryCost>();
        
        secondaryCosts.add(new VAT());
        secondaryCosts.add(new CurrencyTranslator());

        return secondaryCosts;
    }
}
