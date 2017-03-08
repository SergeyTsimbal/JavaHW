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
import java.text.ParseException;
import java.text.SimpleDateFormat;


@WebServlet("/addStudent")
public class addStudent extends HttpServlet {


    private static final long serialVersionUID = 2320202760563574161L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        StudentDAO dao = new StudentDAOImpl();
        Student student = new Student();
        if (req.getParameter("name") == "" || req.getParameter("surname") == ""){
            req.setAttribute("f", "0");
            RequestDispatcher reuqestDispatcher = getServletContext()
                    .getRequestDispatcher("/addStudent.jsp");
            reuqestDispatcher.forward(req, resp);
        }
        student.setName(req.getParameter("name"));
        student.setSurname(req.getParameter("surname"));
        student.setNumber(req.getParameter("number"));
        student.setEmail(req.getParameter("email"));
        String d = req.getParameter("date");
        if (d == "") {
            try {
                dao.addStudent(student);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                SimpleDateFormat format = new SimpleDateFormat("y-MM-dd");
                java.util.Date date = format.parse(d);
                student.setDate(date);
                dao.addStudent(student);
            } catch (ParseException e) {
                req.setAttribute("f", "0");
                RequestDispatcher reuqestDispatcher = getServletContext()
                        .getRequestDispatcher("/addStudent.jsp");
                reuqestDispatcher.forward(req, resp);
                e.printStackTrace();
            } catch (SQLException e) {
                req.setAttribute("f", "0");
                RequestDispatcher reuqestDispatcher = getServletContext()
                        .getRequestDispatcher("/addStudent.jsp");
                reuqestDispatcher.forward(req, resp);
                e.printStackTrace();

            }
        }
        req.setAttribute("f", "1");
        RequestDispatcher reuqestDispatcher = getServletContext()
                .getRequestDispatcher("/addStudent.jsp");
        reuqestDispatcher.forward(req, resp);

    }

}
