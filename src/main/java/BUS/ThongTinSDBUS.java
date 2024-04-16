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
        dao= new ThongTinSDDAO();
        dao.addTTSD(tt);
    }
    public void updateData(ThongTinSD tt){
        dao.updateTTSD(tt.getMaTT(),tt);
    }
    public void deleleData(ThongTinSD tt){
        dao.delTTSD(tt.getMaTT());
    }
    public ArrayList<ThongTinSD> findByID(String data){
        ArrayList<ThongTinSD> lstTT = new ArrayList<>();
        for (ThongTinSD tt : listThongTinSD){
            if (String.valueOf(tt.getMaTT()).contains(data)){
                lstTT.add(tt);
            }
        }
        return lstTT;
    }
    public ArrayList<ThongTinSD> findByIDThanhVien(String data){
        ArrayList<ThongTinSD> lstTT = new ArrayList<>();
        for (ThongTinSD tt : listThongTinSD){
            if (String.valueOf(tt.getMaTV()).contains(data)){
                lstTT.add(tt);
            }
        }
        return lstTT;
    }
    public ArrayList<ThongTinSD> findByIDThietBi(String data){
        ArrayList<ThongTinSD> lstTT = new ArrayList<>();
        for (ThongTinSD tt : listThongTinSD){
            if (String.valueOf(tt.getMaTB()).contains(data)){
                lstTT.add(tt);
            }
        }
        return lstTT;
    }

}
