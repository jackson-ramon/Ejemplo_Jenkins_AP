package org.example.vista;

import org.example.controlador.Controlador;
import org.example.logica.Producto;

import java.util.Scanner;

public class MenuInventario {
    MenuGeneral m = new MenuGeneral();
    Scanner entrada = new Scanner(System.in);
    String opcionesMenu = "";
    Controlador con = new Controlador();


    public void registrar(){
        System.out.println("***************REGISTRAR PRODUCTO***************");
        System.out.print("Código: ");
        String codigo = entrada.nextLine();
        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Precio: ");
        Double precio = Double.parseDouble(entrada.nextLine());
        System.out.print("Distribuidor: ");
        String distribuidor = entrada.nextLine();
        System.out.print("Unidades: ");
        int unidades = Integer.parseInt(entrada.nextLine());
        Producto producto = new Producto(codigo,nombre,precio,distribuidor,unidades);
        if(validarRegistro(producto)){
            System.out.println("Producto registrado con éxito");
            m.inventario();
        }
    }

    public boolean validarRegistro(Producto p) {
        if(!p.evitarDuplicados(p) && p.registrarProducto(p)){
            return true;
        }else{
            System.out.println("Error: El producto ya existe");
            m.inventario();
        }
        return false;
    }

    public void actualizarInfoProducto(){
        System.out.println("***************ACTUALIZAR INFORMACIÓN DE UN PRODUCTO***************");
        opcionesMenu += "1. Actualizar nombre";
        opcionesMenu += "\n2. Actualizar precio";
        opcionesMenu += "\n3. Actualizar distribuidor";
        opcionesMenu += "\n4. Actualizar unidades";
        opcionesMenu += "\n5. Salir";
        opcionesMenu += "\nSeleccione una opción:";
        System.out.println(opcionesMenu);
        int opcion = Integer.parseInt(entrada.nextLine());
        ejecutarActualizaciones(opcion);
    }

    public boolean ejecutarActualizaciones(int opcion) {
        String codigoA = "";
        switch (opcion) {
            case 1:
                System.out.println("Ingrese el código del producto:");
                codigoA = entrada.nextLine();
                System.out.println("Ingrese el nuevo nombre del producto:");
                String nombreA = entrada.nextLine();
                con.actualizarNombre(codigoA, nombreA);
                m.inventario();
                return true;
            case 2:
                System.out.println("Ingrese el código del producto:");
                codigoA = entrada.nextLine();
                System.out.println("Ingrese el nuevo precio del producto:");
                double precioA = Double.parseDouble(entrada.nextLine());
                con.actualizarPrecio(codigoA, precioA);
                m.inventario();
                return true;
            case 3:
                System.out.println("Ingrese el código del producto:");
                codigoA = entrada.nextLine();
                System.out.println("Ingrese el nuevo distribuidor del producto:");
                String distribuidorA = entrada.nextLine();
                con.actualizarDistribuidor(codigoA, distribuidorA);
                System.out.println("La información ha sido actualizada correctamente");
                m.inventario();
                return true;
            case 4:
                System.out.println("Ingrese el código del producto:");
                codigoA = entrada.nextLine();
                System.out.println("Ingrese las nuevas unidades para el producto:");
                int unidadesA = Integer.parseInt(entrada.nextLine());
                con.actualizarUnidades(codigoA, unidadesA);
                System.out.println("La información ha sido actualizada correctamente");
                m.inventario();
                return true;
            case 5:
                m.inventario();
                break;
            default:
                System.out.println("Opción no válida");
                m.inventario();
                return false;
        }
        return false;
    }
}
