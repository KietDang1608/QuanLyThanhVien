package DAO;

import DTO.ThongTinSD;
import DTO.XuLy;
import HibernateUtil.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XuLyDAO {
    private SessionFactory factory;
     public List<XuLy> getData(){
        List<XuLy> listXuLy = new ArrayList<>();
        try(Session session=HibernateUtil.getSessionFactory().openSession();)
       {
        session.beginTransaction();
        listXuLy =session.createQuery("FROM XuLy").list();
        // session.getTransaction().commit();
       }
        return listXuLy;
    }
}
