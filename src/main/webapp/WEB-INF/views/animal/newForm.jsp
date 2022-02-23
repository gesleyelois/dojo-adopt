<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>Novo Animal</h1>

<br/>
<br/>

<form:form modelAttribute="newAnimalForm" method="post" action="/novo/animal">

    <label>Nome:</label>
    <form:input path="name" required="true" maxlength="50"/>
    <form:errors path="name" cssStyle="color: red"/>

    <br/>
    <br/>

    <label>Custo mensal:</label>
    <form:input type="number" path="monthlyCost" min="10" step=".01"/>
    <form:errors path="monthlyCost" cssStyle="color: red"/>

    <br/>
    <br/>

    <label>Data nascimento:</label>
    <form:input type="date" path="birthDate" />
    <form:errors path="birthDate" cssStyle="color: red"/>

    <br/>
    <br/>

    <label>Tipo:</label>
    <form:select path="type" items="${animalTypes}" itemLabel="displayName" />
    <form:errors path="type" cssStyle="color: red"/>

    <br/>
    <br/>

    <label>Porte:</label>
    <form:select path="size" items="${animalSizes}" itemLabel="displayName" />
    <form:errors path="size" cssStyle="color: red"/>

    <br/>
    <br/>

    <label>Foto URL:</label>
    <form:input path="photoURL"/>
    <form:errors path="photoURL" cssStyle="color: red"/>

    <br/>
    <br/>

    <form:button>Cadastrar</form:button>

</form:form>