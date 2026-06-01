package task.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class CurrencyModel{
    private final Map<String, Double> conversionRates = new Hashtable<>();
    private final ObservableList<String> crncs;
    public CurrencyModel() {
        conversionRates.put("EUR", 1.0);
        conversionRates.put("USD", 1.17);
        conversionRates.put("GBP", 0.87);
        conversionRates.put("JPY", 185.73);
        ArrayList<String> list = new ArrayList<>(conversionRates.keySet());

        crncs = FXCollections.observableArrayList(list);
        System.out.println(this+": Model constructed");
    }

    public double get(String value){
        return conversionRates.get(value);
    }

    public ObservableList<String> getCrncs() {
        return crncs;
    }
}