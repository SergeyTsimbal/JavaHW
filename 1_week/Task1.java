//Месяца

public class Task1 {

    public static void main(String args[]) {
        int month = 1;
        switch (month) {
            case 1:
            case 2:
            case 12:
                System.out.println("Зима");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Весна");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Лето");
                break;
            default:
                System.out.println("Осень");
                break;
        }
    }
}
