<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>All words</title>
</head>
<body>
<h2>All words</h2>
<br>
<table>
  <tr>
    <th>Text</th>
    <th>Meaning</th>
    <th>Source</th>
    <th>Destination</th>
    <th>Correct count</th>
    <th>Operations</th>
  </tr>
  <c:forEach var="word" items="${allWords}">

    <c:url var="updateButton" value="updateInfo">
      <c:param name="wordId" value="${word.id}"/>
    </c:url>
    <c:url var="deleteButton" value="deleteWord">
      <c:param name="wordId" value="${word.id}"/>
    </c:url>

    <tr>
      <td>${word.text}</td>
      <td>${word.meaning}</td>
      <td>${word.source}</td>
      <td>${word.destination}</td>
      <td>${word.correctCount}</td>
      <td><input type="button" value="Update" onclick="window.location.href = '${updateButton}'"/> </td>
      <td><input type="button" value="Delete" onclick="window.location.href = '${deleteButton}'"/> </td>
    </tr>

  </c:forEach>
</table>
<br>
<input type="button" value="add" onclick="window.location.href = 'addNewWord'">

</body>
</html>
