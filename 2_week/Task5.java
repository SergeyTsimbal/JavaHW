import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Collator;
import java.util.*;
//Задание 5
//В текстовом файле хранятся названия песен, каждая песня с новой строки.
//Нужно вывести в консоль отсортированные по алфавиту все песни из файла.
public class Task5 {
    public static void main(String[] args) {
        List<String> songs = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("C://SomeDir//File4.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                songs.add(line.replace("\uFEFF", ""));
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Collections.sort(songs, new Comparator<String>() {
            public int compare(String o1, String o2) {
                Collator сollator = Collator.getInstance(new Locale("ru", "RU"));
                сollator.setStrength(Collator.PRIMARY);
                return сollator.compare(o1,o2);
            }
        });
        for (String s : songs) {
            System.out.println(s);
        }
    }
}