<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="/">Home</a>

<c:if test="${not empty error}">
    <br>
    <br>
    <div style="color: red">${error}</div>
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
</div>

<br>

<hr>

<br>

<c:choose>
    <c:when test="${empty animals}">
        <div>
            <strong>Nenhum animal para ser adotado!</strong>
        </div>
    </c:when>
    <c:otherwise>

        <h3>Deseja adotar qual animal?</h3>

        <table>
            <tr>
                <th>Foto</th>
                <th>ID</th>
                <th>Nome</th>
                <th>Porte</th>
                <th>Tipo</th>
                <th>Idade</th>
                <th>#</th>
            </tr>
            <c:forEach items="${animals}" var="animal">
                <tr>
                    <td><img src="${animal.photoURL}" alt="${animal.name}" width="150" height="100" /></td>
                    <td>${animal.id}</td>
                    <td>${animal.name}</td>
                    <td>${animal.size}</td>
                    <td>${animal.type}</td>
                    <td>${animal.age}</td>
                    <td>
                        <form method="post" action="/adotar/animal">
                            <input type="hidden" name="animalId" value="${animal.id}"/>
                            <input type="hidden" name="tutorId" value="${tutor.id}"/>
                            <input type="submit" value="Adotar"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </c:otherwise>
</c:choose>