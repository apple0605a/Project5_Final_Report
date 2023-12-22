<%@ page language="java" contentType="text/html; charset=UTF-8"
         isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title>editform</title>
</head>
<body>
<form:form modelAttribute="boardVO" method="POST" action="../editok">
  <form:hidden path="seq"/>
  <table id="edit">
    <tr><td>카테고리</td><td><form:input path="category" id="Category"  /></td></tr>
    <tr><td>제목</td><td><form:input path="title" id="Title" /></td></tr>
    <tr><td>글쓴이</td><td><form:input path="writer" id="Writer" /></td></tr>
    <tr><td>내용</td><td><form:textarea col="50" rows="5" path="content" id="Textarea" /></td></tr>

  </table>
  <input type="submit" value="수정하기"/>
  <button type="button" onclick="window.location.href='../'">취소하기</button>

</form:form>
</body>
</html>