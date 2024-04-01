package BUS;

import DTO.ThietBi;
import DTO.ThongTinSD;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ThongKeBUS {
    private ThongTinSDBUS ttsdBUS = new ThongTinSDBUS();
    private  ThanhVienBUS tvBUS = new ThanhVienBUS();
    private XuLyBUS xlBUS  = new XuLyBUS();
    private ThietBiBUS tbBUS = new ThietBiBUS();

    public ThongKeBUS(){}
    //Lấy danh sách thành viên vào khu vực học tập theo thời gian
    public ArrayList<ThongTinSD> getListThanhVienByTime(String startDate, String endDate, String startTime, String endTime){
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
    //Thong ke danh sach thanh vien vao khu vuc hoc tap theo khoa
    public ArrayList<ThongTinSD> getDSThanhVienByKhoa()
    public static void main(String[] args) {
        ThongKeBUS tkbus = new ThongKeBUS();
        for (ThongTinSD tt : tkbus.getListThanhVienByTime("2024-04-01","2024-04-01","17:00:00","19:00:00")){
            System.out.println(tt.toString());
        }
    }
}
