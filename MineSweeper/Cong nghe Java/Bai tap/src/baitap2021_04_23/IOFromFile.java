package baitap2021_04_23;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class IOFromFile {
    public static ArrayOfObjects readFromFile(String filename) {
        ArrayOfObjects a = new ArrayOfObjects();
        FileReader fr;
        Scanner sc;
        try {
            fr = new FileReader(filename);
            sc = new Scanner(fr);
            String line;
            while (sc.hasNext()) {
                a.add(sc.nextInt());
            }
            sc.close();
            fr.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    public static void writeToFile(String filename, ArrayOfObjects a) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(filename);
            bw = new BufferedWriter(fw);
            bw.write("min: " + a.min() + "\n");
            bw.write("max: " + a.max() + "\n");
            bw.write("sum: " + a.sum());
            bw.close();
            fw.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
