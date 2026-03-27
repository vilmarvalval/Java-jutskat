public class CoffeeMaker {
    private boolean on = false;
    private final String[] types={"normal", "espresso"};
    public String type = "";
    public final int amountMax = 80;
    public final int amountMin = 10;
    public int amountNow;

    void turnOnOff(){
        this.on = !this.on;
    }
    boolean isOn(){
        return this.on;
    }

    void setType(int type){
        if (this.on){
            this.type = types[type];
        }
    }
    String getType(){
        if (this.on) {
            return this.type;
        } else {
            return "";
        }
    }

    void setAmountMl(int amount){
        if (this.on) {
            this.amountNow = Math.min(amountMax, Math.max(amountMin, amount));
        }
    }

    int getAmount(){
        if (this.on) {
            return this.amountNow;
        } else{
            return 0;
        }
    }
}