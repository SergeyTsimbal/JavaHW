import java.io.*;
import java.util.Scanner;

//Реализовать запись в файл символьным потоком
public class Write {

    public static void main(String args[]) throws IOException {

        System.out.println("Введите сообщение");
        StringBuilder result = new StringBuilder();
        Scanner reader = new Scanner(System.in);
        String str = reader.nextLine();
        while (!str.equals("")) {
            result.append(str).append("\n");
            str = reader.nextLine();
        }
        System.out.println("Введите путь сохранение в формате C://Folder//File.txt");
        String dir = reader.nextLine();
        write(result, dir);
    }

    private static void write(StringBuilder text, String dir) throws IOException {

        String s = String.valueOf(text);
        String [] mas = s.split("\n");
        int f = dir.lastIndexOf("/");
        String fn = dir.substring(f + 1, dir.length());
        String fs = dir.substring(0, f);
        boolean directory = new File(fs).mkdirs();
        boolean creatFile = new File(fs, fn).createNewFile();
        File file = new File(fs+fn);
        BufferedWriter fw = new BufferedWriter(new FileWriter(file));
        try {
            for(int i = 0; i < mas.length; i++){
                fw.write(mas[i]);
                fw.newLine();
            }
            fw.close();
            System.out.println("Файл сохранен");
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }
}