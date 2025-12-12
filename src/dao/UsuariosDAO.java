/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.BcmUsuarios;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import tools.Util;

/**
 *
 * @author bruno_monteiro
 */
public class UsuariosDAO extends DAOAbstract {

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Object list(int id) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(BcmUsuarios.class);
        criteria.add(Restrictions.eq("bcm_id_usuario", id));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista.get(0);
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(BcmUsuarios.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return (List) lista;
    }

    public Object listByNameAndPass(BcmUsuarios usuarios) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(BcmUsuarios.class);
        criteria.add(Restrictions.eq("bcmApelido", usuarios.getBcmApelido()));
        criteria.add(Restrictions.eq("bcmAtivo", "S"));
        List lista = criteria.list();
        session.getTransaction().commit();
        if (lista.isEmpty()) {
            Util.mostrar("Usuario incorreto ou inexistente", "Atenção", JOptionPane.ERROR);
            return null;
        } else {
            return lista.get(0);
        }
    }
}
