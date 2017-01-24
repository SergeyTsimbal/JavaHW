import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Ввод 10 чисел с клавиатуры. Найти Минимальное и Максимальное

public class Task2 {
    public static void main(String args[]) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int min = Integer.parseInt(reader.readLine());
        int max = min;
        int x;
        for (int i = 0; i < 9; i++) {
            x = Integer.parseInt(reader.readLine());
            if (min > x)
                min = x;
            if (max < x)
                max = x;
        }

        System.out.println("Минимальное = " + min);
        System.out.println("Максимальное = " + max);
    }
}
