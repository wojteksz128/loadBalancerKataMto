package edu.iis.mto.serverloadbalancer;

/**
 * Created by Wojciech Szczepaniak on 11.06.2017.
 */
public class ServerLoadBalancer {
    public void balance(Server[] servers, Vm[] vms) {
        for (Vm vm : vms) {
            addToLessLoadedServer(servers, vm);
        }
    }

    private void addToLessLoadedServer(Server[] servers, Vm vm) {
        Server lessLoadedServer = findLessLoadedServer(servers, vm);
        if (lessLoadedServer != null) {
            lessLoadedServer.addVm(vm);
        }
    }

    private Server findLessLoadedServer(Server[] servers, Vm vm) {
        Server lessLoadedServer = null;
        for (Server server : servers) {
            if ((lessLoadedServer == null || server.currentLoadPercentage < lessLoadedServer.currentLoadPercentage) && server.canFit(vm)) {
                lessLoadedServer = server;
            }
        }
        return lessLoadedServer;
    }
}
