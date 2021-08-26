package com.siso.SisoWeb1.Oficialia.Controlador;

import com.mysql.cj.Session;
import com.siso.SisoWeb1.Oficialia.Modelo.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletAsignaciones", value = "/ServletAsignaciones")
public class ServletAsignaciones extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion")!=null? request.getParameter("accion") :"";
        System.out.println(accion);
        String dp =request.getParameter("depa")!=null? request.getParameter("depa") :"la cagaste";



        //CARGO TODAS LAS LISTAS EN GLOBAL

        //LISTA DE EMPLEADOS
        DaoEmpleados daoEmpleados;
        List<BeanEmpleados> listaEmpleados;

        List<BeanEmpleados>ListaRperesentante;



        //LISTA DOCUMENTOS
        DaoDocumentos daoDocumentos;
        List<BeanDocumentos> listaDocumentos;
        List<BeanDocumentos>listaRp;
        List<BeanDocumentos>listaAuxlilar;


        //LISTA DE DEPARTAMENTOS
        DaoDepartamentos daoDepartamentos;
        List<BeanDepartamentos> departamentosList;




        switch (accion){
            //Acciones del AUXILIAR
            case "1":
                //ver sus documentos que tiene accinados
                int ide =0;
                String i = request.getParameter("i")!=null?request.getParameter("i"):"mamaste";
                ide=Integer.parseInt(i);

                DaoAux dao =new DaoAux();
                List<BeanDocumentos>auxList =dao.findAll(ide) ;
                request.setAttribute("listaAux",auxList);

                request.getRequestDispatcher("/WEB-INF/views/Auxiliar/docAux.jsp").forward(request,response);


                break;
            case "2":
                //cargar un formulario para que pueda enviar su respuesta
                String folDocu1 =request.getParameter("folio");
                String idAux1 =request.getParameter("auxiliar");
                String estado1 ="Respondido";
                BeanDocumentos docAsig1 = new BeanDocumentos(Integer.parseInt(folDocu1),Integer.parseInt(idAux1),estado1);
                DaoAux reasig =new DaoAux();
                boolean resp =reasig.asignar(docAsig1);
                if (resp){
                    System.out.println(resp);

                    request.getRequestDispatcher("/WEB-INF/views/Auxiliar/respuesta.jsp").forward(request,response);
                    break;

                }else {
                    request.setAttribute("mensaje","Error al Actualizar");
                    System.out.println("error al actualizar");
                }


                break;
                //Acciones del Representante
            case "3":
                //vista del departamento

                String dp1 =request.getParameter("depa")!=null? request.getParameter("depa") :"la cagaste";
                String cargo ="Auxiliar de departamento";
                DaoAux daoRP =new DaoAux();
                List<BeanDocumentos>rpList =daoRP.findDp(dp) ;
                request.setAttribute("listaDepa",rpList);

                DaoAux daoax =new DaoAux();
                List<BeanEmpleados>listAuxis =daoax.findAux(cargo,dp) ;
                request.setAttribute("auxiliaresLista",listAuxis);

                request.getRequestDispatcher("/WEB-INF/views/repre/VistaDepartamento.jsp").forward(request,response);

                break;
                //mandar a un formulario para asignar el documento
            case "4":
               //primero obtengo los datos del jefe para tener el departamento

                String codigo = request.getParameter("codDoc");
                int fol = Integer.parseInt(codigo);
                request.setAttribute("idocument",fol);
                String cargo1 ="Auxiliar de departamento";
                String dpa =request.getParameter("depa");


                DaoAux daoAux =new DaoAux();
                List<BeanEmpleados>listAux =daoAux.findAux(cargo1,dpa) ;
                request.setAttribute("auxiliaresLista",listAux);
                request.getRequestDispatcher("WEB-INF/views/repre/asignar.jsp").forward(request,response);
                break;
            case "5":
                String folDocu =request.getParameter("folio");
                String idAux =request.getParameter("auxiliar");
                String estado =request.getParameter("estado");
                BeanDocumentos docAsig = new BeanDocumentos(Integer.parseInt(folDocu),Integer.parseInt(idAux),estado);
                DaoAux reasig1 =new DaoAux();
                boolean res =reasig1.asignar(docAsig);
                if (res){

                    request.getRequestDispatcher("/WEB-INF/views/repre/rasig.jsp").forward(request,response);
                    break;

                }else {
                    request.setAttribute("mensaje","Error al Actualizar");
                    System.out.println("error al actualizar");
                }

                request.getRequestDispatcher("/WEB-INF/views/repre/asignar.jsp").forward(request,response);


                break;
            case "6":
                break;
        }










    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        doGet(request,response);

    }
}
