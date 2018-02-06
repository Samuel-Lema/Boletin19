package boletin19;

import com.samuel.libreria.Libreria;
import com.samuel.libreria.Libro;
import javax.swing.JOptionPane;

public class Boletin19 {
    
    public static void main(String[] args) {
        
        // Creo 2 Libros predeterminados
        
        Libro libro1 = new Libro("Libro230", "Samuel", "#1", 10, 150);
        Libro libro2 = new Libro("Libro15", "Artai", "#2", 20, 120);
        
        Libreria.añadir(libro1);
        Libreria.añadir(libro2);
        
        boolean exit = false;
        
        do {
            
            String opcion = "6";
            
            try{
                opcion = JOptionPane.showInputDialog("Opciones:\n "
                    + "1) Añadir Libro\n "
                    + "2) Vender Libros\n"
                    + "3) Mostrar todos los Libros\n"
                    + "4) Eliminar Libros sin stock\n"
                    + "5) Consultar un Libro\n"
                    + "6) Salir");
            }finally {
                
                if(opcion == null){
                    opcion = "6";
                }
            }
            
            switch(opcion){
                case "1": // Permite añadir Libros
                Libreria.añadir(); break;
                
                case "2": // Permite vender Libros
                Libreria.vender(JOptionPane.showInputDialog("Introduce el ISBN del libro a vender")); break;
                
                case "3": // Muestra todos los Libros Ordenados
                Libreria.mostrar(); break;
                
                case "4": // Elimina los libros sin stock
                Libreria.eliminarSinStock(); break;
                
                case "5": // Consulta un Libro
                Libreria.consultar(JOptionPane.showInputDialog("Introduce el ISBN del libro a consultar")); break;
                    
                case "6": // Sale del bucle de preguntas
                exit = true; break;
            }
            
        } while(exit == false);
    }
    
}
