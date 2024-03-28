package BUS;

import java.util.ArrayList;
import DAO.ThietBiDAO;
import DTO.ThietBi;

public class ThietBiBUS {
    static ArrayList<ThietBi> listTB;
    ThietBiDAO dao;

    public ArrayList<ThietBi> getData()
    {
        dao= new ThietBiDAO();
        listTB=dao.getData();
        return listTB;
    }

    public void addThietBi(ThietBi tb)
    {
        dao=new ThietBiDAO();
        dao.addThietBi(tb);
    }

    public Boolean delThietBi(int ID)
    {
        dao= new ThietBiDAO();
        if( dao.delThietBi(ID)) return true;
        return false;
        
    }

    public Boolean delThietBiByField(String fieldName,String value)
    {
        dao= new ThietBiDAO();
        if(dao.delThietBiByField(fieldName,value))return true;
        return false;
    }

    public Boolean updateThietBi(int ID,ThietBi tb)
    {
        dao= new ThietBiDAO();
        if(dao.updateThietBi(ID, tb))return true;
        return false;
    }

    public ThietBi getThanhVienByID(int ID)
    {
        dao= new ThietBiDAO();
        return dao.geThietBiByID(ID);
    }
}
