package DAO;

import DTO.ThanhVien;
import DTO.ThongTinSD;
import HibernateUtil.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ThongTinSDDAO {
    private SessionFactory factory;
    
    public List<ThongTinSD> getData(){
        List<ThongTinSD> listThongTinSD = new ArrayList<>();
        try(Session session=HibernateUtil.getSessionFactory().openSession();)
       {
        session.beginTransaction();
        listThongTinSD =session.createQuery("FROM ThongTinSD").list();
        // session.getTransaction().commit();
       }
        return listThongTinSD;
    }
}
