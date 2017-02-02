import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//Реализовать чтение из файла символьным потоком
public class Read {

    public static void main(String[] args) throws IOException {
        System.out.println("Введите путь к файлу в формате C:/Folder/File.txt");
        Scanner reader = new Scanner(System.in);
        String file = reader.nextLine();
        read(file);
    }

    private static void read(String FILENAME) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILENAME));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}