package phanso;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Phanso phansoMax(ArrayList<Phanso> a) {
        Phanso max = a.get(0);
        for (Phanso i : a) {
            if (i.sosanh(max) == 1) {
                max = i;
            }
        }
        return max;
    }

    private static Phanso tongCacPhanso(ArrayList<Phanso> a) {
        Phanso tong = new Phanso(0, 1);
        for (Phanso i : a) {
            tong = tong.cong(i);
        }
        return tong;
    }

    private static void phansoKhongPhaiSoNguyen(ArrayList<Phanso> a) {
        for (Phanso i : a) {
            if (i.getTu() % i.getMau() != 0) {
                System.out.println("Phan so " + i.toString() + " khong phai so nguyen");
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Phanso> a = new ArrayList<>();
        try {
            File in = new File("src/phanso/Input.txt");
            Scanner sc = new Scanner(in);
            while (sc.hasNext()) {
                a.add(new Phanso(sc.nextInt(), sc.nextInt()));
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println(phansoMax(a));
        System.out.println(tongCacPhanso(a));
        phansoKhongPhaiSoNguyen(a);
    }
}
