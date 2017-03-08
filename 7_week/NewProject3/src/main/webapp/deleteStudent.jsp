<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удалить студента</title>
</head>
<body>
<form action="StudentsServlet" method="POST">
    <input type="submit" value="Показать всех студентов в базе"/>
</form>
<form action="deleteStudent" method="POST">
    <input type="text" size="5" name="id_delete">
    <input type="submit" value="Удалить студента"/>
</form>
<%
    if (request.getAttribute("f") == "1") {

%>
<h2>Студент удален</h2>
<%
    }
%>

<%
    if (request.getAttribute("f") == "0") {

%>
<h2>Ошибка при удалении</h2>
<%
    }
%>
<b><a href="index.jsp">Главная страница</a></b><br>
<b><a href="addStudent.jsp">Добавить студента</a></b><br>
<b><a href="updateStudent.jsp">Обновить информацию о студенте</a></b><br>
</body>
</html>
