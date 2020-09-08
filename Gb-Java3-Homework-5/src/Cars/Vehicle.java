package Cars;

import GeekBrains.FuelStation;

public abstract class Vehicle implements Runnable {
    private final float consumption;
    private float fuel;
    private final int idx;
    private FuelStation station;

    public Vehicle(float consumption, float fuel, int idx, FuelStation station) {
        this.consumption = consumption;
        this.fuel = fuel;
        this.idx = idx;
        this.station = station;
    }

    public void drive() {
        while (canDrive()) {
            try {
                Thread.sleep(3000);
                fuel -= consumption;
                System.out.println(this.idx + " has fuel: " + this.fuel);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Vehicle idx " + this.idx + " is going to FuelStation");
        if (station.getFuel() > 0) {
            fuel += station.refuel();
        }
        if (!canDrive()) {
            return;
        }
        System.out.println("Vehicle idx " + this.idx + " is going back to highway");

    }

    @Override
    public void run() {
        System.out.println(this.idx + " is starting" + "\n Driving on highway");
        while (canDrive()) {
            drive();
        }
    }

    private boolean canDrive() {
        return fuel >= consumption;
    }
}
