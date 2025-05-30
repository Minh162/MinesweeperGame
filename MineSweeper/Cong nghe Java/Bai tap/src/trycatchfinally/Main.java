package trycatchfinally;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static void createRandomArrayList(ArrayList<Integer>a) {
        int n = new Random().nextInt(101);
        while (n-- > 0) {
            a.add(new Random().nextInt(201) - 100);
        }
    }

    private static void inputNumber(ArrayList<Integer>a) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = sc.nextInt();
            if (n > a.size()) {
                throw new ArrayIndexOutOfBoundsException("Tran mang");
            }
            System.out.println(a.get(n));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            sc.close();
        }
    }

    private static void run() {
        ArrayList<Integer>a = new ArrayList<>();
        createRandomArrayList(a);
        inputNumber(a);
    }

    public static void main(String[] args) {
        run();
    }
}
