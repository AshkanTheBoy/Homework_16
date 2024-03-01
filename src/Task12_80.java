import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*
.*Дан двумерный массив. Определить количество различных элементов в нем.
 */
public class Task12_80 {
    static int[][] arr = new int[5][5];
    static int i = 0;
    public static void main(String[] args) {
        Random random = new Random();
        for (i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                while (arr[i][j]==0){
                    arr[i][j] = (random.nextInt(20));
                }
            }
        }
        for (int[] row: arr){
            System.out.println(Arrays.toString(row));
        }

        ArrayList<Integer> uniques = new ArrayList<>();
        for (int[] row: arr){
            for (int j = 0; j < row.length; j++) {
                if (!uniques.contains(row[j])){
                    uniques.add(row[j]);
                }
            }
        }
        System.out.println(uniques);
        System.out.println(uniques.size());
    }
}
