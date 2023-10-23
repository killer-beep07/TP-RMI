/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import dao.IDao;
import entities.Machine;
import entities.Salle;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.MachineService;
import service.SalleService;
import util.HibernateUtil;

/**
 *
 * @author lenovo
 */
public class Test {
    public static void main(String[] args) throws NotBoundException, MalformedURLException {
       //  HibernateUtil.getSessionFactory();
        try {
            
//             IDao<Salle> dao2 = new SalleService();
//            // IDao<Salle> dao2 = (IDao<Salle>) Naming.lookup("rmi://localhost:1099/dao2");
//            Salle s = new Salle("B1");
//             dao2.create(s);
//             
//             
//             
//           
//            IDao<Machine> dao = new MachineService();
//            dao.create(new Machine("ER1", "HP",1000,s));
//            dao.create(new Machine("ER2", "DELL",2000,null));
//            dao.create(new Machine("ER3", "LENOVO",3000,s));
//            for (Salle ss : dao2.findAll()) 
//            {
//                 System.out.println(ss);
//            }
//            
//            for (Machine m : dao.findAll()) {
//                System.out.println(m);
//                
//            }
            
            IDao<Salle> dao2 = new SalleService();
            Salle a = new Salle("B1");
            Salle b = new Salle("B2");
            Salle c = new Salle("B3");
            Salle d = new Salle("B4");
            dao2.create(a);
            dao2.create(b);
            dao2.create(c);
            dao2.create(d);

          
            
            
            IDao<Machine> dao = new MachineService();
            
            
            
            dao.create(new Machine("ER1", "HP",1000, a));
            dao.create(new Machine("ER2", "DELL",2000,b) );
            dao.create(new Machine("ER3", "LENOVO",3000,d));
            
              for (Salle s : dao2.findAll()) {
                System.out.println(s);
            }
            for(Machine m: dao.findAll()){
                System.out.println(m);
            }
                    
                    } catch (RemoteException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
