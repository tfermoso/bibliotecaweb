package com.formacom.biblioteca.Controladores;

import java.io.*;
import java.util.List;

import com.formacom.biblioteca.Modelos.Biblioteca;
import com.formacom.biblioteca.Modelos.Libro;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "indexServlet", value = "/main")
public class  IndexServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Biblioteca biblioteca=new Biblioteca();
        List<Libro> libros = biblioteca.getAllLibros();
        HttpSession session = request.getSession(true);
        session.setAttribute("nombre", "Juan");
        try {
            request.setAttribute("libros",libros);
            request.getRequestDispatcher("libros.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String titulo=req.getParameter("titulo");
        String genero=req.getParameter("genero");
        String codigo=req.getParameter("codigo");
        Biblioteca biblioteca=new Biblioteca();
        biblioteca.addLibro(titulo,codigo,genero);
        resp.sendRedirect("main");

    }
}