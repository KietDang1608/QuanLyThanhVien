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

    public void addXuLy(XuLy xl)
    {
        dao=new XuLyDAO();
        dao.addXuLy(xl);
    }

    public Boolean delXuLy(int ID)
    {
        dao= new XuLyDAO();
        if( dao.delXuLy(ID)) return true;
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
