// Дан массив 5x8. Заполнить случайными элементами [0;100]. Определить сумму.

public class Task3 {

    public static void main(String[] args) {

        int[][] m = new int[5][8];
        int sum = 0;
        for (int x = 0; x < m.length; x++) {
            for (int y = 0; y < m[x].length; y++) {
                m[x][y] = (int) (Math.random() * 101);
                sum += m[x][y];
                System.out.print(m[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println("\nСумма элементов = " + sum);

    }
}

