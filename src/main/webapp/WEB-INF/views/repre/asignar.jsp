<%--
  Created by IntelliJ IDEA.
  User: servi
  Date: 21/08/2021
  Time: 04:16 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.login==null}">
    <c:redirect url="/index.jsp"></c:redirect>
</c:if>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/menus.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/formad.css">

    <title>HOME</title>
</head>
<body>
<header class="fixed-top">
    <div class="container-fluid">
        <div class="row">
            <!--logo-->

            <div class="col-xl-2 col-md-3 col-sm-3">
                <a href="${pageContext.request.contextPath}/ServletRutes?to=views/repre/inicioRepresentante.jsp"><img src="${pageContext.request.contextPath}/images/siso-icono.png"class="img-siso" alt=""></a>
            </div>

            <!--botones y usuario-->
            <div class="col-xl-10 col-md-8 col-sm-8 d-flex align-items-center justify-content-end">

                <div class="config mx-2">
                    <button class="btn" type="button" id="dropdown-1" data-bs-toggle="dropdown" aria-expanded="false">

                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-gear" viewBox="0 0 16 16">
                            <path d="M8 4.754a3.246 3.246 0 1 0 0 6.492 3.246 3.246 0 0 0 0-6.492zM5.754 8a2.246 2.246 0 1 1 4.492 0 2.246 2.246 0 0 1-4.492 0z"/>
                            <path d="M9.796 1.343c-.527-1.79-3.065-1.79-3.592 0l-.094.319a.873.873 0 0 1-1.255.52l-.292-.16c-1.64-.892-3.433.902-2.54 2.541l.159.292a.873.873 0 0 1-.52 1.255l-.319.094c-1.79.527-1.79 3.065 0 3.592l.319.094a.873.873 0 0 1 .52 1.255l-.16.292c-.892 1.64.901 3.434 2.541 2.54l.292-.159a.873.873 0 0 1 1.255.52l.094.319c.527 1.79 3.065 1.79 3.592 0l.094-.319a.873.873 0 0 1 1.255-.52l.292.16c1.64.893 3.434-.902 2.54-2.541l-.159-.292a.873.873 0 0 1 .52-1.255l.319-.094c1.79-.527 1.79-3.065 0-3.592l-.319-.094a.873.873 0 0 1-.52-1.255l.16-.292c.893-1.64-.902-3.433-2.541-2.54l-.292.159a.873.873 0 0 1-1.255-.52l-.094-.319zm-2.633.283c.246-.835 1.428-.835 1.674 0l.094.319a1.873 1.873 0 0 0 2.693 1.115l.291-.16c.764-.415 1.6.42 1.184 1.185l-.159.292a1.873 1.873 0 0 0 1.116 2.692l.318.094c.835.246.835 1.428 0 1.674l-.319.094a1.873 1.873 0 0 0-1.115 2.693l.16.291c.415.764-.42 1.6-1.185 1.184l-.291-.159a1.873 1.873 0 0 0-2.693 1.116l-.094.318c-.246.835-1.428.835-1.674 0l-.094-.319a1.873 1.873 0 0 0-2.692-1.115l-.292.16c-.764.415-1.6-.42-1.184-1.185l.159-.291A1.873 1.873 0 0 0 1.945 8.93l-.319-.094c-.835-.246-.835-1.428 0-1.674l.319-.094A1.873 1.873 0 0 0 3.06 4.377l-.16-.292c-.415-.764.42-1.6 1.185-1.184l.292.159a1.873 1.873 0 0 0 2.692-1.115l.094-.319z"/>
                        </svg>

                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdown-1">
                        <li><a href="${pageContext.request.contextPath}" class="dropdown-item">Configuracion</a></li>
                    </ul>
                </div>

                <div class="img">
                    <button class="btn" type="button" id="dropdown-2" data-bs-toggle="dropdown" aria-expanded="false">


                        <img src="${pageContext.request.contextPath}/images/usuario-icono.png" class="img-user" alt="">
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdown-2">
                        <li><a href="${pageContext.request.contextPath}/ServletLogout" class="dropdown-item">Salir <svg  xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-right mx-2 my-1" viewBox="0 0 16 16">
                            <path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"/>
                            <path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
                        </svg></a></li>
                        <li><a href="${pageContext.request.contextPath}/ServletEmpleados" class="dropdown-item">Perfil</a></li>
                    </ul>
                </div>

            </div>
        </div>
    </div>
