/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author bruno_monteiro
 */
public abstract class DAOAbstract {

    public Session session;
    
    public DAOAbstract() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }

    public abstract void insert(Object object);

    public abstract void update(Object object);

    public abstract void delete(Object object);

    public abstract Object list(int id);

    public abstract List listAll();

}