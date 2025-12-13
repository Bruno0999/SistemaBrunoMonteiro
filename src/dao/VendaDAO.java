/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.BcmCliente;
import bean.BcmVenda;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author bruno_monteiro
 */
public class VendaDAO extends DAOAbstract {

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();

        session.merge(object);
        session.getTransaction().commit();
        session.clear();
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();

        Object managed = session.merge(object);
        session.delete(managed);

        session.flush();
        session.clear();

        session.getTransaction().commit();
    }

    @Override
    public Object list(int id) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(BcmVenda.class);
        criteria.add(Restrictions.eq("bcm_id_venda", id));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista.get(0);
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(BcmVenda.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return (List) lista;
    }

    public List<BcmVenda> listClienteData(BcmCliente cliente, Date data) {
        session.beginTransaction();

        Criteria criteria = session.createCriteria(BcmVenda.class);
        criteria.add(Restrictions.eq("bcmCliente", cliente));
        criteria.add(Restrictions.eq("bcmData", data));

        List<BcmVenda> lista = criteria.list();
        session.getTransaction().commit();

        return lista;
    }

    public List<BcmVenda> listCliente(BcmCliente cliente) {
        session.beginTransaction();

        Criteria criteria = session.createCriteria(BcmVenda.class);
        criteria.add(Restrictions.eq("bcmCliente", cliente));

        List<BcmVenda> lista = criteria.list();
        session.getTransaction().commit();

        return lista;
    }

    public List<BcmVenda> listData(Date data) {
        session.beginTransaction();

        Criteria criteria = session.createCriteria(BcmVenda.class);
        criteria.add(Restrictions.eq("bcmData", data));

        List<BcmVenda> lista = criteria.list();
        session.getTransaction().commit();

        return lista;
    }

}
