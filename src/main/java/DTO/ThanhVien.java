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
    private String sdt;
    @Column(name = "Password")
    private String password;
    @Column(name = "Email")
    private String email;

    public ThanhVien(String hoTen, String khoa, String nganh, String sdt, String password, String email) {
        this.hoTen = hoTen;
        this.khoa = khoa;
        this.nganh = nganh;
        this.sdt = sdt;
        this.password = password;
        this.email = email;
    }

    public ThanhVien(int id, String hoTen, String khoa, String nganh, String sdt, String password, String email) {
        this.hoTen = hoTen;
        this.khoa = khoa;
        this.nganh = nganh;
        this.sdt = sdt;
        this.email = email;
    }

    public ThanhVien(String hoTen, String khoa, String nganh, String sdt) {
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ThanhVien{"
                + "maTV=" + maTV
                + ", hoTen='" + hoTen + '\''
                + ", khoa='" + khoa + '\''
                + ", nganh='" + nganh + '\''
                + ", sdt=" + sdt
                + ", password=" + password
                + ", email=" + email
                + '}';
    }
}
