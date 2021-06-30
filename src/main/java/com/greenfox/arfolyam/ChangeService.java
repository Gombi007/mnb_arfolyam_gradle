package com.greenfox.arfolyam;

import com.greenfox.arfolyam.soap.MNBArfolyamServiceSoapGetCurrenciesStringFaultFaultMessage;
import com.greenfox.arfolyam.soap.MNBArfolyamServiceSoapGetCurrentExchangeRatesStringFaultFaultMessage;
import com.greenfox.arfolyam.soap.MNBArfolyamServiceSoapImpl;
import org.springframework.stereotype.Service;

@Service
public class ChangeService {

    public String getCurrencies() throws MNBArfolyamServiceSoapGetCurrenciesStringFaultFaultMessage {

        MNBArfolyamServiceSoapImpl mnb = new MNBArfolyamServiceSoapImpl();
        return mnb.getCustomBindingMNBArfolyamServiceSoap().getCurrencies();
    }

    public String getEuroToHuf() throws MNBArfolyamServiceSoapGetCurrentExchangeRatesStringFaultFaultMessage {

        MNBArfolyamServiceSoapImpl mnb = new MNBArfolyamServiceSoapImpl();
        String answer = mnb.getCustomBindingMNBArfolyamServiceSoap().getCurrentExchangeRates();
        String onlyEuro = "";

        String[] currencies = answer.split(",");
        for (int i = 0; i < currencies.length; i++) {
            if (currencies[i].contains("EUR")) {
                onlyEuro += currencies[i];
            }
        }
        return onlyEuro;
    }

}
