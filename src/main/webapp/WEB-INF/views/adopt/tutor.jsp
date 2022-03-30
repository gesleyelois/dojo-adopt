<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="/">Home</a>

<c:if test="${not empty success}">
    <br>
    <br>
    <div style="color: green">${success}</div>
</c:if>

<h1>Adotar animal</h1>

<br>
<br>

<div>
    <img src="${tutor.photoURL}" alt="${tutor.name}" width="150" height="100" />

    <br>
    <br>

    <strong>Nome:</strong> ${tutor.name}

    <br>
    <br>

    <strong>CPF:</strong> ${tutor.cpf}

    <br>
    <br>

    <strong>Remuneração R$:</strong> ${tutor.salary}

    <br>
    <br>

    <strong>Total Gasto R$:</strong> ${totalMonthlyCostWithAnimal}
</div>

<br>

<hr>

<br>

<h3>-- ANIMAIS ADOTADOS --</h3>

<table>
    <tr>
        <th>Foto</th>
        <th>Nome</th>
    </tr>
    <c:forEach items="${animals}" var="animal">
        <tr>
            <td><img src="${animal.photoURL}" alt="${animal.name}" width="150" height="100" /></td>
            <td>${animal.name}</td>
        </tr>
    </c:forEach>
</table>