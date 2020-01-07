<%--
  Created by IntelliJ IDEA.
  User: Marcio Ballem
  Date: 10/10/12
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>All Users</title>
</head>
<body>
<h1>List Users</h1>
<a href="users/add.html">Add User</a>
<c:if test="${!empty users}">
    <table>
        <tr bgcolor=#f5f5dc>
            <th align="left" width="100px">User ID</th>
            <th align="left" width="150px">User Name</th>
            <th align="left" width="150px">User Login</th>
            <th align="left" width="100px">User Password</th>
        </tr>
        <c:forEach items="${users}" var="user" varStatus="id">
            <tr  bgcolor="#${id.count % 2 != 0 ? 'aaee88' : 'ffffff' }">
                <td align="left" width="100px"><c:out value="${user.id}"/></td>
                <td align="left" width="150px"><c:out value="${user.name}"/></td>
                <td align="left" width="150px"><c:out value="${user.login}"/></td>
                <td align="left" width="100px"><c:out value="${user.pass}"/></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>