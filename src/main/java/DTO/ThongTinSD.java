package DTO;

public class ThongTinSD {
    private int maTT;
    private int maTV;
    private Integer maTB;
    private String tgVao;
    private String tgMuon;
    private String tgTra;

    public ThongTinSD(int maTT, int maTV, Integer maTB, String tgVao, String tgMuon, String tgTra) {
        this.maTT = maTT;
        this.maTV = maTV;
        this.maTB = maTB;
        this.tgVao = tgVao;
        this.tgMuon = tgMuon;
        this.tgTra = tgTra;
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

    @Override
    public String toString() {
        return "ThongTinSD{" +
                "maTT=" + maTT +
                ", maTV=" + maTV +
                ", maTB=" + maTB +
                ", tgVao='" + tgVao + '\'' +
                ", tgMuon='" + tgMuon + '\'' +
                ", tgTra='" + tgTra + '\'' +
                '}';
    }
}
