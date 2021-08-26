package com.siso.SisoWeb1.Oficialia.Controlador;

import com.siso.SisoWeb1.Oficialia.Modelo.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
@MultipartConfig
@WebServlet(name = "ServletDocArch", value = "/ServletDocArch")
public class ServletDocArch extends HttpServlet {

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


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String folio =request.getParameter("folio");
        int fol1 = Integer.parseInt(folio);


        String depart=request.getParameter("departamento");

        String  asunto=request.getParameter("asunto");



        Part archivo = request.getPart("archivo")!=null ? request.getPart("archivo"):null;
        String na= archivo.getSubmittedFileName();
        System.out.println( archivo.getSubmittedFileName());
        BeanDocumentos unDoc = new BeanDocumentos(fol1,asunto,depart,na ,archivo.getInputStream());
        unDoc.setNombreArchivo(archivo.getSubmittedFileName());
        System.out.println(unDoc);
        DaoDocumentos documentos = new DaoDocumentos();
        boolean result = documentos.newDoc(unDoc);
        if (result){

            System.out.println(result);

            System.out.println("FELICIDADES");
            daoDocumentos = new DaoDocumentos();
            documentosList = daoDocumentos.findAll();
            request.setAttribute("listaDocumentos", documentosList);


        }else {
            System.out.println("ERROR");
        }

        daoDocumentos = new DaoDocumentos();
        int todos =daoDocumentos.todosDocus();
        request.setAttribute("todoslos",todos);

        daoDocumentos = new DaoDocumentos();
        int totalDoc1 =daoDocumentos.docsAssi("Asignado");
        int docRes1 = daoDocumentos.docsAssi("Respondido");
        request.setAttribute("docRespon",docRes1);
        request.setAttribute("docAsi",totalDoc1);

        daoDocumentos = new DaoDocumentos();
        documentosList = daoDocumentos.findAll();
        request.setAttribute("listaDocumentos", documentosList);
        request.getRequestDispatcher("WEB-INF/views/Oficial/documentos.jsp").forward(request, response);

    }
}
