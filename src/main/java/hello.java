import java.io.FileNotFoundException;
import java.io.IOException;

import BUS.ThanhVienBUS;
import DAO.ThanhVienDAO;
import DAO.ThietBiDAO;
import DAO.ThongTinSDDAO;
import DAO.XuLyDAO;
import DTO.ThanhVien;
import DTO.ThietBi;
import DTO.ThongTinSD;
import DTO.ThongTinSD;
import DTO.XuLy;

public class hello {
    public static void main(String[] args) {
        // ThanhVienDAO dao = new ThanhVienDAO();
        // ThanhVien tv= new ThanhVien("tuan hung222","CNTT","Toan",773456788);
        // dao.delThanhVienByField("SDT", Integer.toString(773456788));
        // dao= new ThanhVienDAO();
        // for (ThanhVien tv2 : dao.getData()){
        //     System.out.println(tv2.toString());
        // }
    //     ThietBiDAO dao= new ThietBiDAO();
    //     ThietBi tb= new ThietBi("máy code chay", "code 2000 dòng");
    //     dao.delThietBiByField("TenTB", "máy code chay");
    //     dao= new ThietBiDAO();
    //    for(ThietBi tb2:dao.getData())
    //    {
    //     System.out.println(tb2.toString());
    //    }
        // ThongTinSDDAO dao= new ThongTinSDDAO();
        // ThongTinSD tt= new ThongTinSD(1147483651, 1000001, null, null, null);
        // dao.delTTSDByField("MaTV",Integer.toString(1147483651));
        // for (ThongTinSD tt2: new ThongTinSDDAO().getData()){
        //     System.out.println(tt2.toString());
        // }
        // XuLyDAO dao= new XuLyDAO();
        // XuLy xl2= new XuLy(1121530087,"hello", 20002002, null);
        // dao.addXuLy(xl2);
        // for (XuLy xl: new XuLyDAO().getData()){
        //     System.out.println(xl.toString());

        // }

        ThanhVienBUS bu= new ThanhVienBUS();
        String excelFilePath = "NiceJavaBooks.xls";
         
        try {
            for(ThanhVien tv2 : bu.ExcelReader(excelFilePath)){
                System.out.println(tv2.toString());
                bu.addThanhVien(tv2);
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // for(ThanhVien tv2 : bu.getData()){
        //     System.out.println(tv2.toString());
        // }
    }
}
