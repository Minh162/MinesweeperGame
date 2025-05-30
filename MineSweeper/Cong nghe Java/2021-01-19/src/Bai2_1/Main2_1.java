package Bai2_1;

public class Main2_1 {
    private static String daonguocString(String s) {
        return new StringBuilder().append(s.replaceAll("[Aa]", "")).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(daonguocString("Cong nghe Java"));
    }
}