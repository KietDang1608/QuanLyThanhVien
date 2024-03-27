package BUS;

import DAO.ThongTinSDDAO;
import DTO.ThongTinSD;

import java.util.ArrayList;

public class ThongTinSDBUS {
    private ArrayList<ThongTinSD> listThongTinSD = new ArrayList<>();
    private ThongTinSDDAO dao = new ThongTinSDDAO();
    public ThongTinSDBUS(){
        listThongTinSD = dao.getData();
    }
    public ArrayList<ThongTinSD> getListThongTinSD(){
        return listThongTinSD;
    }
    public void addData(ThongTinSD tt){
        dao.addTTSD(tt);
    }
    public void updateData(ThongTinSD tt){
        dao.updateTTSD(tt.getMaTT(),tt);
    }
    public void deleleData(ThongTinSD tt){
        dao.delTTSD(tt.getMaTT());
    }
}
