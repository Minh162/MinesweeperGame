package Bai1_2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main1_2 {
    private static void tbcDuongKhongChiahet3(int[] a) {
        double tong = 0.0;
        int dem = 0;
        for (int i : a) {
            if (i % 3 != 0 && i > 0) {
                tong += i;
                dem++;
            }
        }
        if (dem != 0) {
            System.out.println("Trung binh cong cac so duong khong chia het cho 3 = " + (tong / dem));
        } else {
            System.out.println("Day khong co so duong chia het cho 3");
        }
    }

    private static int demPhantu(int[] a) {
        int dem = 0;
        for (int i : a) {
            if (i >= -5 && i <= 10) {
                dem++;
            }
        }
        return dem;
    }

    private static void maxChiahet5(int[] a) {
        Arrays.sort(a);
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] % 5 == 0) {
                System.out.println("Phan tu lon nhat chia het cho 5 = " + a[i]);
                return;
            }
        }
        System.out.println("Khong co phan tu chia het cho 5");
    }

    private static void sapxepAbsTangdan(int[] A) {
        int[] a = A.clone();
        for (int i = 0; i < a.length; i++) {
            int vitrimin = i;
            for (int j = i; j < a.length; j++) {
                if (Math.abs(a[j]) < Math.abs(a[vitrimin])) {
                    vitrimin = j;
                }
            }
            int tam = a[i];
            a[i] = a[vitrimin];
            a[vitrimin] = tam;
        }
        in(a);
    }

    private static void loaiChiahet5NhungKhongChiahet3(int[] a) {
        ArrayList<Integer> b = new ArrayList<>();
        for (int i : a) {
            if (i % 5 != 0 || (i % 5 == 0 && i % 3 == 0)) {
                b.add(i);
            }
        }
        int[] A = new int[b.size()];
        for (int i = 0; i < A.length; i++) {
            A[i] = b.get(i);
        }
        a = A;
        in(a);
    }

    private static void in(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {3, 4, -2, 5, 1, -1};
    }
}
