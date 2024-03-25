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
        ThanhVienDAO dao = new ThanhVienDAO();
        for (ThanhVien tv : dao.getData()){
            System.out.println(tv.toString());
        }
        for (ThietBi tb: new ThietBiDAO().getData()){
            System.out.println(tb.toString());
        }
        for (ThongTinSD tt: new ThongTinSDDAO().getData()){
            System.out.println(tt.toString());
        }
        for (XuLy xl: new XuLyDAO().getData()){
            System.out.println(xl.toString());

        }
    }
}
