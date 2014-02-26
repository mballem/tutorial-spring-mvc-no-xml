<%--
  Created by IntelliJ IDEA.
  User: Marcio Ballem
  Date: 10/10/12
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head><title>Add User</title></head>
<body>
<h1>Add User</h1>
<c:url var="viewUsersUrl" value="/users.html"/>
<a href="${viewUsersUrl}">Show All Users</a>
<br/>
<br/>
<c:url var="saveUserUrl" value="/users/save.html"/>
<form:form modelAttribute="user" method="POST" action="${saveUserUrl}">
    <form:label path="name">User name:</form:label>
    <form:input path="name"/>
    <br/>
    <form:label path="login">User login:</form:label>
    <form:input path="login"/>
    <br/>
    <form:label path="pass">User password:</form:label>
    <form:password path="pass"/>
    <br/>
    <input type="submit" value="Save User"/>
</form:form>
</body>
</html>