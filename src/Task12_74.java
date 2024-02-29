import java.util.Arrays;
import java.util.Random;

/*
Дан двумерный массив. Найти число пар одинаковых соседних элементов.
В качестве соседних рассматривать:
а) только элементы, расположенные в одной строке;
б) только элементы, расположенные в одном столбце;
в)* элементы, расположенные в одной строке и в одном столбце.
 */
public class Task12_74 {
    public static void main(String[] args) {
        int count = 0;
        int[][] arr = new int[5][5];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = random.nextInt(3);
            }
        }

        for (int[] row: arr){
            System.out.println(Arrays.toString(row));
        }

        //a
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length-1; j++) {
                if (arr[i][j-1]==arr[i][j+1]){
                    count++;
                }
            }
        }
        System.out.println(count);

        //b
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length-1; j++) {
                if (arr[j-1][i]==arr[j+1][i]){
                    count++;
                }
            }
        }
        System.out.println(count);

        //c //maybe a coincidence, but shouldn't the answer be horizontal count+ vertical count???
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            //if not first or last row:
            if (i>0&&i< arr.length-1){
                for (int j = 0; j < arr[i].length; j++) {
                    //if first or last column, check only verticals
                    if (j==0||j==arr[i].length-1){
                        if (arr[i-1][j]==arr[i+1][j]){
                            count++;
                        }
                        //else - cross-check
                    } else {
                        if (arr[i][j-1]==arr[i][j+1]){
                            count++;
                        }
                        if (arr[i-1][j]==arr[i+1][j]){
                            count++;
                        }
                    }
                }
                //else - check only horizontals
            } else {
                for (int j = 1; j < arr[i].length-1; j++) {
                    if (arr[i][j-1]==arr[i][j+1]){
                        count++;
                    }
                }
            }

        }
        System.out.println(count);
    }
}
