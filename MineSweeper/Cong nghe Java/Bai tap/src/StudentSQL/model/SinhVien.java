package StudentSQL.model;

public class SinhVien {
    private String MaSV;
    private String Ten;
    private String MaSVQuanLy;

    public SinhVien(String maSV, String ten, String maSVQuanLy) {
        MaSV = maSV;
        Ten = ten;
        MaSVQuanLy = maSVQuanLy;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String maSV) {
        MaSV = maSV;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getMaSVQuanLy() {
        return MaSVQuanLy;
    }

    public void setMaSVQuanLy(String maSVQuanLy) {
        MaSVQuanLy = maSVQuanLy;
    }

    @Override
    public String toString() {
        return "{MaSV: " + MaSV + ", Ten: " + Ten + ", MaSVQuanLy: " + MaSVQuanLy + "}";
    }
}
