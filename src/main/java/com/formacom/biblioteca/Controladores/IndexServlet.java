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
        for (int i = 0; i < libros.size(); i++) {
            System.out.println(libros.get(i).getTitulo());
        }
        Libro libro=new Libro();
        libro.setId(44);
        libro.setTitulo("hola");
        libro.setCodigo("asdf");
        libro.setGenero("algo");
        //libros.add(libro);

        try {
            request.setAttribute("saludo","hola");

            request.getRequestDispatcher("index.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}