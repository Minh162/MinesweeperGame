package Bai1;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double s = 0, giaithua = 1;
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            giaithua *= i;
            s += giaithua / (i + i + 1);
        }
        //System.out.println(s);
        System.out.format("%.6f", s);
        sc.close();
    }
}
