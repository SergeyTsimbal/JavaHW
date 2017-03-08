package servlet;


import dao.StudentDAO;
import dao.StudentDAOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteStudent")
public class deleteStudent extends HttpServlet {


    private static final long serialVersionUID = 6144684746882307236L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentDAO dao = new StudentDAOImpl();
        StudentDAOImpl f = new StudentDAOImpl();
        if (req.getParameter("id_delete") != "") {
            Long l = Long.parseLong(req.getParameter("id_delete"));
            try {
                dao.deleteStudent(l);
                if(f.isF() == true){
                    req.setAttribute("f", "1");
                }
                else {
                    req.setAttribute("f", "0");
                }
            } catch (SQLException e) {
                req.setAttribute("f", "0");
                RequestDispatcher reuqestDispatcher = getServletContext()
                        .getRequestDispatcher("/deleteStudent.jsp");
                reuqestDispatcher.forward(req, resp);
                e.printStackTrace();
            }


        }
        RequestDispatcher reuqestDispatcher = getServletContext()
                .getRequestDispatcher("/deleteStudent.jsp");
        reuqestDispatcher.forward(req, resp);
    }
}
