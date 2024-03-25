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

public class ThietBiDAO {
    private SessionFactory factory;
    public ThietBiDAO(){
        factory = Util.HibernateUtil.getSessionFactory();
    }
    public ArrayList<ThietBi> getData(){
        ArrayList<ThietBi> listThietBi = new ArrayList<>();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List lst= session.createQuery("FROM ThietBi").list();
            for (Iterator iterator = lst.iterator(); iterator.hasNext();){
                ThietBi thietBi = (ThietBi) iterator.next();
                listThietBi.add(thietBi);
            }
        }catch (HibernateException e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return listThietBi;
    }
}
