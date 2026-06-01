package task.Controller;

import javafx.collections.ObservableList;
import task.View.CurrencyConverterGUI;
import task.Model.CurrencyModel;

public class ConverterController{
    private final CurrencyModel converter = new CurrencyModel();
    private final CurrencyConverterGUI gui;
    public ConverterController(CurrencyConverterGUI gui){
        this.gui = gui;
        System.out.println(this+": Converter constructed");
    }
    public double toEUR(String from, double amount){
        return amount/converter.get(from);
    }

    public double fromEUR(String to, double amount){
        return amount*converter.get(to);
    }


    public void Convert(String from, String to, double amount){
        double result;
        if((amount == 0)){
            gui.setResult(-1,to);
        } else{
            if (from.equals("EUR")){
                result = fromEUR(to, amount);
            } else{
                result = fromEUR(to, toEUR(from, amount));
            }
            gui.setResult(result, to);
        }
    }
    public ObservableList<String> getCrncs(){
        return converter.getCrncs();
    }

}