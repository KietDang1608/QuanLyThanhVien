package DAO;

import DTO.ThanhVien;
import DTO.ThongTinSD;
import DTO.XuLy;
import HibernateUtil.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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

    public boolean delXuLyByField(String fieldName, String value) 
    {
        try {
            int intValue;
            try {
                // Thử chuyển đổi giá trị từ String sang int
                intValue = Integer.parseInt(value);
            } catch (NumberFormatException ex) {
                // Nếu không thể chuyển đổi, giữ nguyên kiểu dữ liệu là String
                intValue = -1; // hoặc một giá trị khác biểu thị rằng không có giá trị số hợp lệ
            }
            
            Query query = session.createQuery("delete from XuLy where " + fieldName + " = :value");
            query.setParameter("value", intValue != -1 ? intValue : value); // Sử dụng giá trị chuỗi nếu không thể chuyển đổi thành số nguyên
            int result = query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            return result > 0; // Trả về true nếu có ít nhất một dòng bị ảnh hưởng (được xóa)
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
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
