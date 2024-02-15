package org.example.vista;

import org.example.controlador.Controlador;
import org.example.logica.Producto;
import org.example.logica.Sesion;

import java.util.Scanner;

public class MenuGeneral {
    Scanner entrada = new Scanner(System.in);
    String opcionesMenu = "";
    int opcion = 0;
    public void iniciarSesion(){
        Sesion s = new Sesion();
        String usuario;
        String contrasenia;
        System.out.print("Usuario: ");
        usuario = entrada.next();
        System.out.print("Contraseña: ");
        contrasenia = entrada.next();
        if(s.validarSesion(usuario, contrasenia).equalsIgnoreCase("admin")) {
            opcionesMenu();
        }
    }
    public void opcionesMenu(){
        opcionesMenu += "***************MINIMARKET***************";
        opcionesMenu += "\n1. Inventario";
        opcionesMenu += "\n2. Ventas";
        opcionesMenu += "\n3. Informe";
        opcionesMenu += "\n4. Salir";
        opcionesMenu += "\nSeleccione una opción:";
        System.out.println(opcionesMenu);
        opcion = Integer.parseInt(entrada.next());
        switch (opcion){
            case 1:
                inventario();
                break;
            case 2:
                ventas();
                break;
            case 3:
                informe();
                break;
            case 4:
                break;
            default:
                System.out.println("Opción no válida");
                opcionesMenu();
                break;
        }
    }

    public void inventario(){
        MenuInventario mnI = new MenuInventario();
        opcionesMenu = "";
        opcionesMenu += "***************INVENTARIO***************";
        opcionesMenu += "\n1. Registrar producto";
        opcionesMenu += "\n2. Actualizar información del producto";
        opcionesMenu += "\n3. Eliminar productos menos comercializados";
        opcionesMenu += "\n4. Ver inventario";
        opcionesMenu += "\n5. Salir";
        opcionesMenu += "\nSeleccione una opción:";
        System.out.println(opcionesMenu);
        opcion = Integer.parseInt(entrada.next());
        switch (opcion){
            case 1:
                mnI.registrar();
                break;
            case 2:
                mnI.actualizarInfoProducto();
                break;
            case 3:
                /* Por implementar  Iteración 2*/
                break;
            case 4:
                Controlador con = new Controlador();
                for (Producto p : con.leerProductos()) {
                    System.out.println(p.toString());
                }
                inventario();
                break;
            case 5:
                opcionesMenu();
                break;
            default:
                System.out.println("Opción no válida");
                inventario();
                break;
        }
    }
    public void ventas(){

    }
    public void informe(){

    }
}
