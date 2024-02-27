
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//б)количество строк, в которых имеется ровно 5 букв 'и'.
public class Task1_b {
    public static void main(String[] args) {
        String fileName = "src/files/text.txt";
        StringBuilder sb;
        int lineCount = 0; //line count
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            sb = new StringBuilder();
            while (br.ready()) {
                String line = br.readLine();
                int charCount = 0; //required characters count
                for (int i = 0; i < line.length(); i++) {
                    if (line./*toLowerCase().*/charAt(i)=='и'){ //uncomment to disable case sensitivity
                        charCount++;
                    }
                }
                if (charCount==5){
                    sb.append(line);
                    sb.append("\n");
                    lineCount++;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(sb);
        System.out.println(lineCount);
    }
}