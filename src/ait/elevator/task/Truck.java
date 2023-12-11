package ait.elevator.task;

import ait.elevator.model.Elevator;

public class Truck implements Runnable {
    private static Object monitor1 = new Object();
    private static Object monitor2 = new Object();
    private int nRaces;
    private int capasity;
    private Elevator[] elevator;

    public Truck(int nRaces, int capasity, Elevator... elevator) {
        this.nRaces = nRaces;
        this.capasity = capasity;
        this.elevator = elevator;
    }

    @Override
    public void run() {
        for (int i = 0; i < nRaces; i++) {

        if (hashCode() % 2 == 0) {
                synchronized (monitor1) {
                    elevator[0].add(capasity / 2);
                }
                synchronized (monitor2) {
                    elevator[1].add(capasity / 2);
                }
            }else {
                    synchronized (monitor2) {
                        elevator[1].add(capasity / 2);
                    }
                synchronized (monitor1){
                    elevator[0].add(capasity/2);
                }
            }
        }
    }
}