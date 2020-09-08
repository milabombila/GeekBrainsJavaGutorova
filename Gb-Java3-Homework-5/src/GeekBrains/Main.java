package GeekBrains;

import Cars.Bus;
import Cars.Car;
import Cars.Truck;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        FuelStation station = new FuelStation(60F, semaphore);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        Car car1 = new Car(1, station);
//        Car car2 = new Car(2, station);
//        Car car3 = new Car(3, station);
//        Car car4 = new Car(4, station);
//        Bus bus1 = new Bus(5,station);
//        Bus bus2 = new Bus(6,station);
//        Bus bus3 = new Bus(7,station);
//        Truck truck1 = new Truck(8, station);
//        Truck truck2 = new Truck(9, station);
//        Truck truck3 = new Truck(10, station);
        for (int i = 1; i < 6; i++) {
            executorService.execute(new Car(i, station));
        }
//        for (int i = 5; i < 8; i++) {
//            executorService.execute(new Bus(i, station));
//        }
//        for (int i = 8; i < 11; i++) {
//            executorService.execute(new Truck(i, station));
//        }
        executorService.shutdown();
    }
}
