package arbol;
/**
 *
 * @author Noemi
 */
public class Nodo_arbol {
    int dato;
    String nombre;
    Nodo_arbol hijoIZQUIERDO, hijoDERECHO;
    
    public Nodo_arbol(int da,String nombre){
        this.dato=da;
        this.nombre=nombre;
        this.hijoIZQUIERDO=null;
        this.hijoDERECHO=null;
    }   
    public String toString(){
        return " Su dato es el siguiente: "+nombre+" "+ dato;
    }    
}
