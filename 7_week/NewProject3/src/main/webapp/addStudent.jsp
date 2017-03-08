<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Добавить студента</h2>

<form action="addStudent" method="POST">
    Имя:<br><input type="text" name="name"><br><br>
    Фамилия:<br><input type="text" name="surname"><br><br>
    Телефонный Номер:<br><input type="text" name="number"><br><br>
    Дата Рождения: в формате 2000-01-20<br><input type="text" name="date"><br><br>
    Электронная почта:<br><input type="text" name="email"><br>
    <input type="submit" value="Добавить"/>
</form>
<form action="StudentsServlet" method="POST">
    <input type="submit" value="Показать всех студентов в базе"/>
</form>
<%
    if (request.getAttribute("f") == "1") {

%>
<h2>Запись добавлена</h2>
<%
    }
%>

<%
    if (request.getAttribute("f") == "0") {

%>
<h2>Ошибка при добавлении</h2>
<%
    }
%>
<b><a href="index.jsp">Главная страница</a></b><br>
<b><a href="deleteStudent.jsp">Удалить студента</a></b><br>
<b><a href="updateStudent.jsp">Обновить информацию о студенте</a></b><br>
</body>
</html>
