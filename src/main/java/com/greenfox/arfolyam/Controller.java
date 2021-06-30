package com.greenfox.arfolyam;

import com.greenfox.arfolyam.soap.MNBArfolyamServiceSoapGetCurrenciesStringFaultFaultMessage;
import com.greenfox.arfolyam.soap.MNBArfolyamServiceSoapGetCurrentExchangeRatesStringFaultFaultMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private ChangeService changeService;

    public Controller(ChangeService changeService) {
        this.changeService = changeService;
    }

    @GetMapping("/currencies")
    public ResponseEntity<String> getCurrencies() throws MNBArfolyamServiceSoapGetCurrenciesStringFaultFaultMessage {
        return ResponseEntity.status(HttpStatus.OK).body(changeService.getCurrencies());
    }

    @GetMapping("/euro")
    public ResponseEntity<String> getEuro() throws MNBArfolyamServiceSoapGetCurrentExchangeRatesStringFaultFaultMessage {
        return ResponseEntity.status(HttpStatus.OK).body(changeService.getEuroToHuf());
    }
}
