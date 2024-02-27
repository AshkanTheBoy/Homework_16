
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//а) количество строк, начинающихся с букв А или а;
public class Task1_a {
    public static void main(String[] args) {
        String fileName = "src/files/text.txt";
        StringBuilder sb;
        int count = 0; //ince
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            sb = new StringBuilder();
            while (br.ready()) {
                String line = br.readLine();
                if (line.toLowerCase().startsWith("a")){ //shorter than line.startsWith("A")||...
                    count++;
                    sb.append("\n");
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(count);
    }
}