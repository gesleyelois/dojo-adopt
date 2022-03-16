<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="/">Home</a> | <a href="/novo/tutor">Novo Tutor</a>

<h1>Lista de tutores</h1>

<br>
<br>

<table>
    <tr>
        <th>ID</th>
        <th>Foto</th>
        <th>Nome</th>
        <th>CPF</th>
    </tr>
    <c:forEach items="${tutors}" var="tutor">
        <tr>
            <td>${tutor.id}</td>
            <td><img src="${tutor.photoURL}" alt="${tutor.name}" width="150" height="100" /></td>
            <td>${tutor.name}</td>
            <td>${tutor.cpf}</td>
        </tr>
    </c:forEach>
</table>