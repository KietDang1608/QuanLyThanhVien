package DAO;

import DTO.ThanhVien;
import DTO.ThietBi;
import HibernateUtil.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ThanhVienDAO {
    private SessionFactory factory;
    private Session session;
    public ThanhVienDAO()
    {
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }

    public ArrayList<ThanhVien> getData(){
        List<ThanhVien> listThanhVien = new ArrayList<>();
        listThanhVien = session.createQuery("FROM ThanhVien").list();
        session.getTransaction().commit();
        // Chuyển đổi List thành ArrayList nếu cần
        return new ArrayList<>(listThanhVien);
    }

    public ThanhVien getThanhVienByID(int ID)
    {
        ThanhVien tv= session.get(ThanhVien.class, ID);
        session.close();
        return tv;
    }

    public void addThanhVien(ThanhVien tv)
    {
        session.save(tv);
        session.getTransaction().commit();
        session.close();
    }

    public Boolean delThanhVien(int ID)
    {
        ThanhVien tv = session.get(ThanhVien.class, ID);
        if (tv != null) 
        {
            session.delete(tv);
            session.getTransaction().commit();
            session.close();
            return true;
        } 
        else 
        {
            System.out.println("Không tìm thấy ThanhVien có ID = " + ID);
            session.getTransaction().commit();
            session.close();
            return false;
        }
    }

     public boolean delThanhVienByField(String fieldName, String value) {
        try {
            int intValue;
            try {
                // Thử chuyển đổi giá trị từ String sang int
                intValue = Integer.parseInt(value);
            } catch (NumberFormatException ex) {
                // Nếu không thể chuyển đổi, giữ nguyên kiểu dữ liệu là String
                intValue = -1; // hoặc một giá trị khác biểu thị rằng không có giá trị số hợp lệ
            }
            
            Query query = session.createQuery("delete from ThanhVien where " + fieldName + " = :value");
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

    public Boolean updateThanhVien(int ID, ThanhVien tvNew)
    {
        ThanhVien tvOld= session.get(ThanhVien.class, ID);
        if(tvOld != null)
        {
            tvOld.setHoTen(tvNew.getHoTen());
            tvOld.setKhoa(tvNew.getKhoa());
            tvOld.setNganh(tvNew.getNganh());
            tvOld.setSdt(tvNew.getSdt());
            session.update(tvOld);
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
