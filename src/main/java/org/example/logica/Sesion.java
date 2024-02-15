package org.example.logica;

public class Sesion {
    public Sesion() {
    }

    public String validarSesion(String usuario, String contrasenia){
        if(usuario.equalsIgnoreCase("admin") && contrasenia.equalsIgnoreCase("admin123")){
            return "admin";
        } else if (usuario.equalsIgnoreCase("user") && contrasenia.equalsIgnoreCase("user123")) {
            return "user";
        }else{
            System.out.print("Credenciales incorrectas");
            return null;
        }
    }
}
