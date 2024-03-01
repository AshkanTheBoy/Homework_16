import java.util.Arrays;
import java.util.Random;

/*
Дан двумерный массив. Определить:
а) максимальный элемент массива;
б) минимальный элемент массива;
в) координаты минимального элемента массива. Если элементов с минимальным значением несколько, то должны быть найдены координаты самого
нижнего и самого правого из них;
г) координаты максимального элемента массива. Если элементов с максимальным значением несколько, то должны быть найдены координаты самого
верхнего и самого левого из них.
 */
public class Task12_89 {
    static int[][] arr = new int[5][5];
    public static void main(String[] args) {
        int max = 0;
        int min = 0;
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                while (arr[i][j]==0){
                    arr[i][j] = (random.nextInt(20));
                    if (arr[i][j]>max){
                        max = arr[i][j];
                    }
                    /*
                    need to give min the first element to begin searching for the minimum,
                    otherwise min will always be 0
                     */
                    if (min==0){
                        min = arr[i][j];
                    } else if (arr[i][j]<min){
                        min = arr[i][j];
                    }
                }
            }
        }
        for (int[] row: arr){
            System.out.println(Arrays.toString(row));
        }
        System.out.println("MAX: "+max);
        System.out.println("MIN: "+min);
        findMax(max);
        findMin(min);
    }

    static void findMax(int max){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]==max){
                    System.out.printf("MAX COORDS: [%d, %d]%n",i,j);
                    return;
                }
            }
        }
    }

    static void findMin(int min){
        for (int i = arr.length-1; i>=0; i--) {
            for (int j = arr[i].length-1; j >=0 ; j--) {
                if (arr[i][j]==min){
                    System.out.printf("MIN COORDS: [%d, %d]%n",i,j);
                    return;
                }
            }
        }
    }
}
