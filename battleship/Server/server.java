package Server;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class server extends serverRes {
    public server() {}
    public static void main(String args[]) {
        try {
            // Instantiating the implementation class
            serverRes obj = new serverRes();

            // Exporting the object of implementation class
            // (here we are exporting the remote object to the stub)
            serverImpl stub = (serverImpl) UnicastRemoteObject.exportObject(obj, 0);
            LocateRegistry.createRegistry(1001);
            // Binding the remote object (stub) in the registry
            Registry registry = LocateRegistry.getRegistry(1001);

            registry.bind("BattleShip", stub);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

