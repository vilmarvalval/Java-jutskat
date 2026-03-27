public class Task3_CoffeeMakerDriver {
    public static void main(String[] args){
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        //coffeeMaker.turnOnOff();
        System.out.println("Coffee maker is "+(coffeeMaker.isOn()?"on":"off"));
        coffeeMaker.setType(1);
        System.out.println("Coffee type is "+coffeeMaker.getType());
        coffeeMaker.setAmountMl(50);
        System.out.println("Coffee amount is "+coffeeMaker.getAmount()+" ml");
        coffeeMaker.turnOnOff();
        System.out.println("Coffee maker is "+(coffeeMaker.isOn()?"on":"off"));
    }
}