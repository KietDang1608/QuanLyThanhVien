package BUS;

import DTO.ThanhVien;
import DTO.ThietBi;
import DTO.ThongTinSD;
import DTO.XuLy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ThongKeBUS {

    public ThongKeBUS(){}
    //Lấy danh sách thành viên vào khu vực học tập theo thời gian
    public ArrayList<ThongTinSD> getListThanhVienByTime(String startDate, String endDate, String startTime, String endTime){
        ThongTinSDBUS ttsdBUS = new ThongTinSDBUS();
        //Date : yyyy-mm-dd
        //Time : hh-mm-ss
        ArrayList<ThongTinSD> lstFound = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String s_datetime1 = (startDate + " " + startTime);
        String s_datetime2 = endDate + " " + endTime;
        LocalDateTime datetimeStart = LocalDateTime.parse(s_datetime1,formatter);
        LocalDateTime datetimeEnd =LocalDateTime.parse(s_datetime2,formatter);
        for (ThongTinSD tt: ttsdBUS.getListThongTinSD()){
            LocalDateTime dt = LocalDateTime.parse(tt.getTgVao(),formatter);
            if ((dt.isEqual(datetimeStart) || dt.isAfter(datetimeStart)) && (dt.isEqual(datetimeEnd) || dt.isBefore(datetimeEnd))){
                lstFound.add(tt);
            }
        }
        return lstFound;
    }
    public ArrayList<ThongTinSD> getDSTVByStart(String startDate, String startTime){
        ThongTinSDBUS ttsdBUS = new ThongTinSDBUS();
        //Date : yyyy-mm-dd
        //Time : hh-mm-ss
        ArrayList<ThongTinSD> lstFound = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String s_datetime = (startDate + " " + startTime);

        LocalDateTime datetimeStart = LocalDateTime.parse(s_datetime,formatter);
        for (ThongTinSD tt: ttsdBUS.getListThongTinSD()){
            LocalDateTime dt = LocalDateTime.parse(tt.getTgVao(),formatter);
            if (dt.isEqual(datetimeStart) || dt.isAfter(datetimeStart)){
                lstFound.add(tt);
            }
        }
        return lstFound;
    }
    public ArrayList<ThongTinSD> getDSTVByEnd(String endDate, String endTime){
        ThongTinSDBUS ttsdBUS = new ThongTinSDBUS();
        //Date : yyyy-mm-dd
        //Time : hh-mm-ss
        ArrayList<ThongTinSD> lstFound = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String s_datetime = (endDate + " " + endTime);

        LocalDateTime datetimeEnd = LocalDateTime.parse(s_datetime,formatter);
        for (ThongTinSD tt: ttsdBUS.getListThongTinSD()){
            LocalDateTime dt = LocalDateTime.parse(tt.getTgVao(),formatter);
            if (dt.isEqual(datetimeEnd) || dt.isBefore(datetimeEnd)){
                lstFound.add(tt);
            }
        }
        return lstFound;
    }
    //Thong ke danh sach thanh vien vao khu vuc hoc tap theo khoa
    public ArrayList<ThongTinSD> getDSThanhVienByKhoa(String khoa){
        ThongTinSDBUS ttsdBUS = new ThongTinSDBUS();
        ThanhVienBUS tvBUS= new ThanhVienBUS();
        ArrayList<ThongTinSD> lstFound = new ArrayList<>();
        for (ThongTinSD tt: ttsdBUS.getListThongTinSD()){
            ThanhVien tv = tvBUS.getThanhVienByID(tt.getMaTV());
            if (tv.getKhoa().contains(khoa)){
                lstFound.add(tt);
            }
        }
        return lstFound;
    }
    // Thong ke danh sach thanh vien vao khu vuc theo nganh
    public ArrayList<ThongTinSD> getDSTVBYNganh(String nganh){
        ThongTinSDBUS ttsdBUS = new ThongTinSDBUS();
        ThanhVienBUS tvBUS = new ThanhVienBUS();
        ArrayList<ThongTinSD> lstFound = new ArrayList<>();
        for (ThongTinSD tt: ttsdBUS.getListThongTinSD()){
            ThanhVien tv = tvBUS.getThanhVienByID(tt.getMaTV());
            if (tv.getNganh().contains(nganh)){
                lstFound.add(tt);
            }
        }
        return lstFound;
    }
    //Thong ke vi pham
    //Thong ke vi pham da duoc xu li
    public ArrayList<XuLy> getDSDaXuLy(){
        XuLyBUS  xlBUS = new XuLyBUS();
        ArrayList<XuLy> dsDaXuLy = new ArrayList<>();
        for (XuLy xl : xlBUS.getData()){
            if (xl.getTrangThaiXL() == 1){
                dsDaXuLy.add(xl);
            }
        }
        return dsDaXuLy;
    }
    public ArrayList<XuLy> getDSChuaXuLy(){
        XuLyBUS  xlBUS = new XuLyBUS();
        ArrayList<XuLy> dsChuaXL = new ArrayList<>();
        for (XuLy xl : xlBUS.getData()){
            if (xl.getTrangThaiXL() == 0){
                dsChuaXL.add(xl);
            }
        }
        return dsChuaXL;
    }
    public static void main(String[] args) {
        ThongKeBUS tkbus = new ThongKeBUS();
//        for (ThongTinSD tt : tkbus.getListThanhVienByTime("2024-04-01","2024-04-01","17:00:00","19:00:00")){
//            System.out.println(tt.toString());
//        }
        ThanhVienBUS tvBUS = new ThanhVienBUS();
        for (ThongTinSD tt: tkbus.getDSThanhVienByKhoa("CNTT")){
            System.out.println(tt.toString());
            System.out.println(tvBUS.getThanhVienByID(tt.getMaTV()).getKhoa());
        }
    }
}
