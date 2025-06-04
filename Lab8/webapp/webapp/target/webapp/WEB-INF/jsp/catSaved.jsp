<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Результат</title>
</head>
<body>
    <h1>Результат додавання кота</h1>

    <c:choose>
        <c:when test="${success}">
            <p><strong>Успіх!</strong> Кота "${catName}" додано до бази даних.</p>
        </c:when>
        <c:otherwise>
            <p><strong>Помилка!</strong> Не вдалося додати кота "${catName}" до бази даних.</p>
        </c:otherwise>
    </c:choose>

    <hr>

    <p><a href="${pageContext.request.contextPath}/">Повернутися до списку котів</a></p>

    <hr>
    <p><small>Lab8 - Jakarta Servlet + PostgreSQL</small></p>
</body>
</html>