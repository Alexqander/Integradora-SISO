package com.siso.SisoWeb1.Oficialia.Controlador;

import com.siso.SisoWeb1.Oficialia.Modelo.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletDepartamentos", value = "/ServletDepartamentos")
public class ServletDepartamentos extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String op = request.getParameter("op")!= null ? request.getParameter("op"): "---";
        System.out.println(op);


        switch (op){
            //Consultar Departamentos
            case"il":
                DaoDepartamentos daoDepartamentos = new DaoDepartamentos();
                List<BeanDepartamentos> departamentosList =daoDepartamentos.findAll() ;
                request.setAttribute("listadeptos",departamentosList);
                request.getRequestDispatcher("WEB-INF/views/superAdmin/departamentos.jsp").forward(request,response);

                break;
            //Crear un nuevo Departamento
            case "c":
                System.out.println(op);

                String nombredepto = request.getParameter("nombre")!= null ? request.getParameter("nombre"): "popo" ;
                String numeroedificio = request.getParameter("numeroEdificio")!= null ? request.getParameter("numeroEdificio") : "";
                int numeroEdificio =  Integer.parseInt(numeroedificio);

                BeanDepartamentos unDepartamento = new BeanDepartamentos(0,nombredepto,numeroEdificio);
                DaoDepartamentos daoDepartamentos1 = new DaoDepartamentos();
                boolean result = daoDepartamentos1.GuardarDepartamento(unDepartamento);

                if (result){
                    request.setAttribute("mensaje","Registro Correcto");
                }else{
                    request.setAttribute("mensaje","Registro Correcto");

                }
                request.getRequestDispatcher("WEB-INF/views/superAdmin/crearDepa.jsp").forward(request,response);

                break;

            //buscar Un departamento
            case"r":
                int idDep =0;
                try{
                    String idString = request.getParameter("idDepar") != null ? request.getParameter("idDepar") : "0";
                    idDep = Integer.parseInt(idString);
                }catch (Exception ex){
                    ex.printStackTrace();
                    idDep=0;
                }
                DaoDepartamentos dao = new DaoDepartamentos();
                BeanDepartamentos unCourse = dao.BuscarConId(idDep);
                request.setAttribute("course",unCourse);
                request.getRequestDispatcher("/WEB-INF/views/superAdmin/infodepa.jsp").forward(request,response);


                break;

            //modificar un Departamento
            case"u":

                break;

            //eliminar un departamento
            case "d":
                String id_dep = request.getParameter("iddep");
                int id_Dep =Integer.parseInt(id_dep);
                DaoDepartamentos daoDepartamento = new DaoDepartamentos();
                daoDepartamento.deleteDepa(id_Dep);
                op = "il";
                break;

            default:

                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        request.setCharacterEncoding("UTF-8");
        doGet(request,response);

    }
}
