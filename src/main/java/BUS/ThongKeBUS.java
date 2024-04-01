package BUS;

import DTO.ThietBi;

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
    public void getListThanhVienByTime(String startDate, String endDate, String startTime, String endTime){
        //Date : yyyy-mm-dd
        //Time : hh-mm-ss
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String s_datetime1 = (startDate + " " + startTime);
        String s_datetime2 = endDate + " " + endTime;
        LocalDateTime datetimeStart = LocalDateTime.parse(s_datetime1,formatter);
        LocalDateTime datetimeEnd =LocalDateTime.parse(s_datetime2,formatter);

    }

    public static void main(String[] args) {
        ThongKeBUS tkbus = new ThongKeBUS();
        tkbus.getListThanhVienByTime("2024-04-01","2024-04-01","00:00:00","00:00:00");
    }
}
