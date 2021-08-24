<%--
  Created by IntelliJ IDEA.
  User: servi
  Date: 24/08/2021
  Time: 12:08 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/menus.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/usuarios.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pdf.css">


</head>
<body>

<div class="container-fluid">
  <div class="row">
    <div class="col-12">
      <object class="pdfview" type="application/PDF" data="${pageContext.request.contextPath}/ServletSalida?id=7"> </object>
    </div>
  </div>

</div>

</body>
</html>
