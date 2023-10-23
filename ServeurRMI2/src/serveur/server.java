
    
    
    package Serveur;

import dao.IDao;
import entities.Machine;
import entities.Salle;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.MachineService;
import service.SalleService;

public class server {

    public static void main(String[] args) {

        try {

            IDao<Salle> dao2 = new SalleService();
            LocateRegistry.createRegistry(1099);
            Naming.bind("rmi://localhost:1099/dao2", dao2);
           
            
            IDao<Machine> dao = new MachineService();
            Naming.bind("rmi://localhost:1099/dao", dao);

            System.out.println("En attente des clients");

        } catch (RemoteException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}