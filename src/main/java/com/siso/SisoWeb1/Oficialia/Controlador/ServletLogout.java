package com.siso.SisoWeb1.Oficialia.Controlador;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletLogout", value = "/ServletLogout")
public class ServletLogout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        session.invalidate();
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }
}
