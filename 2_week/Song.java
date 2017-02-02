import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Collator;
import java.util.*;
//Задание 6
//В текстовом файле хранятся список песен, каждая песня из новой строки, данные о песне разделены слешем:
//Название песни/исполнитель/рейтинг песни
//Создайте класс Song с требуемыми полями. Отсортируйте и выведите в консоль песни из файла по названию и по исполнителю.

public class Song {

   private String name;
   private String singer;
   private int rating;

    public String getName() {
        return name;
    }

    public String getSinger() {
        return singer;
    }

    public int getRating() {
        return rating;
    }

    public Song(String name, String singer, int rating) {

        this.name = name;
        this.singer = singer;
        this.rating = rating;
    }


    public static void main(String[] args) {

        List<Song> list = new ArrayList<Song>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("C://SomeDir//File7.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] s = line.split("/");
                Integer s2 = new Integer(s[2]);
                list.add(new Song(s[0].replace("\uFEFF", ""), s[1], s2));
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
       Collections.sort(list, new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                Collator сollator = Collator.getInstance(new Locale("ru", "RU"));
                сollator.setStrength(Collator.PRIMARY);
                int result = сollator.compare(o1.getName(), o2.getName());
                if (result != 0) {
                    return result;
                }
                return сollator.compare(o1.getSinger(),o2.getSinger());

            }
        });
        Iterator i = list.iterator();
        while(i.hasNext()) {
            Song song = (Song) i.next();
                System.out.println(song.getName() + "-" + song.getSinger() + "-"+ song.getRating());
        }
    }
}
