

package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface IDao <T> extends Remote {
    boolean create(T o) throws RemoteException;
    boolean update(T o) throws RemoteException;
    boolean update (T o,T p)throws RemoteException;
    boolean delete(T o) throws RemoteException;
    T findById(int id) throws RemoteException;
    T findByCode(String code) throws RemoteException;
    List<T> findAll() throws RemoteException;
    
}

