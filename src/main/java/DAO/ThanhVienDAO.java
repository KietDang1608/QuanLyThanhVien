package DAO;

import DTO.ThanhVien;
import HibernateUtil.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ThanhVienDAO {

    private SessionFactory factory;
    private Session session;

    public ThanhVienDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }

    public ArrayList<ThanhVien> getData() {
        List<ThanhVien> listThanhVien = new ArrayList<>();
        listThanhVien = session.createQuery("FROM ThanhVien").list();
        session.getTransaction().commit();
        // Chuyển đổi List thành ArrayList nếu cần
        return new ArrayList<>(listThanhVien);
    }

    public ThanhVien getThanhVienByID(int ID) {
        ThanhVien tv = session.get(ThanhVien.class, ID);
        session.close();
        return tv;
    }

    public void addThanhVien(ThanhVien tv) {
        session.save(tv);
        session.getTransaction().commit();
        session.close();
    }

    public Boolean delThanhVien(int ID) {
        ThanhVien tv = session.get(ThanhVien.class, ID);
        if (tv != null) {
            Query query = session.createQuery("delete from XuLy where  MaTV = :value");
            query.setParameter("value", ID);
            Query query2 = session.createQuery("delete from ThongTinSD where  MaTV = :value");
            query2.setParameter("value", ID);
            query.executeUpdate();
            query2.executeUpdate();
            session.delete(tv);
            session.getTransaction().commit();
            session.close();
            return true;
        } else {
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

    public Boolean updateThanhVien(int ID, String hoTen, String khoa, String nganh, String sdt, String password, String email) {
        Transaction transaction = null;
        try {
            if (!session.isOpen()) {
                factory.openSession();
            }
            // Check if there's an active transaction
        if (session.getTransaction() != null && session.getTransaction().isActive()) {
            // Commit the active transaction
            session.getTransaction().commit();
        }
            transaction = session.beginTransaction();

            ThanhVien tvOld = session.get(ThanhVien.class, ID);

            if (tvOld != null) {
                tvOld.setHoTen(hoTen);
                tvOld.setKhoa(khoa);
                tvOld.setNganh(nganh);
                tvOld.setSdt(sdt);
                tvOld.setPassword(password);
                tvOld.setEmail(email);
                session.update(tvOld);
                transaction.commit();
                return true;
            } else {
                System.out.println("Không tìm thấy thành viên cần sửa");
                return false;
            }
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
            return false;
        }
    }

    public void ThemExcel() {

    }

    public static void main(String[] args) {
        ThanhVienDAO thanhVienDAO = new ThanhVienDAO();
        ArrayList<ThanhVien> danhSachThanhVien = thanhVienDAO.getData();

        for (ThanhVien tv : danhSachThanhVien) {
            System.out.println("Mã TV: " + tv.getMaTV());
            System.out.println("Họ tên: " + tv.getHoTen());
            System.out.println("Khoa: " + tv.getKhoa());
            System.out.println("Ngành: " + tv.getNganh());
            System.out.println("SĐT: " + tv.getSdt());
            System.out.println("----------------------------------------");
        }
    }
}
