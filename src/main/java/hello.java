import java.io.FileNotFoundException;
import java.io.IOException;

import BUS.ThanhVienBUS;
import BUS.ThietBiBUS;
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
        // String excelFilePath = "ThanhVien.xls";
        // ThanhVien tv= new ThanhVien("tuan hung222","CNTT","Toan","073456788","datdat","dat@gmail.com");
        // ThanhVienBUS bu= new ThanhVienBUS();
        // try {
        //     bu.writeExcel(bu.getData(),excelFilePath);
        // } catch (IOException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        
        // dao= new ThanhVienDAO();
        // try {
        //     for (ThanhVien tv2 : bu.ExcelReader(excelFilePath)){
        //         System.out.println(tv2.toString());
        //     }
        // } catch (FileNotFoundException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // } catch (IOException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        ThietBiDAO dao= new ThietBiDAO();
        ThietBiBUS bu= new ThietBiBUS();
        for(ThietBi tb: bu.ThongKeDangMuonTheoTG("2024-03-01 19:39:21", "2024-04-01 19:39:21"))
        {
            System.out.println(tb.toString());
        }
        // String excelFilePath = "ThietBi.xls";
        // ThietBi tb= new ThietBi("máy code chay", "code 2000 dòng");
        
        // for(ThietBi tb: bu.getData())
        // {
        //     System.out.println(tb.toString());
        // }
        
    //     } catch (IOException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }
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

        // ThanhVienBUS bu= new ThanhVienBUS();
        // String excelFilePath = "ThietBi.xls";
         
        // try {
        //     for(ThanhVien tv2 : bu.ExcelReader(excelFilePath)){
        //         System.out.println(tv2.toString());
        //         bu.addThanhVien(tv2);
        //     }
            
        // } catch (IOException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        // for(ThanhVien tv2 : bu.getData()){
        //     System.out.println(tv2.toString());
        // }
    }
}
