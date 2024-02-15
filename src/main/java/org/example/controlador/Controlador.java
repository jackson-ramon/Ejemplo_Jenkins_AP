package org.example.controlador;

import org.example.logica.Producto;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class Controlador {
    public List<Producto> leerProductos() {
        String rutaArchivo = "productos_minimarket.txt";
        List<Producto> listProductos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length >= 5) {
                    String codigo = campos[0].trim();
                    String nombre = campos[1].trim();
                    double precio = Double.parseDouble(campos[2].trim());
                    String distribuidor = campos[3].trim();
                    int unidades = Integer.parseInt(campos[4].trim());

                    Producto producto = new Producto(codigo, nombre, precio, distribuidor, unidades);
                    listProductos.add(producto);
                }
            }
        } catch (IOException e) {
        }
        return listProductos;
    }

    public List<Producto> controlarRepetidos() {
        String rutaArchivo = "productos_minimarket.txt";
        // Verificar si el archivo no existe y crearlo en caso necesario
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
            }
        }
        List<Producto> listaProductos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length >= 5) {
                    String codigo = campos[0].trim();
                    String nombre = campos[1].trim();
                    double precio = Double.parseDouble(campos[2].trim());
                    String distribuidor = campos[3].trim();
                    int unidades = Integer.parseInt(campos[4].trim());

                    Producto producto = new Producto(codigo, nombre, precio, distribuidor, unidades);
                    listaProductos.add(producto);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaProductos;
    }

    public boolean registrarProducto(String codigo, String nombre, double precio, String distribuidor, int unidades) {
        String rutaArchivo = "productos_minimarket.txt";
        // Verificar si el archivo no existe y crearlo en caso necesario
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                return false;
            }
        }
        // Registrar el producto en el archivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            StringBuilder sb = new StringBuilder();
            sb.append(codigo).append(",").append(nombre).append(",").append(precio).append(",")
                    .append(distribuidor).append(",").append(unidades);
            bw.newLine();
            bw.write(sb.toString());
            return true;
        } catch (IOException e) {
            return false;
        }
    }


    public void actualizarNombre(String codigo, String nuevoNombre) {
        String rutaArchivo = "productos_minimarket.txt";
        String archivoTemporal = "productos_minimarket_tmp.txt";

        // Actualizar el nombre del producto en el archivo
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
             BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemporal))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length >= 5 && campos[0].trim().equals(codigo)) {
                    campos[1] = nuevoNombre;
                }

                bw.write(String.join(",", campos));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reemplazar el archivo original con el archivo temporal
        File archivoOriginal = new File(rutaArchivo);
        File archivoTmp = new File(archivoTemporal);

        try {
            // Copiar el contenido del archivo temporal al archivo original
            Files.copy(archivoTmp.toPath(), archivoOriginal.toPath(), StandardCopyOption.REPLACE_EXISTING);
            // Eliminar el archivo temporal
            archivoTmp.delete();

            System.out.println("Se ha actualizado el nombre del producto.");
        } catch (IOException e) {
            System.out.println("No se pudo actualizar el nombre del producto");
        }
    }

    public void actualizarPrecio(String codigo, double nuevoPrecio) {
        String rutaArchivo = "productos_minimarket.txt";
        String archivoTemporal = "productos_minimarket_tmp.txt";

        // Actualizar el precio del producto en el archivo
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
             BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemporal))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length >= 5 && campos[0].trim().equals(codigo)) {
                    campos[2] = ""+nuevoPrecio;
                }

                bw.write(String.join(",", campos));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reemplazar el archivo original con el archivo temporal
        File archivoOriginal = new File(rutaArchivo);
        File archivoTmp = new File(archivoTemporal);

        try {
            // Copiar el contenido del archivo temporal al archivo original
            Files.copy(archivoTmp.toPath(), archivoOriginal.toPath(), StandardCopyOption.REPLACE_EXISTING);
            // Eliminar el archivo temporal
            archivoTmp.delete();

            System.out.println("Se ha actualizado el precio del producto.");
        } catch (IOException e) {
            System.out.println("No se pudo actualizar el precio del producto");
        }
    }

    public void actualizarDistribuidor(String codigo, String nuevoDistribuidor) {
        String rutaArchivo = "productos_minimarket.txt";
        String archivoTemporal = "productos_minimarket_tmp.txt";

        // Actualizar el distribuidor del producto en el archivo
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
             BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemporal))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length >= 5 && campos[0].trim().equals(codigo)) {
                    campos[3] = nuevoDistribuidor;
                }

                bw.write(String.join(",", campos));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reemplazar el archivo original con el archivo temporal
        File archivoOriginal = new File(rutaArchivo);
        File archivoTmp = new File(archivoTemporal);

        try {
            // Copiar el contenido del archivo temporal al archivo original
            Files.copy(archivoTmp.toPath(), archivoOriginal.toPath(), StandardCopyOption.REPLACE_EXISTING);
            // Eliminar el archivo temporal
            archivoTmp.delete();

            System.out.println("Se ha actualizado el distribuidor del producto.");
        } catch (IOException e) {
            System.out.println("No se pudo actualizar el distribuidor del producto");
        }
    }

    public void actualizarUnidades(String codigo, int unidadesA) {
        String rutaArchivo = "productos_minimarket.txt";
        String archivoTemporal = "productos_minimarket_tmp.txt";

        // Actualizar las unidades del producto en el archivo
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
             BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemporal))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length >= 5 && campos[0].trim().equals(codigo)) {
                    int unidades = Integer.parseInt(campos[4].trim());
                    unidades += unidadesA;
                    campos[4] = String.valueOf(unidades);
                }

                bw.write(String.join(",", campos));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reemplazar el archivo original con el archivo temporal
        File archivoOriginal = new File(rutaArchivo);
        File archivoTmp = new File(archivoTemporal);

        try {
            // Copiar el contenido del archivo temporal al archivo original
            Files.copy(archivoTmp.toPath(), archivoOriginal.toPath(), StandardCopyOption.REPLACE_EXISTING);
            // Eliminar el archivo temporal
            archivoTmp.delete();

            System.out.println("Se han actualizado las unidades del producto.");
        } catch (IOException e) {
            System.out.println("No se pudo actualizar las unidades del producto");
        }
    }
}
