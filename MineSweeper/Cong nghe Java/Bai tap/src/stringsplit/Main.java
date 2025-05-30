package stringsplit;

import java.util.Scanner;

public class Main {
    private static void run() {
        String[] s = new Scanner(System.in).nextLine().trim().split("\\s++");
        try {
            for (String i : s) {
                Double.parseDouble(i);
            }
            System.out.println(s.length);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("String khong thoa man");
        }
    }

    public static void main(String[] args) {
        run();
    }
}
