package edu.iis.mto.serverloadbalancer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wojciech Szczepaniak on 11.06.2017.
 */
public class Server {
    public static final double MAXIMUM_LOAD = 100.0d;
    private double currentLoadPercentage;
    private int capacity;

    private List<Vm> vms = new ArrayList<Vm>();

    public Server(int capacity) {
        this.capacity = capacity;
    }

    public boolean contains(Vm theVm) {
        return vms.contains(theVm);
    }

    public void addVm(Vm vm) {
        currentLoadPercentage = getCurrentLoadPercentage() + loadOfVm(vm);
        this.vms.add(vm);
    }

    private double loadOfVm(Vm vm) {
        return (double) vm.getSize() / (double) this.getCapacity() * MAXIMUM_LOAD;
    }

    public int countVms() {
        return vms.size();
    }

    public boolean canFit(Vm vm) {
        return getCurrentLoadPercentage() + loadOfVm(vm) <= MAXIMUM_LOAD;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getCurrentLoadPercentage() {
        return currentLoadPercentage;
    }
}
