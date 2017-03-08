package servlet;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet("/StudentServlet")
public class StudentsServlet extends HttpServlet {

    private static final long serialVersionUID = -56778709290739966L;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        try {
            StudentDAO dao = new StudentDAOImpl();


            List<Student> students = dao.getAllStudents();
            Collections.sort(students, new Comparator<Student>(){
                public int compare(Student o1,Student o2)
                {
                    return o1.getId().compareTo(o2.getId());
                }
            });

                req.setAttribute("f", 1);
                for (int i = 0; i < students.size(); i++) {
                    req.setAttribute("id" + i, students.get(i).getId());
                    req.setAttribute("name" + i, isEmtpy(students.get(i).getName()));
                    req.setAttribute("surname" + i, isEmtpy(students.get(i).getSurname()));
                    req.setAttribute("number" + i, isEmtpy(students.get(i).getNumber()));
                    req.setAttribute("email" + i, isEmtpy(students.get(i).getEmail()));
                    Date d = students.get(i).getDate();
                    if(d == null){
                        req.setAttribute("date" + i, "");
                    }
                    else{
                        DateFormat df = new SimpleDateFormat("y-MM-dd");
                        String date = df.format(d);
                        req.setAttribute("date" + i, date);
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher reuqestDispatcher = getServletContext()
                .getRequestDispatcher("/index.jsp");
        reuqestDispatcher.forward(req, resp);

    }

    private String isEmtpy(String value) {
        if(value == null) {
            return "";
        }

        return value;
    }

}