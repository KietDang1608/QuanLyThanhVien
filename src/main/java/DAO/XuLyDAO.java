package DAO;

import DTO.ThongTinSD;
import DTO.XuLy;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XuLyDAO {
    private SessionFactory factory;
    public XuLyDAO(){
        factory = Util.HibernateUtil.getSessionFactory();
    }
    public ArrayList<XuLy> getData(){
        ArrayList<XuLy> listXuLy = new ArrayList<>();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List lst= session.createQuery("FROM XuLy").list();
            for (Iterator iterator = lst.iterator(); iterator.hasNext();){
                XuLy ttsd = (XuLy) iterator.next();
                listXuLy.add(ttsd);
            }
        }catch (HibernateException e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return listXuLy;
    }
}
