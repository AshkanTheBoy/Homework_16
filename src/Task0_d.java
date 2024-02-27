
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//г) все его строки, содержащие в качестве фрагмента заданный текст.
public class Task0_d {
    public static void main(String[] args) {
        String fileName = "src/files/text.txt";
        StringBuilder sb;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            sb = new StringBuilder();
            while (br.ready()) {
                String line = br.readLine();
                String text = "_THIS IS NECESSARY_";
                if (line.contains(text)){
                    sb.append(line);
                    sb.append("\n");
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(sb);
    }
}