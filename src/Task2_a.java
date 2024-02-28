
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
а) Найти длину самой длинной строки.
б) Найти номер самой длинной строки. Если таких строк несколько, то найти
номер одной из них.
в) Напечатать самую длинную строку. Если таких строк несколько, то напечатать первую из них.
*/
public class Task2_a {
    public static void main(String[] args) {
        String fileName = "src/files/text.txt";
        int max = 0;
        List<String> lines = new ArrayList<>(); //br.reset() doesn't work so pack all lines in a list
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            while (br.ready()) {
                String line = br.readLine();
                if (line.length()>max){
                    max = line.length();

                }
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //search for the longest list
        for (String line: lines){
            if (line.length()==max){
                System.out.println(line); //prints valid line
                System.out.println(lines.indexOf(line)); //index of the line
                //break; uncomment if you want to get the first valid line
                //if there are identical lines - prints index of the first line with that content
            }
        }
        System.out.println(max);
    }
}