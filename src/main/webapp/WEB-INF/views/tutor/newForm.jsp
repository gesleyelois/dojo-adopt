<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<a href="/">Home</a> | <a href="/tutores">Lista de tutores</a>

<h1>Novo Tutor</h1>

<br/>
<br/>

<form:form modelAttribute="newTutorForm" method="post" action="/novo/tutor">

    <form:errors path="" cssStyle="color: red"/>

    <br/>
    <br/>

    <label>Nome:</label>
    <form:input path="name" required="true" maxlength="100"/>
    <form:errors path="name" cssStyle="color: red"/>

    <br/>
    <br/>

    <label>CPF:</label>
    <form:input path="cpf" required="true" />
    <form:errors path="cpf" cssStyle="color: red"/>

    <br/>
    <br/>

    <label>Data nascimento:</label>
    <form:input type="date" path="birthDate" required="true" />
    <form:errors path="birthDate" cssStyle="color: red"/>

    <br/>
    <br/>

    <label>Remuneração:</label>
    <form:input type="number" path="salary" step=".01" required="true" />
    <form:errors path="salary" cssStyle="color: red"/>

    <br/>
    <br/>

    <label>Tipo Moradia:</label>
    <form:select path="typeOfHousing" items="${typesOfHousing}" itemLabel="displayName" />
    <form:errors path="typeOfHousing" cssStyle="color: red"/>

    <br/>
    <br/>

    <label>Foto URL:</label>
    <form:input path="photoURL"/>
    <form:errors path="photoURL" cssStyle="color: red"/>

    <br/>
    <br/>

    <form:button>Cadastrar</form:button>

</form:form>