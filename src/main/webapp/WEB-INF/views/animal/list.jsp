<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Lista de animais</h1>

<table>
    <tr>
        <th>Foto</th>
        <th>ID</th>
        <th>Nome</th>
        <th>Porte</th>
        <th>Tipo</th>
        <th>Idade</th>
    </tr>
    <c:forEach items="${animals}" var="animal">
        <tr>
            <td><img src="${animal.photoURL}" alt="${animal.name}" width="150" height="100" /></td>
            <td>${animal.id}</td>
            <td>${animal.name}</td>
            <td>${animal.size}</td>
            <td>${animal.type}</td>
            <td>${animal.age}</td>
        </tr>
    </c:forEach>
</table>