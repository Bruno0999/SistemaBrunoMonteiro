/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.BcmVenda;
import bean.BcmVendaProduto;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author bruno_monteiro
 */
public class VendaProdutoDAO extends DAOAbstract {

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
        Criteria criteria = session.createCriteria(BcmVendaProduto.class);
        criteria.add(Restrictions.eq("bcm_id_codigo", id));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista.get(0);
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(BcmVendaProduto.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return (List) lista;
    }

    public List listProdutos(BcmVenda bcmVenda) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(BcmVendaProduto.class);
        criteria.add(Restrictions.eq("bcmVenda", bcmVenda));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
}
