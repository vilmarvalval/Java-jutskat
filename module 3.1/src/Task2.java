//Using your earlier bus class create Bus class that can take a number of passengers (passengerEnter()
// and passengerExit() or similar methods are needed probably).

public class Task2 {
    public static void main(String[] args) {
        Bus bus = new Bus(50, "bus1");

        System.out.println(bus.minCruise+ " "+ bus.maxCruise+ " "+ bus.acceleration+ " "+ bus.maxSpeed+ " " + bus.tankCapacity+ " "+ bus.getGasolineLevel() +" "+ bus.getTypeName());
        bus.fillTank();
        System.out.println(bus.minCruise+ " "+ bus.maxCruise+ " "+ bus.acceleration+ " "+ bus.maxSpeed+ " " + bus.tankCapacity+ " "+ bus.getGasolineLevel() +" "+ bus.getTypeName());

        for (int i = 0; i < 6; i++) {
            bus.accelerate(10);
            System.out.println(bus.getTypeName() + ": speed is " + bus.getSpeed() + " km/h, and gas level: "+bus.getGasolineLevel()+" l");
        }
        System.out.println("\n1st test complete\n");
        while (bus.getSpeed() > 0) {
            bus.decelerate(15);
            System.out.println(bus.getTypeName() + ": speed is " + bus.getSpeed() + " km/h, and gas level: "+bus.getGasolineLevel()+" l");
        }
        System.out.println("\n2nd test complete\n");

        bus.accelerate(30);
        System.out.println(bus.getTypeName() + ": speed is " + bus.getSpeed()
                + " km/h, and gas level: "+bus.getGasolineLevel()+" l");
        bus.setCruise(120);
        bus.fillTank();
        System.out.println(bus.getTypeName()+": cruise set to "+ bus.getCurrentCruise());
        System.out.println(bus.getTypeName()+": cruise status: "+bus.cruiseOnOff());
        System.out.println(bus.getTypeName() + ": speed is " + bus.getSpeed()
                + " km/h, and gas level: "+bus.getGasolineLevel()+" l");
        System.out.println(bus.getTypeName()+": cruise status: "+bus.setCruise(50));
        System.out.println(bus.getTypeName()+": cruise set to "+ bus.getCurrentCruise());
        System.out.println(bus.getTypeName() + ": speed is " + bus.getSpeed()
                + " km/h, and gas level: "+bus.getGasolineLevel()+" l");
        System.out.println(bus.getTypeName()+": cruise status: "+bus.setCruise(15));
        System.out.println(bus.getTypeName()+": cruise set to "+ bus.getCurrentCruise());
        System.out.println(bus.getTypeName() + ": speed is " + bus.getSpeed()
                + " km/h, and gas level: "+bus.getGasolineLevel()+" l");
        bus.setCruise(80);
        System.out.println(bus.getTypeName()+": cruise set to "+ bus.getCurrentCruise());
        System.out.println(bus.getTypeName()+": cruise status: "+bus.cruiseOnOff());
        System.out.println(bus.getTypeName() + ": speed is " + bus.getSpeed()
                + " km/h, and gas level: "+bus.getGasolineLevel()+" l");
        System.out.println("\n3rd test complete\n");
        bus.fillTank();
        System.out.println(bus.getTypeName()+": cruise set to "+ bus.getCurrentCruise());
        System.out.println(bus.getTypeName()+": cruise status: "+bus.isCruiseOn());
        if (!bus.isCruiseOn()){
            System.out.println(bus.getTypeName()+": cruise status: "+bus.isCruiseOn());
            System.out.println(bus.getTypeName()+": cruise status: "+bus.cruiseOnOff());
        }
        System.out.println(bus.getTypeName()+": cruise status: "+bus.isCruiseOn());

        while (bus.getGasolineLevel() >0){
            System.out.println(bus.getTypeName()+": cruise status: "+bus.setCruise(100)
                    +" gas: "+ bus.getGasolineLevel());
            System.out.println(bus.getTypeName()+": cruise status: "+bus.setCruise(20));
        }
        System.out.println("\n4th test complete\n");
        bus.fillTank();
        bus.setCruise(80);
        System.out.println(bus.getTypeName()+": cruise status: "+bus.cruiseOnOff()+" gas: "+ bus.getGasolineLevel());
        while (bus.getGasolineLevel() >0){
            System.out.println(bus.getTypeName()+": cruise status: "+bus.setCruise(100)
                    +" gas: "+ bus.getGasolineLevel());
            System.out.println(bus.getTypeName()+": cruise status: "+bus.setCruise(20));
        }
        System.out.println("\n5th test complete\n");
    }
}