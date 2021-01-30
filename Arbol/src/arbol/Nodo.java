package arbol;

/**
 *
 * @author Noemi
 */
public class Nodo {
    Nodo raiz;
    
       public Nodo padre;
       public Nodo derecha;
       public Nodo izquierda;
       public int llave;
       public Object contenido;           
     
       public Nodo(int indice){
         llave = indice;
         derecha = null;
         izquierda= null;
         padre = null;
         contenido = null;
               
    }
    
}
