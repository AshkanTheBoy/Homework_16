import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//б) все его строки, содержащие более 30 символов;
public class Task0_b {
    public static void main(String[] args) {
        String fileName = "src/files/text.txt";
        StringBuilder sb;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            sb = new StringBuilder();
            while (br.ready()) {
                String line = br.readLine();
                if (line.length()>=30){
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