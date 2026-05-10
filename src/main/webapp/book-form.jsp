<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Дані про книгу</title>
    <style>
        .container { width: 50%; margin: 20px auto; font-family: Arial, sans-serif; }
        .form-group { margin-bottom: 15px; }
        .form-group label { display: block; margin-bottom: 5px; font-weight: bold; }
        .form-group input, .form-group select { width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 4px;}
        .btn { padding: 10px 15px; background-color: #4CAF50; color: white; border: none; cursor: pointer; border-radius: 4px;}
        .btn-cancel {background-color: #f44336; color: white; text-decoration: none; padding: 10px 15px;border-radius: 4px;display: inline-block; font-size: 14px;}
    </style>
</head>
<body>
    <div class="container">
        <h2>
            <c:choose>
                <c:when test="${book != null}">Редагування книги</c:when>
                <c:otherwise>Додавання нової книги</c:otherwise>
            </c:choose>
        </h2>

        <form action="books" method="post">
            <input type="hidden" name="action" value="${book != null ? 'update' : 'insert'}" />
            <input type="hidden" name="id" value="${book != null ? book.id : ''}" />

            <div class="form-group">
                <label>Назва книги:</label>
                <input type="text" name="title" value="${book.title}" required />
            </div>

            <div class="form-group">
                <label>Автор:</label>
                <input type="text" name="author" value="${book.author}" required />
            </div>

            <div class="form-group">
                <label>Рік видання:</label>
                <input type="number" name="publishedYear" value="${book.publishedYear}" required />
            </div>

            <div class="form-group">
                <label>Бібліотека:</label>
                <select name="libraryId" required>
                    <c:forEach var="lib" items="${libraries}">
                        <option value="${lib.id}" ${book != null && book.library.id == lib.id ? 'selected' : ''}>
                            ${lib.name} (${lib.address})
                        </option>
                    </c:forEach>
                </select>
            </div>

            <button type="submit" class="btn">Зберегти</button>
            <a href="books" class="btn-cancel">Скасувати</a>
        </form>
    </div>
</body>
</html>