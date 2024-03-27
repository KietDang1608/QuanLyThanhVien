import BUS.ThanhVienBUS;
import DAO.ThanhVienDAO;
import DAO.ThietBiDAO;
import DAO.ThongTinSDDAO;
import DAO.XuLyDAO;
import DTO.ThanhVien;
import DTO.ThietBi;
import DTO.ThongTinSD;
import DTO.XuLy;

public class hello {
    public static void main(String[] args) {
        // ThanhVienDAO dao = new ThanhVienDAO();
        // ThanhVien tv= new ThanhVien("tuan hung","CNTT","Toan",773456788);
        // dao.addThanhVien(tv);
        // dao= new ThanhVienDAO();
        // for (ThanhVien tv2 : dao.getData()){
        //     System.out.println(tv2.toString());
        // }
    //     ThietBiDAO dao= new ThietBiDAO();
    //     ThietBi tb= new ThietBi("máy code chay", "code 2000 dòng");
    //     dao.updateThietBi(1000011,tb);
    //     dao= new ThietBiDAO();
    //    for(ThietBi tb2:dao.getData())
    //    {
    //     System.out.println(tb2.toString());
    //    }
        // ThongTinSDDAO dao= new ThongTinSDDAO();
        // ThongTinSD tt= new ThongTinSD(1147483651, 1000001, null, null, null);
        // dao.updateTTSD(8,tt);
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
        for(ThanhVien tv2 : bu.getData()){
            System.out.println(tv2.toString());
        }
    }
}
