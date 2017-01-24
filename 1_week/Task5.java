//Дан массив из 10 элементов. Скопировать первые три элемента в конец этого же массива.
import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        System.arraycopy(arr, 0, arr, 7,3);
        System.out.println(Arrays.toString(arr));

    }
}
