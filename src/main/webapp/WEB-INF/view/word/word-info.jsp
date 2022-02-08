<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<body>

<h2> Word info </h2>
<br>

<form:form action="/words/saveWord" modelAttribute="word">
    <form:hidden path="id"/>

    Text <form:input path="text"/>
    <br><br>
    Meaning <form:input path="meaning"/>
    <br><br>
    Source <form:input path="source"/>
    <br><br>
    Destination <form:input path="destination"/>
    <br><br>
    Correct count <form:input path="correctCount"/>
    <br><br>
    <input type="submit" value="OK">

</form:form>

</body>
</html>