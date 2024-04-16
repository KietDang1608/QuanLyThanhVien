package BUS;

import java.util.ArrayList;
import DAO.XuLyDAO;
import DTO.XuLy;

public class XuLyBUS {
    static ArrayList<XuLy> listXL;
    XuLyDAO dao;

    public ArrayList<XuLy> getData()
    {
        dao= new XuLyDAO();
        listXL=dao.getData();
        return listXL;
    }

    public boolean addXuLy(XuLy xl)
    {
        dao=new XuLyDAO();
        if( dao.addXuLy(xl)) return true;
        return false;
    }

    public Boolean delXuLy(int ID)
    {
        dao= new XuLyDAO();
        if( dao.delXuLy(ID)) return true;
        return false;
        
    }
    public boolean checkTVViPham(int idTV){
        for (XuLy xl : getData()){
            if (xl.getMaTV() == idTV)
                if (xl.getTrangThaiXL() == 0)
                    return true;
        }
        return false;
    }
    public Boolean delXuLyByField(String fieldName,String value)
    {
        dao =new XuLyDAO();
        if(dao.delXuLyByField(fieldName, value)) return true;
        return false;
    }

    public Boolean updateXuLy(int ID,XuLy xl)
    {
        dao= new XuLyDAO();
        if(dao.updateXuLy(ID, xl))return true;
        return false;
    }

    public XuLy getXuLyByID(int ID)
    {
        dao= new XuLyDAO();
        return dao.geXuLyByID(ID); 
    }
}
