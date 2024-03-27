package DAO;

import DTO.ThanhVien;
import DTO.ThongTinSD;
import HibernateUtil.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ThongTinSDDAO {
    private SessionFactory factory;
    private Session session;
    public ThongTinSDDAO()
    {
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }
    public ArrayList<ThongTinSD> getData()
    {
        List<ThongTinSD> listThongTinSD = new ArrayList<>();
        listThongTinSD =session.createQuery("FROM ThongTinSD").list();
        session.getTransaction().commit();
        return new ArrayList<>(listThongTinSD);
    }

    public ThongTinSD geThongTinSDByID(int ID)
    {
        ThongTinSD tt= session.get(ThongTinSD.class, ID);
        session.close();
        return tt;
    }

    public void addTTSD(ThongTinSD tt)
    {
        session.save(tt);
        session.getTransaction().commit();
        session.close();
    }

    public Boolean delTTSD(int ID)
    {
        ThongTinSD tt = session.get(ThongTinSD.class, ID);
        if (tt != null) 
        {
            session.delete(tt);
            session.getTransaction().commit();
            session.close();
            return true;
        } 
        else 
        {
            System.out.println("Không tìm thấy ThongTinSD có ID = " + ID);
            session.getTransaction().commit();
            session.close();
            return false;
        }
    }

    public boolean delTTSDByField(String fieldName, String value) {
        try {
            int intValue;
            try {
                // Thử chuyển đổi giá trị từ String sang int
                intValue = Integer.parseInt(value);
            } catch (NumberFormatException ex) {
                // Nếu không thể chuyển đổi, giữ nguyên kiểu dữ liệu là String
                intValue = -1; // hoặc một giá trị khác biểu thị rằng không có giá trị số hợp lệ
            }
            
            Query query = session.createQuery("delete from ThongTinSD where " + fieldName + " = :value");
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
    

    public Boolean updateTTSD(int ID, ThongTinSD ttNew)
    {
        ThongTinSD ttOld= session.get(ThongTinSD.class, ID);
        if(ttOld != null)
        {
            ttOld.setMaTB(ttNew.getMaTB());
            ttOld.setMaTV(ttNew.getMaTV());
            ttOld.setTgMuon(ttNew.getTgMuon());
            ttOld.setTgTra(ttNew.getTgTra());
            ttOld.setTgVao(ttNew.getTgVao());
            session.update(ttOld);
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
