package GeekBrains;

import java.util.concurrent.Semaphore;

public class FuelStation {
    private float fuel;
    private Semaphore semaphore;


    public FuelStation(float fuel, Semaphore semaphore) {
        this.fuel = fuel;
        this.semaphore = semaphore;
    }

    public float getFuel() {
        return fuel;
    }

    public float refuel() {
        try {
            semaphore.acquire();
            if (checkFuel()) {
                System.out.println("Starting refueling process");
                fuel -= 10F;
                Thread.sleep(5000);
                System.out.println("Finished refueling");
                System.out.println("Station fuel: " + fuel);
                semaphore.release();
                return 10F;
            }
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0F;
    }
    public boolean checkFuel(){
        return fuel>=0;
    }
}
