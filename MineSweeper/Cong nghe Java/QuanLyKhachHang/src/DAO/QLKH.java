package DAO;

public class QLKH {
    private int maKH;
    private String tenKH;
    private String SDT;

    public QLKH() {
    }
    
    public QLKH(int maKH, String tenKH, String SDT) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.SDT = SDT;
    }
    
    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public int getMaKH() {
        return maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getSDT() {
        return SDT;
    }

}
