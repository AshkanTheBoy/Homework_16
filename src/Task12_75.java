import java.util.Arrays;
import java.util.Random;

/*
Дан двумерный массив ненулевых целых чисел. Определить, сколько раз
элементы массива меняют знак (принимая, что массив просматривается построчно сверху вниз,
а в каждой строке — слева направо).
 */
public class Task12_75 {
    static int[][] arr = new int[5][5];
    static int count = 0;
    static int i = 0;
    static boolean state = true;
    public static void main(String[] args) {
        Random random = new Random();
        for (i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                while (arr[i][j]==0){
                    arr[i][j] = (random.nextInt(5)+1)-(random.nextInt(3)+1);
                }
            }
        }
        for (int[] row: arr){
            System.out.println(Arrays.toString(row));
        }

        //initial "number sign"
        if (arr[0][0]<0){
            state = false;
        }
        for (i = 0; i < arr.length; i++) {
            //check the sign of the first number in each row
            if (arr[i][0]>0){
                checkPosNum(0);
            } else {
                checkNegNum(0);
            }

        }
        System.out.println(count);
    }

    public static void checkPosNum(int posNum){
        if (posNum>= arr[i].length){
            return;
        }
        if (arr[i][posNum]<0&&state){
            count++;
            state = false;
            checkNegNum(posNum+1);
            //"state" var helps in situations, when sings of the first number in the current row
            //and the last number in the prev row are different
        } else if (arr[i][posNum]>0&&!state){
            state = true;
            count++;
            checkPosNum(posNum+1);
        } else {
            checkPosNum(posNum+1);
        }
    }

    public static void checkNegNum(int negNum){
        if (negNum>= arr[i].length){
            return;
        }
        if (arr[i][negNum]>0&&!state){
            count++;
            state = true;
            checkPosNum(negNum+1);
        } else if (arr[i][negNum]<0&&state){
            state = false;
            count++;
            checkNegNum(negNum+1);
        } else {
            checkNegNum(negNum+1);
        }

    }
}
