package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileExample {
    public static String FILE_IN = "E:\\Hoc/Cong nghe Java/Bai tap/src/file/text.zip";
    public static String FILE_OUT = "E:\\Hoc/Cong nghe Java/Bai tap/src/file/out.zip";

    public static void main(String[] args) throws IOException {
        FileInputStream fin = new FileInputStream(FILE_IN);
        FileOutputStream fout = new FileOutputStream(FILE_OUT);

    }
}

//TODO: input stream

//TODO: btvn input stream, output stream

//TODO: tao file ini sudoku