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

public class ThanhVienDAO {
    private SessionFactory factory;
    
    public List<ThanhVien> getData(){
        List<ThanhVien> listThanhVien = new ArrayList<>();
        try(Session session=HibernateUtil.getSessionFactory().openSession();)
       {
        session.beginTransaction();
       listThanhVien =session.createQuery("FROM ThanhVien").list();
        // session.getTransaction().commit();
       }
        return listThanhVien;
    }
}
