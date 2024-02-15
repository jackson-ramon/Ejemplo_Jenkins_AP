package org.example.logica;

import org.example.controlador.Controlador;

import java.util.ArrayList;
import java.util.List;

public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private String distribuidor;
    private int unidades;
    List<Producto> listaProductos = new ArrayList<>();
    Controlador controlador = new Controlador();

    public Producto() {
    }

    public Producto(String codigo, String nombre, double precio, String distribuidor, int unidades) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.distribuidor = distribuidor;
        this.unidades = unidades;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(String distribuidor) {
        this.distribuidor = distribuidor;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public boolean registrarProducto(Producto p){
        if (controlador.registrarProducto(p.getCodigo(), p.getNombre(), p.getPrecio(),p.getDistribuidor(),p.unidades)){
            return true;
        }
        return false;
    }

    public boolean evitarDuplicados(Producto p){
        listaProductos = controlador.controlarRepetidos();
        for (Producto productoB : listaProductos) {
            if (productoB.getNombre().equalsIgnoreCase(p.nombre)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String formatoProducto = codigo + "     " + nombre + "      " + precio + "      " + distribuidor + "        " +
                unidades;
        return formatoProducto;
    }
}
