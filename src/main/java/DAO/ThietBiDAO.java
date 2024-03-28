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


import org.hibernate.query.Query;

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

    public boolean delThietBiByField(String fieldName, String value) 
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
            
            Query query = session.createQuery("delete from ThietBi where " + fieldName + " = :value");
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
