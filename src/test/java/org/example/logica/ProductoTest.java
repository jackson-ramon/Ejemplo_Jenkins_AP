package org.example.logica;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)

public class ProductoTest {
    String codigo;
    String nombre;
    double precio;
    String distribuidor;
    int unidades;
    boolean expected;
    @Parameterized.Parameters
    public static Iterable<Object[]> parameters(){
        List<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{"0001","Ruffles Original",0.60,"Frito Lay",20,true});
        objects.add(new Object[]{"0002","Ruffles Crema y Cebolla",0.60,"Frito Lay",20,true});
        objects.add(new Object[]{"0003","Doritos Limón",0.60,"Frito Lay",15,true});
        return objects;
    }

    public ProductoTest(String codigo, String nombre, double precio, String distribuidor, int unidades, boolean expected) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.distribuidor = distribuidor;
        this.unidades = unidades;
        this.expected = expected;
    }

    @Test
    public void given_parameters_when_add_then_addition(){
        Producto p = new Producto(this.codigo,this.nombre,this.precio,this.distribuidor,this.unidades);
        assertEquals(expected,p.registrarProducto(p));
    }
}