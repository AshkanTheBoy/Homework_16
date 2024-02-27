import java.io.FileWriter;
import java.io.IOException;

public class WriteTextFile {
    public static void main(String[] args) {
        String fileName = "src/files/text.txt";
        FileWriter fw;
        try {
            fw = new FileWriter(fileName,true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String s = "Hhis string will not print\n";
        try {
            fw.append(s);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}