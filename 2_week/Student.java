import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//Задание 2
// Напишите класс Student, предоставляющий информацию об имени студента методом getName() и о его курсе методом getCourse().
public class Student {

    public Student(String name, int course){

        this.name = name;
        this.course = course;

    }

    private int course;
    private String name;

    public int getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }



    public static void printStudents(List students, int course){
        System.out.println("Список студенов "+course+" курса");
        Iterator i = students.iterator();
        while(i.hasNext()) {
            Student student = (Student) i.next();
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
    public static void main(String[] args)
    {
        int course=5;
        List<Student> list = new ArrayList<Student>();

        list.add(new Student("Федор", 1));
        list.add(new Student("Олег", 2));
        list.add(new Student("Степан", 3));
        list.add(new Student("Василий", 4));
        list.add(new Student("Сергей", 3));
        list.add(new Student("Игорь", 4));
        list.add(new Student("Анастасия", 2));
        list.add(new Student("Александр", 5));
        list.add(new Student("Юрий", 4));
        list.add(new Student("Алексей", 1));

        printStudents(list, course);

    }
}