</header>
<br>
<div class="container-fluid">
    <div class="row justify-content-start justifi-content-md-between blanco"></div>
    <div class="row justify-content-start justifi-content-md-between">

        <aside class="enlaces-rapidos col-3 col-xl-2">

            <nav>
                <a  href="#menu-documentos" type="button" data-bs-toggle="collapse" aria-expanded="false" aria-controls="menu-opciones">
                    <div class="icono mx-2 my-2">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-files" viewBox="0 0 16 16">
                            <path d="M13 0H6a2 2 0 0 0-2 2 2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h7a2 2 0 0 0 2-2 2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zm0 13V4a2 2 0 0 0-2-2H5a1 1 0 0 1 1-1h7a1 1 0 0 1 1 1v10a1 1 0 0 1-1 1zM3 4a1 1 0 0 1 1-1h7a1 1 0 0 1 1 1v10a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V4z"/>
                        </svg>
                    </div>Documentos
                </a>
                <div class="collapse mt-3" id="menu-documentos">
                    <ul class="men">

                        <li class="opciones"><a href="${pageContext.request.contextPath}/ServletDocumentos?accion=r1"><div class="icono-l">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-clipboard" viewBox="0 0 16 16">
                                <path d="M4 1.5H3a2 2 0 0 0-2 2V14a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V3.5a2 2 0 0 0-2-2h-1v1h1a1 1 0 0 1 1 1V14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V3.5a1 1 0 0 1 1-1h1v-1z"/>
                                <path d="M9.5 1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5h3zm-3-1A1.5 1.5 0 0 0 5 1.5v1A1.5 1.5 0 0 0 6.5 4h3A1.5 1.5 0 0 0 11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3z"/>
                            </svg>
                        </div>
                            <p class="p-text">Consultar</p></a>
                        </li>
                    </ul>
                </div>
                <a  href="#menu-config" type="button" data-bs-toggle="collapse" aria-expanded="false" aria-controls="menu-opciones">
                    <div class="icono mx-2 my-2">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-gear" viewBox="0 0 16 16">
                            <path d="M8 4.754a3.246 3.246 0 1 0 0 6.492 3.246 3.246 0 0 0 0-6.492zM5.754 8a2.246 2.246 0 1 1 4.492 0 2.246 2.246 0 0 1-4.492 0z"/>
                            <path d="M9.796 1.343c-.527-1.79-3.065-1.79-3.592 0l-.094.319a.873.873 0 0 1-1.255.52l-.292-.16c-1.64-.892-3.433.902-2.54 2.541l.159.292a.873.873 0 0 1-.52 1.255l-.319.094c-1.79.527-1.79 3.065 0 3.592l.319.094a.873.873 0 0 1 .52 1.255l-.16.292c-.892 1.64.901 3.434 2.541 2.54l.292-.159a.873.873 0 0 1 1.255.52l.094.319c.527 1.79 3.065 1.79 3.592 0l.094-.319a.873.873 0 0 1 1.255-.52l.292.16c1.64.893 3.434-.902 2.54-2.541l-.159-.292a.873.873 0 0 1 .52-1.255l.319-.094c1.79-.527 1.79-3.065 0-3.592l-.319-.094a.873.873 0 0 1-.52-1.255l.16-.292c.893-1.64-.902-3.433-2.541-2.54l-.292.159a.873.873 0 0 1-1.255-.52l-.094-.319zm-2.633.283c.246-.835 1.428-.835 1.674 0l.094.319a1.873 1.873 0 0 0 2.693 1.115l.291-.16c.764-.415 1.6.42 1.184 1.185l-.159.292a1.873 1.873 0 0 0 1.116 2.692l.318.094c.835.246.835 1.428 0 1.674l-.319.094a1.873 1.873 0 0 0-1.115 2.693l.16.291c.415.764-.42 1.6-1.185 1.184l-.291-.159a1.873 1.873 0 0 0-2.693 1.116l-.094.318c-.246.835-1.428.835-1.674 0l-.094-.319a1.873 1.873 0 0 0-2.692-1.115l-.292.16c-.764.415-1.6-.42-1.184-1.185l.159-.291A1.873 1.873 0 0 0 1.945 8.93l-.319-.094c-.835-.246-.835-1.428 0-1.674l.319-.094A1.873 1.873 0 0 0 3.06 4.377l-.16-.292c-.415-.764.42-1.6 1.185-1.184l.292.159a1.873 1.873 0 0 0 2.692-1.115l.094-.319z"/>
                        </svg>
                    </div>Configuracion
                </a>
                <div class="collapse mt-3" id="menu-config">
                    <ul class="men">
                        <li class="opciones "><a href="${pageContext.request.contextPath}/ServletRutes?to="> <div class="icono-l">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-sliders" viewBox="0 0 16 16">
                                <path fill-rule="evenodd" d="M11.5 2a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zM9.05 3a2.5 2.5 0 0 1 4.9 0H16v1h-2.05a2.5 2.5 0 0 1-4.9 0H0V3h9.05zM4.5 7a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zM2.05 8a2.5 2.5 0 0 1 4.9 0H16v1H6.95a2.5 2.5 0 0 1-4.9 0H0V8h2.05zm9.45 4a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zm-2.45 1a2.5 2.5 0 0 1 4.9 0H16v1h-2.05a2.5 2.5 0 0 1-4.9 0H0v-1h9.05z"/>
                            </svg>
                        </div>
                            <p class="p-text">General</p></a></li>
                    </ul>
                </div>
            </nav>
        </aside>

        <main class="col-10 col-md-9 bg-ligth px-3">
            <div class="contenido bg-ligth ">
                <div class="head">
                    <div class="row titulo-formulario">
                        <div class="col-6">

                        </div>
                        <div class="col-6">

                        </div>
                    </div>
                </div>
                <div class="body">
                    <div class="row d-flex flex-row justify-content-center mb-5 titulo-formulario ">
                        <div class="col-3 titul">
                            <div class="titul bg-primary d-flex justify-content-center align-items-center">
                                <h4>Asignar Documento</h4>
                            </div>

                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6 d-flex justify-content-center">
                            <div class="imagen-form">
                                <img src="${pageContext.request.contextPath}/images/asignar.png" class="img-doc img-fluid" alt="">
                            </div>
                        </div>

                        <div class="col-6 d-flex justify-content-center">
                            <div class="formulario">
                                <div class="body-form d-flex justify-content-center p-5 mt-5">
                                    <form action="${pageContext.request.contextPath}/ServletAsignaciones">
                                        <input type="hidden" name="accion" value="5">
                                        <input type="hidden" name="estado" value="Asignado">
                                        <input type="hidden" name="folio" value="${idocument}">
                                        <div class="mb-4">
                                            <label for="folio" class="form-label">Folio</label>
                                            <input id="folio" name="folio" value="${idocument}" type="text" class="form-control in-c" aria-label="Disabled input example" disabled readonly>
                                        </div>
                                        <div class="mb-4">
                                            <label for="auxiliar" class="form-label">Auxiliares </label>
                                            <select class="form-select in-c" aria-label="Default select example" id="auxiliar" name="auxiliar">

                                                <option selected>Seleccionar</option>
                                                <c:forEach items="${auxiliaresLista}" var="auxi" varStatus="status">
                                                <option value="${auxi.id_Empleado}">${auxi.nombre}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="boton d-flex justify-content-center mt-5">
                                            <button type="submit" class="btn btn-primary boton-enviar">Enviar</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</body>
</html>

