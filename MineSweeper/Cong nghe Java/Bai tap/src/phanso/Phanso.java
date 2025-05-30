package phanso;

public class Phanso {
    private int tu, mau;

    public Phanso() {
    }

    public Phanso(int tu, int mau) {
        if (mau > 0) {
            this.tu = tu;
            this.mau = mau;
        }
        else if (mau < 0){
            this.tu = -tu;
            this.mau = -mau;
        }
        else {
            System.out.println("Khong ton tai phan so " + tu + "/" + mau);
            System.exit(-1);
        }
    }

    public Phanso cong(Phanso obj) {
        int lcm = lcm(mau, obj.mau);
        return new Phanso(tu * (lcm / mau) + obj.tu * (lcm / obj.mau), lcm).rutgon();
    }

    public Phanso tru(Phanso obj) {
        int lcm = lcm(mau, obj.mau);
        return new Phanso(tu * (lcm / mau) - obj.tu * (lcm / obj.mau), lcm).rutgon();
    }

    public Phanso nhan(Phanso obj) {
        return new Phanso(tu * obj.tu, mau * obj.mau).rutgon();
    }

    public Phanso chia(Phanso obj) {
        return new Phanso(tu * obj.mau, mau * obj.tu).rutgon();
    }

    public int sosanh(Phanso obj) {
        Phanso hieu = this.tru(obj);
        double dhieu = (double)hieu.tu / (double)hieu.mau;
        return Double.compare(dhieu, 0.0);
    }

    public Phanso rutgon() {
        if (tu == 0) {
            return this;
        }
        int gcd = gcd(Math.abs(tu), mau);
        return new Phanso(tu / gcd, mau / gcd);
    }

    private int gcd(int a, int b) {
        while (true) {
            if (a > b) {
                a -= b;
            }
            else if (a < b) {
                b -= a;
            }
            else {
                return a;
            }
        }
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public int getTu() {
        return tu;
    }

    public void setTu(int tu) {
        this.tu = tu;
    }

    public int getMau() {
        return mau;
    }

    public void setMau(int mau) {
        this.mau = mau;
    }

    @Override
    public String toString() {
        return tu + "/" + mau;
    }
}
