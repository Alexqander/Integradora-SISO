package com.siso.SisoWeb1.Oficialia.Controlador;

import com.siso.SisoWeb1.HelloServlet;
import com.siso.SisoWeb1.Oficialia.Modelo.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;


@WebServlet(name = "ServletDocumentos", value = "/ServletDocumentos")
@MultipartConfig
public class ServletDocumentos extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");


        String accion = request.getParameter("accion")!= null ? request.getParameter("accion"): "---";
        System.out.println(accion);
        //cargo las listas principales
        //departamentos
        DaoDepartamentos daoDepartamentos;
        List<BeanDepartamentos> departamentosList;
        //empleados
        DaoEmpleados daoEmpleados;
        List<BeanEmpleados> empleadosList;
        //estado documento
        DaoEstadoDocumento daoEstadoDocumento;
        List<BeanEstadoDocumento> estadoDocumentoList;
        //documentos
        DaoDocumentos daoDocumentos;
        List<BeanDocumentos> documentosList;



        switch (accion) {
            //Consultar documentos
            case "1":

                daoDocumentos = new DaoDocumentos();
                documentosList = daoDocumentos.findAll();
                request.setAttribute("listaDocumentos", documentosList);
                request.getRequestDispatcher("WEB-INF/views/Oficial/documentos.jsp").forward(request, response);
                break;
            //Cargar listas para crear documento
            case "2":

                daoEmpleados = new DaoEmpleados();
                empleadosList = daoEmpleados.findAll();
                request.setAttribute("listaEmpl",empleadosList);

                daoDepartamentos = new  DaoDepartamentos();
                departamentosList = daoDepartamentos.findAll();
                request.setAttribute("listadeptos",departamentosList);

                request.getRequestDispatcher("WEB-INF/views/Oficial/nuevo-doc.jsp").forward(request, response);
                break;
            //crear documento
            case "3":




                String folio =request.getParameter("folio");
                String depart=request.getParameter("departamento");
                String  asunto=request.getParameter("asunto");
                String empl = request.getParameter("empleado");
                int folioD = Integer.parseInt(folio);
                int empleado = Integer.parseInt(empl);
                Part archivo = request.getPart("archivo")!=null ? request.getPart("archivo"):null;
                BeanDocumentos unDoc = new BeanDocumentos(folioD,asunto,depart,empleado,archivo.getInputStream());
                System.out.println(unDoc);
                DaoDocumentos documentos = new DaoDocumentos();
                boolean result = documentos.newDoc(unDoc);
                if (result){

                    System.out.println("FELICIDADES");
                    daoDocumentos = new DaoDocumentos();
                    documentosList = daoDocumentos.findAll();
                    request.setAttribute("listaDocumentos", documentosList);

                }else {
                    System.out.println("ERROR");
                }



                daoDocumentos = new DaoDocumentos();
                documentosList = daoDocumentos.findAll();
                request.setAttribute("listaDocumentos", documentosList);
                request.getRequestDispatcher("WEB-INF/views/Oficial/documentos.jsp").forward(request, response);
                break;
            //Modificar documento
            case "4":

                request.getRequestDispatcher("WEB-INF/views/Oficial/documentos.jsp").forward(request, response);
                break;

            //eliminar documento
            case "5":


                request.getRequestDispatcher("WEB-INF/views/Oficial/docuementos.jsp").forward(request, response);
                break;
            //Ver el archivo

            case "6":
                break;

            //Acciones para el auxiliar
            //VER LOS DOCUMENTOS QUE TIENE ASIGNADOS
            case "a1":
                String idAux = request.getParameter("idaux");
                int auxil = Integer.parseInt(idAux);
                System.out.println(auxil);

                DaoDocumentos daoAuxiliar = new DaoDocumentos();
                List<BeanDocumentos> auxiliarList = daoAuxiliar.findAux(auxil);
                request.setAttribute("listaAuxiliar",auxiliarList);


                request.getRequestDispatcher("WEB-INF/views/Auxiliar/docAux.jsp").forward(request, response);
                break;
            case "a2":

                request.getRequestDispatcher("WEB-INF/views/Auxiliar/respuesta.jsp").forward(request, response);
                break;

                //Acciones del representante


            //CONSULTAR SUS DOCUMENTOS
            case "r1":


                request.getRequestDispatcher("WEB-INF/views/repre/VistaDepartamento.jsp").forward(request, response);
                break;


                //ASIGNAR UN DOCUMENTO A UN AUXILIAR DE SU DEPARTAMENTO
                //PRIMERO CARGO LA LISTA DE AUXILIARES DEL DEPARTAMENTO PARA ASIGNARLE EL OFICIO Y DIRECCIONO AL FORMULARIO
            case "r2":
                String codigo = request.getParameter("codDoc");
                int fol = Integer.parseInt(codigo);


                request.setAttribute("folio",fol);
                request.getRequestDispatcher("WEB-INF/views/repre/asignar.jsp").forward(request,response);
                break;


                //MANDO LOS DATOS PARA EJECUTAR LA ASIGNACION
            case "r3":
                String folid =request.getParameter("folio");
                String aux = request.getParameter("auxiliar");
                int folioId = Integer.parseInt(folid);
                int idEmpleado = Integer.parseInt(aux);





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
