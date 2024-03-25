package DAO;

import DTO.ThanhVien;
import DTO.ThietBi;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ThanhVienDAO {
    private SessionFactory factory;
    public ThanhVienDAO(){
        factory = Util.HibernateUtil.getSessionFactory();
    }
    public ArrayList<ThanhVien> getData(){
        ArrayList<ThanhVien> listThanhVien = new ArrayList<>();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List lst= session.createQuery("FROM ThanhVien").list();
            for (Iterator iterator = lst.iterator(); iterator.hasNext();){
                ThanhVien thanhVien = (ThanhVien) iterator.next();
                listThanhVien.add(thanhVien);
            }
        }catch (HibernateException e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return listThanhVien;
    }
}
