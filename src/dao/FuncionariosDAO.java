/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.BcmFuncionarios;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author bruno_monteiro
 */
public class FuncionariosDAO extends DAOAbstract{

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
        Criteria criteria = session.createCriteria(BcmFuncionarios.class);
        criteria.add(Restrictions.eq("bcm_id_codigo", id));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista.get(0);
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(BcmFuncionarios.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return (List) lista;
    }
    
    
    public List listNome (String nome){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(BcmFuncionarios.class);
        criteria.add(Restrictions.like("bcmNome", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public List listCpf (String cpf){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(BcmFuncionarios.class);
        criteria.add(Restrictions.like("bcmCpf", "%" + cpf + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public List listNomeCpf (String nome, String cpf){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(BcmFuncionarios.class);
        criteria.add(Restrictions.like("bcmNome", "%" + nome + "%"));
        criteria.add(Restrictions.like("bcmCpf", "%" + cpf + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
}
