package BUS;

import java.util.ArrayList;

import DAO.ThanhVienDAO;
import DTO.ThanhVien;

public class ThanhVienBUS {
    static ArrayList<ThanhVien> listTV;
    ThanhVienDAO dao;

    public ArrayList<ThanhVien> getData()
    {
        dao= new ThanhVienDAO();
        listTV=dao.getData();
        return listTV;
    }

    public void addThanhVien(ThanhVien tv)
    {
        dao=new ThanhVienDAO();
        dao.addThanhVien(tv);
    }

    public Boolean delThanhVien(int ID)
    {
        dao= new ThanhVienDAO();
        if( dao.delThanhVien(ID)) return true;
        return false;
        
    }

    public Boolean updateThanhVien(int ID,ThanhVien tv)
    {
        dao= new ThanhVienDAO();
        if(dao.updateThanhVien(ID, tv))return true;
        return false;
    }

    public ThanhVien getThanhVienByID(int ID)
    {
        dao= new ThanhVienDAO();
        return dao.getThanhVienByID(ID);
    }
}
