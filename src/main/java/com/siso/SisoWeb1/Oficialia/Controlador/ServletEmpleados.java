package com.siso.SisoWeb1.Oficialia.Controlador;

import com.siso.SisoWeb1.Oficialia.Modelo.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletEmpleados", value = "/ServletEmpleados")
public class ServletEmpleados extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String op = request.getParameter("op")!= null ? request.getParameter("op"): "---";

        DaoDepartamentos daoDepartamentos;
        List<BeanDepartamentos> departamentosList;

        DaoCargos daoCargos;
        List<BeanCargos> cargosList;

        System.out.println(op);

        switch (op){
            //Consultar los departamentos y cargos
            case"il":
                daoDepartamentos = new DaoDepartamentos();
                departamentosList = daoDepartamentos.findAll();
                request.setAttribute("listadeptos",departamentosList);
                daoCargos = new DaoCargos();
                cargosList = daoCargos.findAll();
                request.setAttribute("listacargos",cargosList);
                request.getRequestDispatcher("WEB-INF/views/superAdmin/CrearUsuario.jsp").forward(request,response);
              break;
               //Crear un nuevo empleado
            case "c":
                System.out.println(op);
                String idEmpleado = request.getParameter("idempleado")!= null ? request.getParameter("idempleado"): "" ;
                String cargo = request.getParameter("cargo")!= null ? request.getParameter("cargo") : "";
                String depto =request.getParameter("departamento")!=null? request.getParameter("departamento") :"";
                String contraseña =request.getParameter("contraseña")!=null? request.getParameter("contraseña") :"";
                String nombre =request.getParameter("nombre")!=null? request.getParameter("nombre") :"";
                String apellidoPaterno =request.getParameter("apellidopaterno")!=null? request.getParameter("apellidopaterno") :"";
                String apellidoMaterno =request.getParameter("apellidomaterno")!=null? request.getParameter("apellidomaterno") :"";
                String email =request.getParameter("correo")!=null? request.getParameter("correo") :"";
                int id_Empleado =  Integer.parseInt(idEmpleado);


                BeanEmpleados unempleado = new BeanEmpleados(0, id_Empleado,cargo,depto,contraseña,nombre,apellidoPaterno,apellidoMaterno,email);
                DaoEmpleados daoEmpleados = new DaoEmpleados();
                boolean result = daoEmpleados.saveEmpleado(unempleado);

                if (result){


                    request.setAttribute("mensaje1","Usuario Registrado");
                    DaoEmpleados daoEmpleados2 =new DaoEmpleados();
                    List<BeanEmpleados> empleadosList = daoEmpleados2.findAll();
                    request.setAttribute("listaempleados",empleadosList);
                    request.getRequestDispatcher("WEB-INF/views/superAdmin/listaUsuarios.jsp").forward(request,response);


                    break;
                }else{
                    request.setAttribute("valor","2");
                    request.setAttribute("mensaje","Error al Registrar Usuario");

                    daoDepartamentos = new DaoDepartamentos();
                    departamentosList = daoDepartamentos.findAll();
                    request.setAttribute("listadeptos",departamentosList);
                    daoCargos = new DaoCargos();
                    cargosList = daoCargos.findAll();
                    request.setAttribute("listacargos",cargosList);
                    request.getRequestDispatcher("WEB-INF/views/superAdmin/Us-Cr.jsp").forward(request,response);

                }
                request.getRequestDispatcher("WEB-INF/views/superAdmin/CrearUsuario.jsp").forward(request,response);
                break;

            //buscar especificamento a un empleado
            case"r":

                int idEmploy = 0;
                try{
                    String idString = request.getParameter("valor")!=null? request.getParameter("valor") :"0";
                    idEmploy = Integer.parseInt(idString);
                    System.out.println(idEmploy);
                }catch (Exception ex){
                    ex.printStackTrace();
                    idEmploy =0;
                }

                DaoEmpleados dao = new DaoEmpleados();
                BeanEmpleados trabajador = dao.BuscarConId(idEmploy);
                request.setAttribute("employed",trabajador);

                daoDepartamentos = new DaoDepartamentos();
                departamentosList = daoDepartamentos.findAll();
                request.setAttribute("listadeptos",departamentosList);
                daoCargos = new DaoCargos();
                cargosList = daoCargos.findAll();
                request.setAttribute("listacargos",cargosList);

                request.getRequestDispatcher("/WEB-INF/views/superAdmin/PerfilUsuario.jsp").forward(request,response);

                break;

            //modificar un empleado
            case"u":

                String idE = request.getParameter("valor")!= null ? request.getParameter("valor"): "0" ;
                System.out.println(idE);
                String idEmple = request.getParameter("valor1")!= null ? request.getParameter("valor1"): "la cagaste" ;
                System.out.println(idEmple);
                String cargo1 = request.getParameter("cargo")!= null ? request.getParameter("cargo") : "";
                String depto1 =request.getParameter("departamento")!=null? request.getParameter("departamento") :"";
                String contraseña1 =request.getParameter("contraseña")!=null? request.getParameter("contraseña") :"";
                String nombre1 =request.getParameter("nombre")!=null? request.getParameter("nombre") :"";
                String apellidoPaterno1 =request.getParameter("apellidopaterno")!=null? request.getParameter("apellidopaterno") :"";
                String apellidoMaterno1 =request.getParameter("apellidomaterno")!=null? request.getParameter("apellidomaterno") :"";
                String email1 =request.getParameter("correo")!=null? request.getParameter("correo") :"";
                try {
                    int idep =Integer.parseInt(idE);
                    System.out.println();
                    int idePer = Integer.parseInt(idEmple);
                    BeanEmpleados unemploy = new BeanEmpleados(idep,idePer,cargo1,depto1,contraseña1,nombre1,apellidoPaterno1,apellidoMaterno1,email1 );
                    System.out.println(" este es el empleado" + unemploy);
                    DaoEmpleados daoUpdate =new  DaoEmpleados();
                    boolean resulta = daoUpdate.modificarUsuario(unemploy);

                    if (resulta){
                        request.setAttribute("mensaje","Actualizacion Correcta");
                        System.out.println("registro modificado");
                        List<BeanEmpleados> empleadosList = daoUpdate.findAll();
                        request.setAttribute("listaempleados",empleadosList);
                        request.getRequestDispatcher("WEB-INF/views/superAdmin/listaUsuarios.jsp").forward(request,response);
                        break;
                    }else{
                        request.setAttribute("mensaje","Error al Actualizar");
                        System.out.println("error al actualizar");
                    }
                }catch (Exception ex){
                    ex.printStackTrace();

                }

                request.setAttribute("mensaje","Error al intentar parsear");
                System.out.println("error al parsear");
                request.getRequestDispatcher("/WEB-INF/views/superAdmin/inicioSuperAd.jsp").forward(request,response);

                break;

            //eliminar un empleado
            case "d":

                int id_Emple =0;
                String id_emple = request.getParameter("valor");
                id_Emple =Integer.parseInt(id_emple);

                BeanEmpleados unEmpleador = new BeanEmpleados();
                DaoEmpleados daoEmpleado1 = new DaoEmpleados();
                boolean resultado = daoEmpleado1.deleteUser(id_Emple);

                if (resultado){

                    System.out.println("ERROR");

                }else
                    System.out.println("USUARIO ELIMINADO");
                  List<BeanEmpleados> empleadosLista = daoEmpleado1.findAll();
                 request.setAttribute("listaempleados",empleadosLista);
                 request.getRequestDispatcher("/WEB-INF/views/superAdmin/listaUsuarios.jsp").forward(request,response);

                break;

                //ver todos los empleados

            case "rr":
                DaoEmpleados daoEmpleados2 =new DaoEmpleados();
                List<BeanEmpleados> empleadosList = daoEmpleados2.findAll();
                request.setAttribute("listaempleados",empleadosList);
                System.out.println(empleadosList);
                request.getRequestDispatcher("WEB-INF/views/superAdmin/listaUsuarios.jsp").forward(request,response);
                break;
            default:

                break;

        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request,response);
    }



}
