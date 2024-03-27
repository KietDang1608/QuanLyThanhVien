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
    private Session session;
    public ThietBiDAO()
    {
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }

    public ArrayList<ThietBi> getData()
    {
        List<ThietBi> listThietBi = new ArrayList<>();
        listThietBi =session.createQuery("FROM ThietBi").list();
        session.getTransaction().commit();
        return new ArrayList<>(listThietBi);
    }

    public ThietBi geThietBiByID(int ID)
    {
        ThietBi tb= session.get(ThietBi.class, ID);
        System.out.println(tb.toString());
        session.close();
        return tb;
    }

    public void addThietBi(ThietBi tb)
    {
        session.save(tb);
        session.getTransaction().commit();
        session.close();
    }

    public Boolean delThietBi(int ID)
    {
        ThietBi tb = session.get(ThietBi.class, ID);
        if (tb != null) 
        {
            session.delete(tb);
            session.getTransaction().commit();
            session.close();
            return true;
        } 
        else 
        {
            System.out.println("Không tìm thấy ThietBi có ID = " + ID);
            session.getTransaction().commit();
            session.close();
            return false;
        }
    }

    public Boolean updateThietBi(int ID, ThietBi tbNew)
    {
        ThietBi tbOld= session.get(ThietBi.class, ID);
        if(tbOld != null)
        {
           tbOld.setTenTB(tbNew.getTenTB());
           tbOld.setMoTa(tbNew.getMoTa());
            session.update(tbOld);
            session.getTransaction().commit();
            session.close();
            return true;
        }
        else
        {
            System.out.println("không tìm thấy thành viên cần sửa");
            session.close();
            return false;
        }
    }

}
