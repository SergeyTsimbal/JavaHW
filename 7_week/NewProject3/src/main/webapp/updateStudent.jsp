<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Обновить информацию о студенте</title>
</head>
<body>
<form action="updateStudent" method="POST">
    id:<br><input type="text" name="id"><br><br>
    Имя:<br><input type="text" name="name"><br><br>
    Фамилия:<br><input type="text" name="surname"><br><br>
    Телефонный Номер:<br><input type="text" name="number"><br><br>
    Дата Рождения: в формате 2000-01-20<br><input type="text" name="date"><br><br>
    Электронная почта:<br><input type="text" name="email"><br>
    <input type="submit" value="Изменить"/>
</form>
<form action="StudentsServlet" method="POST">
    <input type="submit" value="Показать всех студентов в базе"/>
</form>
<%
    if (request.getAttribute("f") == "1") {

%>
<h2>Запись о студенте изменена</h2>
<%
    }
%>

<%
    if (request.getAttribute("f") == "0") {

%>
<h2>Ошибка при изменении</h2>
<%
    }
%>
<b><a href="index.jsp">Главная страница</a></b><br>
<b><a href="addStudent.jsp">Добавить студента</a></b><br>
<b><a href="deleteStudent.jsp">Удалить студента</a></b><br>
</body>
</html>
