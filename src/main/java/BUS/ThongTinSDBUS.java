package BUS;

import DAO.ThongTinSDDAO;
import DTO.ThongTinSD;

import java.util.ArrayList;
import java.util.Objects;

public class ThongTinSDBUS {
    private ArrayList<ThongTinSD> listThongTinSD;
    private ThongTinSDDAO dao = new ThongTinSDDAO();
    public ThongTinSDBUS(){
        listThongTinSD = dao.getData();
    }
    public ArrayList<ThongTinSD> getListThongTinSD(){
        return listThongTinSD;
    }
    public ArrayList<ThongTinSD> getData(){

        return dao.getData();
    }
    public void addData(ThongTinSD tt){
        dao= new ThongTinSDDAO();
        dao.addTTSD(tt);
    }
    public ThongTinSD getTTChuaMuonByMaTB(int matb){
        for (ThongTinSD tt : getListThongTinSD()){
            if (tt.getMaTB() == matb && tt.getTgTra() == null){
                return tt;
            }
        }
        return null;
    }
    public void updateData(ThongTinSD tt){
        dao = new ThongTinSDDAO();
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
    public boolean checkDangMuon(int id){
        for (ThongTinSD tt : getListThongTinSD()){
            if (tt.getMaTB() == id){
                System.out.println(tt.getTgTra());
                if (tt.getTgTra() == null)
                    return false;
            }
        }
        return true;
    }
}
