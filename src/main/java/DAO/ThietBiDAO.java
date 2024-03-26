package DAO;

import DTO.ThanhVien;
import DTO.ThietBi;
import HibernateUtil.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ThietBiDAO {
    private SessionFactory factory;
   
    public List<ThietBi> getData(){
        List<ThietBi> listThietBi = new ArrayList<>();
        try(Session session=HibernateUtil.getSessionFactory().openSession();)
       {
        session.beginTransaction();
        listThietBi =session.createQuery("FROM ThietBi").list();
        // session.getTransaction().commit();
       }
        return listThietBi;
    }
}
