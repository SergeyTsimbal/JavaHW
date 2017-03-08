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

@WebServlet("/updateStudent")
public class updateStudent extends HttpServlet{


    private static final long serialVersionUID = 1674313474537695126L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        StudentDAO dao = new StudentDAOImpl();
        Student student = new Student();
        StudentDAOImpl f = new StudentDAOImpl();
        if (req.getParameter("id") == ""){
            req.setAttribute("f", "0");
            RequestDispatcher reuqestDispatcher = getServletContext()
                    .getRequestDispatcher("/updateStudent.jsp");
            reuqestDispatcher.forward(req, resp);
        }
        Long l = Long.parseLong(req.getParameter("id"));
        student.setId(l);
        student.setName(req.getParameter("name"));
        student.setSurname(req.getParameter("surname"));
        student.setNumber(req.getParameter("number"));
        String d = req.getParameter("date");
        if (d == "") {
            try {
                dao.updateStudent(student);
                if(f.isF() == true){
                    req.setAttribute("f", "1");
                }
                else {
                    req.setAttribute("f", "0");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                SimpleDateFormat format = new SimpleDateFormat("y-MM-dd");
                java.util.Date date = format.parse(d);
                student.setDate(date);
                dao.updateStudent(student);
                if(f.isF() == true){
                    req.setAttribute("f", "1");
                }
                else {
                    req.setAttribute("f", "0");
                }
            } catch (ParseException e) {
                req.setAttribute("f", "0");
                RequestDispatcher reuqestDispatcher = getServletContext()
                        .getRequestDispatcher("/updateStudent.jsp");
                reuqestDispatcher.forward(req, resp);
                e.printStackTrace();
            } catch (SQLException e) {
                req.setAttribute("f", "0");
                RequestDispatcher reuqestDispatcher = getServletContext()
                        .getRequestDispatcher("/updateStudent.jsp");
                reuqestDispatcher.forward(req, resp);
                e.printStackTrace();

            }
        }
        RequestDispatcher reuqestDispatcher = getServletContext()
                .getRequestDispatcher("/updateStudent.jsp");
        reuqestDispatcher.forward(req, resp);

    }

}