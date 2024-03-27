package DAO;

import DTO.ThanhVien;
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
    private Session session;
    public XuLyDAO()
    {
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }

     public ArrayList<XuLy> getData()
     {
        List<XuLy> listXuLy = new ArrayList<>();
        listXuLy =session.createQuery("FROM XuLy").list();
        session.getTransaction().commit();
        return new ArrayList<>(listXuLy);
    }

    public XuLy geXuLyByID(int ID)
    {
        XuLy xl= session.get(XuLy.class, ID);
        session.close();
        return xl;
    }

    public void addXuLy(XuLy xl)
    {
        session.save(xl);
        session.getTransaction().commit();
        session.close();
    }

    public Boolean delXuLy(int ID)
    {
        XuLy xl = session.get(XuLy.class, ID);
        if (xl != null) 
        {
            session.delete(xl);
            session.getTransaction().commit();
            session.close();
            return true;
        } 
        else 
        {
            System.out.println("Không tìm thấy XuLy có ID = " + ID);
            session.getTransaction().commit();
            session.close();
            return false;
        }
    }

    public Boolean updateXuLy(int ID, XuLy xlNew)
    {
        XuLy xlOld= session.get(XuLy.class, ID);
        if(xlOld != null)
        {
            xlOld.setHinhThucXL(xlNew.getHinhThucXL());
            xlOld.setMaTV(xlNew.getMaTV());
            xlOld.setNgayXL(xlNew.getNgayXL());
            xlOld.setSoTien(xlNew.getSoTien());
            xlOld.setTrangThaiXL(xlNew.getTrangThaiXL());
            session.update(xlOld);
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
