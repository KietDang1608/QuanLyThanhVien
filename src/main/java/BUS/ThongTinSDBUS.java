package BUS;

import java.util.ArrayList;
import DAO.ThongTinSDDAO;
import DTO.ThongTinSD;

public class ThongTinSDBUS {
    static ArrayList<ThongTinSD> listTT;
    ThongTinSDDAO dao;

    public ArrayList<ThongTinSD> getData()
    {
        dao= new ThongTinSDDAO();
        listTT=dao.getData();
        return listTT;
    }

    public void addTTSD(ThongTinSD tt)
    {
        dao=new ThongTinSDDAO();
        dao.addTTSD(tt);
    }

    public Boolean delTTSD(int ID)
    {
        dao= new ThongTinSDDAO();
        if( dao.delTTSD(ID)) return true;
        return false;
        
    }

    public Boolean delTTSDByField(String fieldName,String value)
    {
        dao= new ThongTinSDDAO();
        if(dao.delTTSDByField(fieldName, value)) return true;
        return false;
    }

    public Boolean updateTTSD(int ID,ThongTinSD tt)
    {
        dao= new ThongTinSDDAO();
        if(dao.updateTTSD(ID, tt))return true;
        return false;
    }

    public ThongTinSD getTTSDByID(int ID)
    {
        dao= new ThongTinSDDAO();
        return dao.geThongTinSDByID(ID); 
    }
}
