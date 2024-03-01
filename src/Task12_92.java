import java.util.Arrays;
import java.util.Random;

/*
Дан двумерный массив. Найти:
а) минимальную сумму элементов строки;
б) максимальную сумму элементов столбца.
Обе задачи решить двумя способами:
1) с использованием дополнительного одномерного массива; - too easy
2) без использования дополнительного одномерного массива.
 */
public class Task12_92 {
    static int[][] arr = new int[5][5];
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                while (arr[i][j]==0){
                    arr[i][j] = (random.nextInt(20));
                }
            }
        }
        for (int[] row: arr){
            System.out.println(Arrays.toString(row));
        }
        System.out.println("ROWS");
        findMaxSum();

        for (int[] row: arr){
            System.out.println(Arrays.toString(row));
        }

        System.out.println("COLUMNS");
        findMinSum();

    }

    static void findMaxSum(){
        for (int i = 0; i < arr[0].length; i++) {
            int max = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j][i]>max){
                    max = arr[j][i];
                }
            }
            System.out.println("first max: ");
            System.out.println(max);
            int max2 = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j][i]>max2&&arr[j][i]<max){
                    max2 = arr[j][i];
                }
            }
            System.out.println("second max: ");
            System.out.println(max2);
            System.out.println("the sum: ");
            System.out.println(max+max2);
            System.out.println();
        }
    }

    static void findMinSum(){
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i][0];
            int jCord = 0;
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]<min){
                    min = arr[i][j];
                    jCord = j; //coordinates of the first min to ignore
                }
            }
            //if the first element is the first min - let the second element be min2
            int min2;
            if (arr[i][0]==min){
                min2 = arr[i][1];
            } else {
                min2 = arr[i][0];
            }
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]<min2&&j!=jCord){ //ignoring the prev. min element
                    min2 = arr[i][j];
                }
            }
            System.out.println("first min: "+min);
            System.out.println("second min: "+min2);
            System.out.println("the sum: "+(min+min2));
            System.out.println();
        }
    }
}
