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

    }
}
