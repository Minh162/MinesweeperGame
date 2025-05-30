package sophuc;

public class Sophuc {
    private double thuc, ao;

    public Sophuc() {
        thuc = 1.0;
        ao = -1.0;
    }

    public Sophuc(double thuc, double ao) {
        this.thuc = thuc;
        this.ao = ao;
    }

    public Sophuc cong(Sophuc obj) {
        return new Sophuc(thuc + obj.thuc, ao + obj.ao);
    }

    public double modulus() {
        return Math.sqrt(thuc * thuc + ao * ao);
    }

    public double getThuc() {
        return thuc;
    }

    public void setThuc(double thuc) {
        this.thuc = thuc;
    }

    public double getAo() {
        return ao;
    }

    public void setAo(double ao) {
        this.ao = ao;
    }

    @Override
    public String toString() {
        return thuc + " + " + ao + "i";
    }
}
