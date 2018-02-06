package com.samuel.libreria;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class Libreria {
    
    private static ArrayList<Libro> libros = new ArrayList<>();
    
    // Añade un nuevo libro
    
    public static void añadir(){
        
        Libro librox = new Libro(
                JOptionPane.showInputDialog("Introduce el Titulo"),
                JOptionPane.showInputDialog("Introduce el Autor"),
                JOptionPane.showInputDialog("Introduce el ISBN"),
                Float.parseFloat(JOptionPane.showInputDialog("Introduce el Precio")),
                Integer.parseInt(JOptionPane.showInputDialog("Introduce el Stock")) );
        
        libros.add(librox);
    }
    
    // Añado libros predeterminados
    
    public static void añadir(Libro libro){
        
        libros.add(libro);
    }
    
    // Resta las unidades vendidas al libro
    
    public static void vender(String busqueda){
        
        boolean exist = false;
        
        for(Libro libro: libros){
            if(libro.getISBN().equals(busqueda)){
                
                int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad vendida"));
                libro.setCantidad(libro.getCantidad() - cantidad);
                JOptionPane.showMessageDialog(null,cantidad + " libros (" + libro.getISBN() +") vendidos.");
                exist = true; break;
                
            } else {}
        }
        
        if (exist == false) {
            
            JOptionPane.showMessageDialog(null,"El Libro (" + busqueda + ") no esta registrado.");
        }
    }
    
    // Muestra todos los libros existentes
    
    public static void mostrar(){

        try{
            System.out.println("Mostrando libros (Ordenados por Titulo)");
            
            Collections.sort(libros);

            for(Libro libro: libros){
                System.out.format("Libro { Titulo: %s, Autor: %s, ISBN: %s, Precio: %.2f, Cantidad: %d }\n", 
                        libro.getTitulo(), libro.getAutor(), libro.getISBN(), libro.getPrecio(), libro.getCantidad());
            }
        } catch(NullPointerException except){
            
            except.getMessage();
        }
        
    }
    
    // Elimina los Libros sin Stock
    
    public static void eliminarSinStock(){
        
        boolean sinStock = false;
        
        for(Libro libro: libros){
            
            if(libro.getCantidad() <= 0){
                
                libros.remove(libro);
                JOptionPane.showMessageDialog(null,"Los libros sin stock han sido eliminados.");
                sinStock = true; break;
            } else {}
        }
        
        if(sinStock == false){
            
            JOptionPane.showMessageDialog(null,"No hay libros sin stock a eliminar.");
        }
            
    }
    
    // Consulta un libro determinado
    
    public static void consultar(String busqueda){
        
        boolean exist = false;
                
        for(Libro libro: libros){
            
            if(libro.getISBN().equals(busqueda)){
                
                System.out.format("\nLibro Buscado { Titulo: %s, Autor: %s, ISBN: %s, Precio: %.2f, Cantidad: %d }\n", 
                libro.getTitulo(), libro.getAutor(), libro.getISBN(), libro.getPrecio(), libro.getCantidad());
                exist = true; break;
            }   
        }
        
        if (exist == false) {
            
            JOptionPane.showMessageDialog(null,"El Libro (" + busqueda + ") no esta registrado.");
        }
        
    }
}
