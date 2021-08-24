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

        DaoDepartamentos daoDepartamentos;
        List<BeanDepartamentos> departamentosList;

        String op = request.getParameter("op")!= null ? request.getParameter("op"): "---";
        System.out.println(op);


        switch (op){
            //Consultar Departamentos
            case"il":
                daoDepartamentos = new DaoDepartamentos();
                departamentosList = daoDepartamentos.findAll();
                request.setAttribute("listadepartamentos",departamentosList);
                System.out.println(departamentosList);
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

                if(result){
                    request.setAttribute("mensaje","Registro Correcto");
                }else{
                    request.setAttribute("mensaje","Registro Correcto");

                }
                request.getRequestDispatcher("WEB-INF/views/superAdmin/crearDepa.jsp").forward(request,response);

                break;

            //buscar Un departamento
            case"r":
                System.out.println(request.getParameter("nodep"));
                int identificador =0;
                try{
                    String idString = request.getParameter("nodep") != null ? request.getParameter("nodep") : "0";
                    identificador = Integer.parseInt(idString);
                }catch (Exception ex){
                    ex.printStackTrace();
                    identificador=0;
                }
                DaoDepartamentos dao = new DaoDepartamentos();
                BeanDepartamentos undepa = dao.BuscarConId(identificador);
                request.setAttribute("department",undepa);
                System.out.println(undepa);
                request.getRequestDispatcher("/WEB-INF/views/superAdmin/modificarDepa.jsp").forward(request,response);


                break;

            //modificar un Departamento
            case"u":

                String numero = request.getParameter("cursor")!=null? request.getParameter("cursor"):"0" ;
                String nombreD = request.getParameter("nombre")!=null? request.getParameter("nombre"):"--" ;
                String edif = request.getParameter("edificio")!=null? request.getParameter("edifici"):"0" ;
                System.out.println(numero);
                System.out.println(nombreD);

                try {
                    int id = Integer.parseInt(numero);
                    System.out.println("numero = "+ id);
                    int edificio = Integer.parseInt(edif);
                    System.out.println("el edificio es el " + edificio);
                    BeanDepartamentos un1Departamento = new BeanDepartamentos(id,nombreD,edificio);
                    System.out.println( "aqui vamos " + un1Departamento);
                    DaoDepartamentos daoUpdates = new DaoDepartamentos();
                    boolean resulta =daoUpdates.ModificarDepartamento(un1Departamento);
                    if (resulta){
                        List<BeanDepartamentos>departamentoslista = daoUpdates.findAll();
                        request.setAttribute("listadepartamentos",departamentoslista);
                        request.getRequestDispatcher("/WEB-INF/views/superAdmin/departamentos-Of.jsp").forward(request,response);

                    }else {
                        request.setAttribute("mensaje","Error al Actualizar");
                        System.out.println("error al actualizar");
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                request.setAttribute("mensaje","Error al intentar parsear");
                System.out.println("error al parsear");
                System.out.println( "este es el valor" + numero);
                request.getRequestDispatcher("/WEB-INF/views/superAdmin/inicioSuperAd.jsp").forward(request,response);
                break;

            //eliminar un departamento
            case "de":
                int idDepartamento =0;
                String numeroDepartamento = request.getParameter("nodep")!=null? request.getParameter("nodep"):"0";
                idDepartamento =Integer.parseInt(numeroDepartamento);

                BeanDepartamentos undepartamento = new BeanDepartamentos();
                DaoDepartamentos daoDepa = new DaoDepartamentos();
                boolean res = daoDepa.deleteDepa(idDepartamento);

                if (res){

                    System.out.println("ERROR");

                }else
                    System.out.println("DEPARTAMENTO ELLIMINADO");
                List<BeanDepartamentos>departamentoslista = daoDepa.findAll();
                request.setAttribute("listadepartamentos",departamentoslista);
                request.getRequestDispatcher("/WEB-INF/views/superAdmin/departamentos-Of.jsp").forward(request,response);

            default:

                request.getRequestDispatcher("/WEB-INF/views/superAdmin/departamentos-Of.jsp").forward(request,response);


                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        doGet(request,response);

    }
}
