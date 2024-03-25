package DAO;

import DTO.ThanhVien;
import DTO.ThongTinSD;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ThongTinSDDAO {
    private SessionFactory factory;
    public ThongTinSDDAO(){
        factory = Util.HibernateUtil.getSessionFactory();
    }
    public ArrayList<ThongTinSD> getData(){
        ArrayList<ThongTinSD> listTTSD = new ArrayList<>();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List lst= session.createQuery("FROM ThongTinSD").list();
            for (Iterator iterator = lst.iterator(); iterator.hasNext();){
                ThongTinSD ttsd = (ThongTinSD) iterator.next();
                listTTSD.add(ttsd);
            }
        }catch (HibernateException e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return listTTSD;
    }
}
