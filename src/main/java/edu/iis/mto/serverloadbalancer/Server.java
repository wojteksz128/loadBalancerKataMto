package edu.iis.mto.serverloadbalancer;

/**
 * Created by Wojciech Szczepaniak on 11.06.2017.
 */
public class Server {
    private final double MAXIMUM_LOAD = 100.0d;
    public double currentLoadPercentage;
    public int capacity;

    public Server(int capacity) {
        this.capacity = capacity;
    }

    public boolean contains(Vm theVm) {
        return true;
    }

    public void addVm(Vm vm) {
        currentLoadPercentage = (double)vm.size / (double)this.capacity * MAXIMUM_LOAD;
    }
}
