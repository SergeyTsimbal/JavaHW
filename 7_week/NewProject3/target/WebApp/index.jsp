<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>База студентов</h2>
<form action="StudentsServlet" method="POST">
    <input type="submit" value="Показать всех студентов в базе"/>
</form>
<form action="deleteStudent" method="POST">
    <input type="text" size="5" name="id_delete">
    <input type="submit" value="Удалить студента"/>
</form>
<b><a href="addStudent.jsp">Добавить студента</a></b><br>
<b><a href="updateStudent.jsp">Обновить информацию о студенте</a></b><br>
<%
    if (request.getAttribute("f") != null) {

%>
<table border="1">
    <tr>
        <b>
            <th>id</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Телефонный Номер</th>
            <th>Дата Рождения</th>
            <th>Электронная почта</th>
        </b>
    </tr>
    <%
        }
    %>
    <%
        int i = 0;
        while (request.getAttribute("id" + i) != null) {

    %>
    <tr>
        <td><%=request.getAttribute("id" + i)%>
        </td>
        <td><%=request.getAttribute("name" + i)%>
        </td>
        <td><%=request.getAttribute("surname" + i)%>
        </td>
        <td><%=request.getAttribute("number" + i)%>
        </td>
        <td><%=request.getAttribute("date" + i)%>
        </td>
        <td><%=request.getAttribute("email" + i)%>
        </td>
    </tr>
    <%
            i++;
        }
    %>
</table>
</body>
</html>
