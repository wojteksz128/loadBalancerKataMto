package edu.iis.mto.serverloadbalancer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wojciech Szczepaniak on 11.06.2017.
 */
public class Server {
    public static final double MAXIMUM_LOAD = 100.0d;
    public double currentLoadPercentage;
    public int capacity;

    private List<Vm> vms = new ArrayList<Vm>();

    public Server(int capacity) {
        this.capacity = capacity;
    }

    public boolean contains(Vm theVm) {
        return vms.contains(theVm);
    }

    public void addVm(Vm vm) {
        currentLoadPercentage += loadOfVm(vm);
        this.vms.add(vm);
    }

    private double loadOfVm(Vm vm) {
        return (double)vm.size / (double)this.capacity * MAXIMUM_LOAD;
    }

    public int countVms() {
        return vms.size();
    }

    public boolean canFit(Vm vm) {
        return currentLoadPercentage + loadOfVm(vm) <= MAXIMUM_LOAD;
    }
}
