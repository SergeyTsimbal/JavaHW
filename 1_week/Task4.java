// Сортировка пузырьком
public class Task4 {
    public static void main(String args[])  {

        int mas [] = {8, 2, 43, 67, 54, 475, 234, 23, 265, 87, 4};

//Прямая
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j <  mas.length - 1; j++) {
                if (mas[j] > mas[j + 1]) {
                    int temp = mas[j];
                    mas[j] = mas[j + 1];
                    mas[j + 1] = temp;
                }
            }
        }

        System.out.println(mas[0]);
        System.out.println(mas[mas.length-1]);

        System.out.println();

//Обратная
        for (int i = 0; i < mas.length; i++) {
            for (int j = mas.length-1; j > 0; j--) {
                if (mas[j] > mas[j - 1]) {
                    int temp = mas[j];
                    mas[j] = mas[j - 1];
                    mas[j -+ 1] = temp;
                }
            }
        }

        System.out.println(mas[0]);
        System.out.println(mas[mas.length-1]);
    }
}
