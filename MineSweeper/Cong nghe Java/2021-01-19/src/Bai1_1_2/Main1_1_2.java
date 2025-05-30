package Bai1_1_2;

public class Main1_1_2 {
    private static long fibo(long n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        long a = 1, b = 1, dem = 2;
        while (dem != n) {
            long tam = b;
            b += a;
            a = tam;
            dem++;
        }
        return b;
    }

    private static long ganFibo(long n) {
        long a = 1, b = 1;
        for (; ; ) {
            long tam = b;
            b += a;
            a = tam;
            if (n >= a && n <= b) {
                if (n - a >= b - n) {
                    return b;
                }
                else {
                    return a;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(fibo(7));
        System.out.println(ganFibo(8));
    }
}
