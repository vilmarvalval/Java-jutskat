//Using your earlier Car class create SportsCar class that has better acceleration and deceleration
// (and higher gasoline consumption) than an ordinary Car.

public class Task1 {
    public static void main(String[] args) {

        SportsCar car = new SportsCar("sports car");
        System.out.println(car.minCruise+ " "+ car.maxCruise+ " "+ car.acceleration+ " "+ car.maxSpeed+ " " + car.tankCapacity+ " "+ car.getGasolineLevel() +" "+ car.getTypeName());
        car.fillTank();
        System.out.println(car.minCruise+ " "+ car.maxCruise+ " "+ car.acceleration+ " "+ car.maxSpeed+ " " + car.tankCapacity+ " "+ car.getGasolineLevel() +" "+ car.getTypeName());

        for (int i = 0; i < 6; i++) {
            car.accelerate(10);
            System.out.println(car.getTypeName() + ": speed is " + car.getSpeed() + " km/h, and gas level: "+car.getGasolineLevel()+" l");
        }
        System.out.println("\n1st test complete\n");
        while (car.getSpeed() > 0) {
            car.decelerate(15);
            System.out.println(car.getTypeName() + ": speed is " + car.getSpeed() + " km/h, and gas level: "+car.getGasolineLevel()+" l");
        }
        System.out.println("\n2nd test complete\n");

        car.accelerate(30);
        System.out.println(car.getTypeName() + ": speed is " + car.getSpeed()
                + " km/h, and gas level: "+car.getGasolineLevel()+" l");
        car.setCruise(120);
        car.fillTank();
        System.out.println(car.getTypeName()+": cruise set to "+ car.getCurrentCruise());
        System.out.println(car.getTypeName()+": cruise status: "+car.cruiseOnOff());
        System.out.println(car.getTypeName() + ": speed is " + car.getSpeed()
                + " km/h, and gas level: "+car.getGasolineLevel()+" l");
        System.out.println(car.getTypeName()+": cruise status: "+car.setCruise(50));
        System.out.println(car.getTypeName()+": cruise set to "+ car.getCurrentCruise());
        System.out.println(car.getTypeName() + ": speed is " + car.getSpeed()
                + " km/h, and gas level: "+car.getGasolineLevel()+" l");
        System.out.println(car.getTypeName()+": cruise status: "+car.setCruise(15));
        System.out.println(car.getTypeName()+": cruise set to "+ car.getCurrentCruise());
        System.out.println(car.getTypeName() + ": speed is " + car.getSpeed()
                + " km/h, and gas level: "+car.getGasolineLevel()+" l");
        car.setCruise(80);
        System.out.println(car.getTypeName()+": cruise set to "+ car.getCurrentCruise());
        System.out.println(car.getTypeName()+": cruise status: "+car.cruiseOnOff());
        System.out.println(car.getTypeName() + ": speed is " + car.getSpeed()
                + " km/h, and gas level: "+car.getGasolineLevel()+" l");
        System.out.println("\n3rd test complete\n");
        car.fillTank();
        System.out.println(car.getTypeName()+": cruise set to "+ car.getCurrentCruise());

        System.out.println(car.getTypeName()+": cruise status: "+car.isCruiseOn());
        if (!car.isCruiseOn()){
            System.out.println(car.getTypeName()+": cruise status: "+car.isCruiseOn());
            System.out.println(car.getTypeName()+": cruise status: "+car.cruiseOnOff());
        }
        System.out.println(car.getTypeName()+": cruise status: "+car.isCruiseOn());

        while (car.getGasolineLevel() >0){
            System.out.println(car.getTypeName()+": cruise status: "+car.setCruise(180)
                    +" gas: "+ car.getGasolineLevel());
            System.out.println(car.getTypeName()+": cruise status: "+car.setCruise(20));
        }
        System.out.println("\n4th test complete\n");
        car.fillTank();
        car.setCruise(80);
        System.out.println(car.getTypeName()+": cruise status: "+car.cruiseOnOff()+" gas: "+ car.getGasolineLevel());
        while (car.getGasolineLevel() >0){
            System.out.println(car.getTypeName()+": cruise status: "+car.setCruise(180)
                    +" gas: "+ car.getGasolineLevel());
            System.out.println(car.getTypeName()+": cruise status: "+car.setCruise(20));
        }
        System.out.println("\n5th test complete\n");
    }
}