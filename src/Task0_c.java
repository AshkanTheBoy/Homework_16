
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//в) все его строки, в которых имеется более трех пробелов;
public class Task0_c {
    public static void main(String[] args) {
        String fileName = "src/files/text.txt";
        StringBuilder sb;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            sb = new StringBuilder();
            while (br.ready()) {
                String line = br.readLine();
                int count = 0;
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i)==' '){
                        count++;
                    }
                }
                if (count>3){
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