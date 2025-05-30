package Phanso;

public class Phanso {
    private int tu, mau;

    public Phanso() {
    }

    public Phanso(int tu, int mau) {
        this.tu = tu;
        this.mau = mau;
    }

    public static Phanso tong(Phanso a, Phanso b) {
        Phanso tong = new Phanso();

        
        return tong;
    }

    public int getTu() {
        return tu;
    }

    public int getMau() {
        return mau;
    }

    public void setTu(int tu) {
        this.tu = tu;
    }

    public void setMau(int mau) {
        this.mau = mau;
    }

    @Override
    public String toString() {
        return "Phanso{" +
                "tu=" + tu +
                ", mau=" + mau +
                '}';
    }
}
