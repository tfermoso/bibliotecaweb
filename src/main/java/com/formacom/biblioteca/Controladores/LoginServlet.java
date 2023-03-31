package com.formacom.biblioteca.Controladores;

import com.formacom.biblioteca.Modelos.Login;
import com.formacom.biblioteca.Modelos.Usuario;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String dni = request.getParameter("dni");
            String nombre = request.getParameter("nombre");
            Usuario usuario = Login.login(dni, nombre);
            if (usuario == null) {
                request.setAttribute("msg", "Usuario no existe");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                HttpSession session = request.getSession(true);
                session.setAttribute("usuario", usuario);
                response.sendRedirect("main");
            }
        }catch (ServletException ex){
            request.setAttribute("msg", "Error interno, póngase en contacto con el administrador");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }catch (Exception e){
            request.setAttribute("msg", "Error interno, póngase en contacto con el administrador");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
