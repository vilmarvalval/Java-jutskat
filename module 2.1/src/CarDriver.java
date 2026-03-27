public class CarDriver {
    public static void main(String[] args) {
        Car myCar;

        myCar = new Car("Toyota Corolla");
        myCar.fillTank();

        for (int i = 0; i < 6; i++) {
            myCar.accelerate(10);
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h, and gas level: "+myCar.getGasolineLevel()+" l");
        }

        while (myCar.getSpeed() > 0) {
            myCar.decelerate(15);
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h, and gas level: "+myCar.getGasolineLevel()+" l");
        }
        // Why to modify CarDriver first? -A: to see/plan what parameters should be given to the functions
        
        myCar.accelerate(30);
        System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed()
                + " km/h, and gas level: "+myCar.getGasolineLevel()+" l");
        myCar.setCruise(120);
        System.out.println(myCar.getTypeName()+": cruise set to "+ myCar.getCurrentCruise());
        System.out.println(myCar.getTypeName()+": cruise status: "+myCar.cruiseOnOff());
        System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed()
                + " km/h, and gas level: "+myCar.getGasolineLevel()+" l");
        System.out.println(myCar.getTypeName()+": cruise status: "+myCar.setCruise(50));
        System.out.println(myCar.getTypeName()+": cruise set to "+ myCar.getCurrentCruise());
        System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed()
                + " km/h, and gas level: "+myCar.getGasolineLevel()+" l");
        System.out.println(myCar.getTypeName()+": cruise status: "+myCar.setCruise(15));
        System.out.println(myCar.getTypeName()+": cruise set to "+ myCar.getCurrentCruise());
        System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed()
                + " km/h, and gas level: "+myCar.getGasolineLevel()+" l");
        myCar.setCruise(80);
        System.out.println(myCar.getTypeName()+": cruise set to "+ myCar.getCurrentCruise());
        System.out.println(myCar.getTypeName()+": cruise status: "+myCar.cruiseOnOff());
        System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed()
                + " km/h, and gas level: "+myCar.getGasolineLevel()+" l");
        while (myCar.getGasolineLevel() >0){
            System.out.println(myCar.getTypeName()+": cruise status: "+myCar.setCruise(180)
                    +" gas: "+ myCar.getGasolineLevel());
            System.out.println(myCar.getTypeName()+": cruise status: "+myCar.setCruise(20));
        }
        myCar.fillTank();
        myCar.setCruise(80);
        System.out.println(myCar.getTypeName()+": cruise status: "+myCar.cruiseOnOff());
        while (myCar.getGasolineLevel() >0){
            System.out.println(myCar.getTypeName()+": cruise status: "+myCar.setCruise(180)
                    +" gas: "+ myCar.getGasolineLevel());
            System.out.println(myCar.getTypeName()+": cruise status: "+myCar.setCruise(20));
        }


    }
}