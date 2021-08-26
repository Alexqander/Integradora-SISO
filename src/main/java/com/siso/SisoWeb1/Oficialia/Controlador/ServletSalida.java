package com.siso.SisoWeb1.Oficialia.Controlador;

import com.siso.SisoWeb1.Oficialia.Modelo.BeanDocumentos;
import com.siso.SisoWeb1.Oficialia.Modelo.DaoDocumentos;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

@WebServlet(name = "ServletSalida", value = "/ServletSalida")
public class ServletSalida extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            ServletOutputStream out = response.getOutputStream();
            String id = request.getParameter("id")!=null? request.getParameter("id"): "";
            DaoDocumentos documentos = new DaoDocumentos();
            BeanDocumentos pdf = documentos.getPdf(Integer.parseInt(id));
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition",  "inline; filename="+ pdf.getNombreArchivo());

            InputStream in = null;
            in = pdf.getArchivo1().getBinaryStream();
            int length = (int)pdf.getArchivo1().length();
            int buffeerzise = 500000;
            byte[] buffer = new byte[buffeerzise];

            while ((length = in.read(buffer))!=-1){

                out.write(buffer,0,length);

            }

            in.close();
            out.flush();

        }catch (IOException | SQLException ex){
            ex.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
}
