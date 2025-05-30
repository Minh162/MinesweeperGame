package Bai2_2;

public class Main2_2 {
    private static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }

    private static boolean check(String[] s) {
        for (String i : s) {
            if (!isNumber(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] s = "   3.45 4   -2   -5.66   ".trim().split("\\s+");
        if (check(s)) {
            System.out.println(true + ", co " + s.length + " so");
        } else {
            System.out.println(false);
        }
    }
}
