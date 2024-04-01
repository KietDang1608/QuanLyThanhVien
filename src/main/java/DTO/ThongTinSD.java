package DTO;
import javax.persistence.*;
@Entity
@Table(name = "thongtinsd")
public class ThongTinSD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaTT")
    private int maTT;
    @Column(name = "MaTV")
    private int maTV;
    @Column(name = "MaTB")
    private Integer maTB;
    @Column(name = "TGVao")
    private String tgVao;
    @Column(name = "TGMuon")
    private String tgMuon;
    @Column(name = "TGTra")
    private String tgTra;
    @Column(name = "TGDatcho")
    private String tgDatcho;

    public ThongTinSD(int maTV, Integer maTB, String tgVao, String tgMuon, String tgTra,String tgDatcho) {
        this.maTV = maTV;
        this.maTB = maTB;
        this.tgVao = tgVao;
        this.tgMuon = tgMuon;
        this.tgTra = tgTra;
        this.tgDatcho=tgDatcho;
    }

    public ThongTinSD() {
    }

    public int getMaTT() {
        return maTT;
    }

    public void setMaTT(int maTT) {
        this.maTT = maTT;
    }

    public int getMaTV() {
        return maTV;
    }

    public void setMaTV(int maTV) {
        this.maTV = maTV;
    }

    public int getMaTB() {
        return maTB;
    }

    public void setMaTB(Integer maTB) {
        this.maTB = maTB;
    }

    public String getTgVao() {
        return tgVao;
    }

    public void setTgVao(String tgVao) {
        this.tgVao = tgVao;
    }

    public String getTgMuon() {
        return tgMuon;
    }

    public void setTgMuon(String tgMuon) {
        this.tgMuon = tgMuon;
    }

    public String getTgTra() {
        return tgTra;
    }

    public void setTgTra(String tgTra) {
        this.tgTra = tgTra;
    }

    public String getTGDatcho()
    {
        return tgDatcho;
    }

    public void setTGDatcho(String tgDatcho)
    {
        this.tgDatcho=tgDatcho;
    }

    @Override
    public String toString() {
        return "ThongTinSD{" +
                "maTT=" + maTT +
                ", maTV=" + maTV +
                ", maTB=" + maTB +
                ", tgVao='" + tgVao + '\'' +
                ", tgMuon='" + tgMuon + '\'' +
                ", tgTra='" + tgTra + '\'' +
                ", tgDatcho='" + tgDatcho + '\'' +
                '}';
    }
}
