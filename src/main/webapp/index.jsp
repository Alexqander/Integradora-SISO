<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <title>SISO LOGIN</title>
</head>
<body>

<div class="container-fluid p-0">
    <div class="row g-0">

        <!-- AQUI VA LA PARTE DEL LOGO  -->

        <div class="col-xl-6 col-sm-12 caja-logo d-flex align-items-center" >
            <div class="caja-img d-flex justify-content-center">
                <img src="${pageContext.request.contextPath}/images/Logo-siso.png" alt="" class="img-siso"></div>
        </div>

        <!-- ----------------------------------- -->

        <!-- AQUI INICIA LA SECCION PARA EL LOGIN DEL USUARIO -->

        <div class="col-xl-6 col-sm-12 caja-login d-flex align-items-center justify-content-center">
            <div class="container-fluid contenedor-log">

                <div class="row">
                </div>
                <div class="row head">
                    <div class="col d-flex justify-content-center  contenedor-img">
                        <img src="${pageContext.request.contextPath}/images/usuario-login.png" alt="" class="img-usu">
                    </div>
                </div>
                <div class="row body">

                    <div class="col d-flex justify-content-center">

                        <form class="" action="">
                            <div class="in-usuario mt-2">
                                <div class="label d-flex justify-content-center">
                                    <label for=""><h6>Usuario</h6></label>
                                </div>
                                <input class="form-control ingrese" type="text" placeholder="ingrese su correo">
                            </div>
                            <div class="in-contraseña mt-2">
                                <div class="label d-flex justify-content-center">
                                    <label for=""><h6>Contraseña</h6></label>
                                </div>
                                <input class="form-control ingrese" type="password" placeholder="ingrese su contraseña">
                            </div>
                            <div class="cajabtn col d-flex justify-content-center">
                                <button  class="btn btn-iniciar btn-primary" type="submit" >Iniciar</button>
                            </div>

                        </form>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>