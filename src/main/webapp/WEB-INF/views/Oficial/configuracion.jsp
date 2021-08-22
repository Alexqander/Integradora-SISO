<%--
  Created by IntelliJ IDEA.
  User: servi
  Date: 21/08/2021
  Time: 04:13 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.login==null}">
    <c:redirect url="/index.jsp"></c:redirect>
</c:if>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
