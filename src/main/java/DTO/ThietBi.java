package DTO;

public class ThietBi {
    private int maTB;
    private String tenTB;
    private String moTa;

    public ThietBi(int maTB, String tenTB, String moTa) {
        this.maTB = maTB;
        this.tenTB = tenTB;
        this.moTa = moTa;
    }

    public ThietBi() {
    }

    public int getMaTB() {
        return maTB;
    }

    public void setMaTB(int maTB) {
        this.maTB = maTB;
    }

    public String getTenTB() {
        return tenTB;
    }

    public void setTenTB(String tenTB) {
        this.tenTB = tenTB;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "ThietBi{" +
                "maTB=" + maTB +
                ", tenTB='" + tenTB + '\'' +
                ", moTa='" + moTa + '\'' +
                '}';
    }
}
