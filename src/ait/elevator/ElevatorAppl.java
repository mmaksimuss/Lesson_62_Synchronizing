package ait.elevator;

import ait.elevator.model.Elevator;
import ait.elevator.task.Truck;

public class ElevatorAppl {
    private static final int N_TRUCK = 1000;
    private static final int N_RACES = 10;
    private static final int CAPASITY = 20;


    public static void main(String[] args) throws InterruptedException {
        Elevator lenin = new Elevator("Lenin");
        Elevator stalin = new Elevator("Stalin");
        Truck[] trucks = new Truck[N_TRUCK];
        for (int i = 0; i < trucks.length; i++) {
            trucks[i] = new Truck(N_RACES, CAPASITY, lenin, stalin);
        }
        Thread[] threads = new Thread[N_TRUCK];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(trucks[i]);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
//        for (Thread thread:threads){
//            thread.join();

        // System.out.println("Elevator "+lenin.getName()+" has "+lenin.getCurrentVolume());
        System.out.println(stalin);
        System.out.println(lenin);
    }
}
