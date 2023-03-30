package com.formacom.biblioteca.Modelos;

import com.formacom.biblioteca.bbdd.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    public static Usuario login(String dni,String nombre){
        Connection conn= Conexion.conectar();
        String consulta="select * from usuarios where dni=? and nombre=?";
        Usuario usuario=null;
        try {
            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1,dni);
            stm.setString(2,nombre);
            ResultSet resultado=stm.executeQuery();
            if(resultado.next()){
                usuario=new Usuario();
                usuario.setIdusuario(resultado.getInt("idusuario"));
                usuario.setNombre(resultado.getString("nombre"));
                usuario.setApellidos(resultado.getString("apellidos"));
                usuario.setEmail(resultado.getString("email"));
                stm.close();
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
}
