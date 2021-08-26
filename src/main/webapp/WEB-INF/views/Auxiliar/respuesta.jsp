<%--
  Created by IntelliJ IDEA.
  User: servi
  Date: 21/08/2021
  Time: 04:15 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.login==null}">
    <c:redirect url="/index.jsp"></c:redirect>
</c:if>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/respuesta.css">
    <title>MODIFICACION</title>
</head>
<body>



<div class="container-fluid">
    <div class="row">
        <div class="col-12 d-flex justify-content-center" >
            <div class="mensaje d-flex align-items-center justify-content-center">
                <h2>EL DOCUMENTO AH SIDO RESPONDIDO</h2>
            </div>

        </div>
    </div>
    <div class="row">
        <div class="col d-flex justify-content-center align-items-center" >
            <div class="contimg">
                <img src="${pageContext.request.contextPath}/images/respon.gif" class="fgi" alt="">
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col d-flex justify-content-center align-items-center">
            <div class="mb-5">
                <form action="ServletRutes" method="get">
                    <input type="hidden" name="to" value="views/Auxiliar/inicioAuxiliar.jsp">
                    <button class="btn bb btn-primary mb-5" type="submit">Aceptar</button>
                </form>

            </div>

        </div>
    </div>

</div>
</body>
</html>