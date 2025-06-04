<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Коти</title>
</head>
<body>
    <h1>Реєстр котів</h1>

    <h2>Додати нового кота</h2>
    <form method="post" action="${pageContext.request.contextPath}/">
        <table border="1">
            <tr>
                <td>Ім'я кота:</td>
                <td><input type="text" name="catName" required></td>
            </tr>
            <tr>
                <td>Порода:</td>
                <td><input type="text" name="catBreed"></td>
            </tr>
            <tr>
                <td>Вік (років):</td>
                <td><input type="number" name="catAge" min="0" max="25"></td>
            </tr>
            <tr>
                <td>Колір:</td>
                <td><input type="text" name="catColor"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Додати кота">
                </td>
            </tr>
        </table>
    </form>

    <hr>

    <h2>Список котів (${cats.size()})</h2>

    <c:choose>
        <c:when test="${not empty cats}">
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Ім'я</th>
                    <th>Порода</th>
                    <th>Вік</th>
                    <th>Колір</th>
                </tr>
                <c:forEach var="cat" items="${cats}">
                    <tr>
                        <td>${cat.id}</td>
                        <td>${cat.name}</td>
                        <td>${cat.breed}</td>
                        <td>${cat.age}</td>
                        <td>${cat.color}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <p><em>Котів ще не зареєстровано.</em></p>
        </c:otherwise>
    </c:choose>

    <hr>
    <p><small>Lab8 - Jakarta Servlet + PostgreSQL</small></p>
</body>
</html>