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
import GUI.ThanhVienGUI;

public class hello {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // ThanhVienDAO dao = new ThanhVienDAO();
       
        // ThanhVien tv= new ThanhVien("tuan hung222","CNTT","Toan",773456788);
        // dao.delThanhVien(1123330257);
        // dao= new ThanhVienDAO();
        // for (ThanhVien tv2 : dao.getData()){
        //     System.out.println(tv2.toString());
        // }

        // ThietBiDAO dao= new ThietBiDAO();
        ThietBiBUS bu= new ThietBiBUS();
        ThietBi tb=new ThietBi("micro nè", "đây là micro mới");
        bu.addThietBi(tb, "1", 2020);
        String excelFilePath = "ThietBi.xls";
        // bu.delThietBi(1000002);
        // for(ThietBi tb: bu.ExcelReader(excelFilePath))
        // {
        //     bu.addThietBi(tb,);
        // }

//        ThietBiBUS bu= new ThietBiBUS();
//        String excelFilePath = "ThietBi.xls";
//        // ThietBi tb= new ThietBi("máy code chay", "code 2000 dòng");
//        bu.delThietBi(1000002);
//        for(ThietBi tb: bu.getData())
//        {
//            System.out.println(tb.toString());
//        }
            ThanhVienGUI gui = new ThanhVienGUI();
      

        
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
