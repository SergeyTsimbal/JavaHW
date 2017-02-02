import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
//Задание 4
//Реализовать метод который будет принимать на вход слово на английском а возвращать результат перевода на русском.
public class Task4 {
    public static void main(String[] args) {
        Map<String, String> dictionary = new LinkedHashMap<String, String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("C://SomeDir//File.txt"));
            String line;
            while ((line = br.readLine()) != null) {
              String[] s = line.split(" ");
              dictionary.put(s[0].replace("\uFEFF", ""), s[1]);
              s = null;
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Введите слово на английском");
        Scanner reader = new Scanner(System.in);
        String word = reader.nextLine();
        System.out.println(vocabulary(dictionary, word));
}

    public static String vocabulary(Map<String, String> dictionary, String key) {

        for (Map.Entry<String, String> pair : dictionary.entrySet()) {
            if (pair.getKey().equals(key)) {
                return pair.getValue();
            }
        }
        return "Такого слова нет в словаре";
    }
}
