package service;

import dao.IDao;
import entities.Salle;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class SalleService extends UnicastRemoteObject implements IDao<Salle> {

    public SalleService() throws RemoteException {
        super();
    }

    @Override
    public boolean create(Salle o) throws RemoteException {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            etat = true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                etat = false;
            }
        } finally {
            if (session != null) {
                session.close();
            }

        }
        return etat;
    }

    @Override
    public boolean update(Salle o) throws RemoteException {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            etat = true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                etat = false;
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return etat;
    }

    @Override
    public boolean delete(Salle o) throws RemoteException {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            etat = true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                etat = false;
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return etat;
    }

    @Override
    public Salle findById(int id) throws RemoteException {
        Session session = null;
        Transaction tx = null;
        Salle salle = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            salle = (Salle) session.get(Salle.class, id);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return salle;
    }

    @Override
    public List<Salle> findAll() throws RemoteException {
        Session session = null;
        Transaction tx = null;
        List<Salle> salles = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            salles = session.getNamedQuery("findAllSalles").list();
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return salles;
    }

    @Override
    public Salle findByCode(String code) {
        Session session = null;
        Salle salle = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "FROM Salle s WHERE s.code = :code";
            Query query = session.createQuery(hql);
            query.setParameter("code", code);
            salle = (Salle) query.uniqueResult();

        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return salle;
    }

   @Override
    public boolean update(Salle o, Salle p) {
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            Salle clientToUpdate = (Salle) session.get(Salle.class, o.getId());

            if (clientToUpdate != null) {
                clientToUpdate.setCode(p.getCode());
                
                session.update(clientToUpdate); 
                tx.commit();

                return true;
            }
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("Erreur de modification de la salle : " + ex.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return false;
    }

}
