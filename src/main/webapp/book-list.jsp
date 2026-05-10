<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Список книг</title>
    <style>
        table { width: 80%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .btn { padding: 5px 10px; text-decoration: none; border-radius: 3px; }
        .btn-add { background-color: #4CAF50; color: white; }
        .btn-edit { background-color: #2196F3; color: white; }
        .btn-delete { background-color: #f44336; color: white; }
    </style>
</head>
<body>
    <h2>Керування бібліотечним фондом</h2>

    <a href="books?action=new" class="btn btn-add">Додати нову книгу</a>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Назва</th>
                <th>Автор</th>
                <th>Рік видання</th>
                <th>Бібліотека</th>
                <th>Дії</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${listBooks}">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.publishedYear}</td>
                    <td>${book.library.name}</td>
                    <td>
                        <a href="books?action=edit&id=${book.id}" class="btn btn-edit">Редагувати</a>
                        <a href="books?action=delete&id=${book.id}" class="btn btn-delete"
                           onclick="return confirm('Ви впевнені?')">Видалити</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>