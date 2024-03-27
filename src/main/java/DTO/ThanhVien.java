package DTO;
import javax.persistence.*;
@Entity
@Table(name = "thanhvien")

public class ThanhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaTV")
    private int maTV;
    @Column(name = "HoTen")
    private String hoTen;
    @Column(name = "Khoa")
    private String khoa;
    @Column(name = "Nganh")
    private String nganh;
    @Column(name = "SDT")
    private int sdt;

    public ThanhVien(String hoTen, String khoa, String nganh, int sdt) {
        this.hoTen = hoTen;
        this.khoa = khoa;
        this.nganh = nganh;
        this.sdt = sdt;
    }

    public ThanhVien() {
    }

    public int getMaTV() {
        return maTV;
    }

    public void setMaTV(int maTV) {
        this.maTV = maTV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return "ThanhVien{" +
                "maTV=" + maTV +
                ", hoTen='" + hoTen + '\'' +
                ", khoa='" + khoa + '\'' +
                ", nganh='" + nganh + '\'' +
                ", sdt=" + sdt +
                '}';
    }
}
