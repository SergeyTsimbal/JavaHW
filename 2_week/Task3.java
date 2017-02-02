//Задание 3
//Есть список сотрудников, которые есть имя фамилия и уникальный номер сотрудника.
//Получить сотрудника по уникальному ключу.

import java.util.*;

public class Task3 {

    public static void main(String[] args) {
    	HashMap<Integer, String> employee = new HashMap<Integer, String>();
        employee.put(1, "Гавриил Шувалов");
        employee.put(2, "Аркадий Савин");
        employee.put(3, "Вадим Антонов");

        System.out.println(search(employee, 2));

    }

    public static String search(HashMap<Integer, String> employee, int key) {

        for (HashMap.Entry<Integer, String> entry : employee.entrySet()) {
            if (entry.getKey() == key) {
                return entry.getValue();
            }
        }
        return "Сотрудника с таким ключом не существует";
    }
}