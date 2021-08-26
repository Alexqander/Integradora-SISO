package com.siso.SisoWeb1.Oficialia.Controlador;

import com.siso.SisoWeb1.Oficialia.Modelo.BeanEmpleados;
import com.siso.SisoWeb1.Oficialia.Modelo.BeanUsuarios;
import com.siso.SisoWeb1.Oficialia.Modelo.DaoEmpleados;
import com.siso.SisoWeb1.Oficialia.Modelo.DaoUsuarios;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletLogin", value = "/ServletLogin")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username") !=null ? request.getParameter("username") : "-";
        String password = request.getParameter("password") !=null ? request.getParameter("password"):"-";

        System.out.println(username);
        System.out.println(password);

        DaoUsuarios daoUsuarios = new DaoUsuarios();
        BeanUsuarios user = daoUsuarios.login(username,password);

        if(user.getIduser()>0){

                System.out.println(user.getUsername());
                System.out.println(user.getPassword());
                System.out.println(user.getRol());
                System.out.println(user.getNombre());

                HttpSession session = request.getSession(true);
                session.setAttribute("login", "ok");
                session.setAttribute("nameUser",user.getNombre());
                session.setAttribute("rol", user.getRol());
                session.setAttribute("idUsuario",user.getId_empleadoU());
                session.setAttribute("departamento",user.getDepa());

                if (user.getRol().equals("Admin")){

                    request.getRequestDispatcher("WEB-INF/views/superAdmin/inicioSuperAd.jsp").forward(request,response);

                }if (user.getRol().equals("Oficialia")){
                request.getRequestDispatcher("WEB-INF/views/Oficial/inicioOficial.jsp").forward(request,response);

                }if (user.getRol().equals("Jefe de departamento")){

                int empl = user.getIduser();
                DaoEmpleados dao = new DaoEmpleados();
                BeanEmpleados jefe = dao.BuscarConId(empl);
                request.setAttribute("empleado",jefe);

                request.getRequestDispatcher("WEB-INF/views/repre/inicioRepresentante.jsp").forward(request,response);

                }if (user.getRol().equals("Auxiliar de departamento")){
                request.getRequestDispatcher("WEB-INF/views/Auxiliar/inicioAuxiliar.jsp").forward(request,response);
                }else{
                request.setAttribute("codigo","error 422 no se pudo redireccionar");
                }
            }else {
            request.setAttribute("message", "Usuario o contraseña incorrectos");
            request.getRequestDispatcher("index.jsp").forward(request,response);

        }

    }
}
