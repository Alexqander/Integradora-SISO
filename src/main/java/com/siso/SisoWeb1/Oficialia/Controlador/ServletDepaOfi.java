package com.siso.SisoWeb1.Oficialia.Controlador;

import com.siso.SisoWeb1.Oficialia.Modelo.BeanDepartamentos;
import com.siso.SisoWeb1.Oficialia.Modelo.DaoDepartamentos;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletDepaOfi", value = "/ServletDepaOfi")
public class ServletDepaOfi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        DaoDepartamentos daoDepartamentos;
        List<BeanDepartamentos> departamentosList;

        String op = request.getParameter("op")!= null ? request.getParameter("op"): "---";
        System.out.println(op);

        switch (op){
            //consultar departamentos
            case "1":
                daoDepartamentos = new DaoDepartamentos();
                departamentosList = daoDepartamentos.findAll();
                request.setAttribute("listadepartamentos",departamentosList);
                System.out.println(departamentosList);
                request.getRequestDispatcher("WEB-INF/views/Oficial/departamentos-Of.jsp").forward(request,response);
                break;
            case "2":
                break;
            case "3":
                break;
            default:
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
