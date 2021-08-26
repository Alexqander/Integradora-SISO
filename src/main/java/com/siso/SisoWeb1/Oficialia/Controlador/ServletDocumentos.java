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
                int todos =daoDocumentos.todosDocus();
                request.setAttribute("todoslos",todos);

                daoDocumentos = new DaoDocumentos();
                int totalDoc =daoDocumentos.docsAssi("Asignado");
                int docRes = daoDocumentos.docsAssi("Respondido");
                request.setAttribute("docRespon",docRes);
                request.setAttribute("docAsi",totalDoc);

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

                    daoDocumentos = new DaoDocumentos();
                    int totalDoc1 =daoDocumentos.docsAssi("Asignado");
                    int docRes1 = daoDocumentos.docsAssi("Respondido");
                    request.setAttribute("docRespon",docRes1);
                    request.setAttribute("docAsi",totalDoc1);

                    System.out.println("FELICIDADES");
                    daoDocumentos = new DaoDocumentos();
                    documentosList = daoDocumentos.findAll();
                    request.setAttribute("listaDocumentos", documentosList);

                }else {
                    System.out.println("ERROR");
                }

                daoDocumentos = new DaoDocumentos();
                int todos1 =daoDocumentos.todosDocus();
                request.setAttribute("todoslos",todos1);
                daoDocumentos = new DaoDocumentos();
                int totalDoc1 =daoDocumentos.docsAssi("Asignado");
                int docRes1 = daoDocumentos.docsAssi("Respondido");
                request.setAttribute("docRespon",docRes1);
                request.setAttribute("docAsi",totalDoc1);

                daoDocumentos = new DaoDocumentos();
                documentosList = daoDocumentos.findAll();
                request.setAttribute("listaDocumentos", documentosList);
                request.getRequestDispatcher("WEB-INF/views/Oficial/documentos.jsp").forward(request, response);
                break;
            //Modificar documento
            case "4":

                daoDocumentos = new DaoDocumentos();
                int todos2 =daoDocumentos.todosDocus();
                request.setAttribute("todoslos",todos2);

                daoDocumentos = new DaoDocumentos();
                int totalDoc2 =daoDocumentos.docsAssi("Asignado");
                int docRes2 = daoDocumentos.docsAssi("Respondido");
                request.setAttribute("docRespon",docRes2);
                request.setAttribute("docAsi",totalDoc2);
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
