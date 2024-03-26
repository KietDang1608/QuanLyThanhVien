package DTO;
import javax.persistence.*;
@Entity
@Table(name = "xuly")
public class XuLy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaXL")
    private int maXL;
    @Column(name = "MaTV")
    private int maTV;
    @Column(name = "HinhThucXL")
    private String hinhThucXL;
    @Column(name = "SoTien")
    private Integer soTien;
    @Column(name = "NgayXL")
    private String ngayXL;
    @Column(name = "TrangThaiXL")
    private int trangThaiXL;

    public XuLy(int maXL, int maTV, String hinhThucXL, Integer soTien, String ngayXL, int trangThaiXL) {
        this.maXL = maXL;
        this.maTV = maTV;
        this.hinhThucXL = hinhThucXL;
        this.soTien = soTien;
        this.ngayXL = ngayXL;
        this.trangThaiXL = trangThaiXL;
    }

    public XuLy() {
    }

    public int getMaXL() {
        return maXL;
    }

    public void setMaXL(int maXL) {
        this.maXL = maXL;
    }

    public int getMaTV() {
        return maTV;
    }

    public void setMaTV(int maTV) {
        this.maTV = maTV;
    }

    public String getHinhThucXL() {
        return hinhThucXL;
    }

    public void setHinhThucXL(String hinhThucXL) {
        this.hinhThucXL = hinhThucXL;
    }

    public int getSoTien() {
        return soTien;
    }

    public void setSoTien(Integer soTien) {
        this.soTien = soTien;
    }

    public String getNgayXL() {
        return ngayXL;
    }

    public void setNgayXL(String ngayXL) {
        this.ngayXL = ngayXL;
    }

    public int getTrangThaiXL() {
        return trangThaiXL;
    }

    public void setTrangThaiXL(int trangThaiXL) {
        this.trangThaiXL = trangThaiXL;
    }

    @Override
    public String toString() {
        return "XuLy{" +
                "maXL=" + maXL +
                ", maTV=" + maTV +
                ", hinhThucXL='" + hinhThucXL + '\'' +
                ", soTien=" + soTien +
                ", ngayXL='" + ngayXL + '\'' +
                ", trangThaiXL=" + trangThaiXL +
                '}';
    }
}
