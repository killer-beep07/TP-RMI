/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientrmi2;

import dao.IDao;
import entities.Machine;
import entities.Salle;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lenovo
 */
public class ClientRMI2 {

    public static void main(String[] args) {

        try {
            IDao<Salle> dao2 = (IDao<Salle>) Naming.lookup("rmi://localhost:1099/dao2");

            Salle a = new Salle("B1");
            Salle b = new Salle("B2");
            Salle c = new Salle("B3");
            Salle d = new Salle("B4");
            dao2.create(a);
            dao2.create(b);
            dao2.create(c);
            dao2.create(d);
//            for (Salle s : dao2.findAll()) {
//                System.out.println(s);
//            }


            IDao<Machine> dao = (IDao<Machine>) Naming.lookup("rmi://localhost:1099/dao");

            dao.create(new Machine("ER1", "HP", 1000, a));
            dao.create(new Machine("ER2", "DELL", 2000, b));
            dao.create(new Machine("ER3", "LENOVO", 3000, d));
          
//    for (Machine m : dao.findAll()) {
//        System.out.println(m);
//    }

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(ClientRMI2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
