package arbol;
import javax.swing.JOptionPane;
/**
 *
 * @author Noemi
 */
public class arbol2 {
    Nodo raiz;
    public arbol2(){
       raiz = null;
    }   
    public void insertar(int i, Object persona){
       Nodo n= new Nodo(i);
       n.contenido = persona;
       
        if (raiz == null) {
            raiz = n;
        }else{
             Nodo aux = raiz;
             while(aux!=null){
               n.padre=aux;
               if(n.llave>=aux.llave){
                   aux=aux.derecha;
               }else{
                  aux=aux.izquierda;
               }
             }
             if(n.llave < n.padre.llave){
                  n.padre.izquierda=n;             
             }else{
                  n.padre.derecha=n;             
             }
        }
    
    }
    public boolean vacía(){
        return raiz==null;
    }
    
    public void recorrer (Nodo n) {
          if(n != null){
            recorrer(n.izquierda);
            JOptionPane.showInputDialog(null, " inndice "+ n.llave + " persona "+ n.contenido, JOptionPane.QUESTION_MESSAGE);              
            recorrer(n.derecha);
          }
    }
    public void preorden(Nodo n){
       if(n!=null){
            JOptionPane.showMessageDialog(null,"El recorrido wn preorden es: "+ n.contenido,
                                "Metodo preorden",JOptionPane.QUESTION_MESSAGE);
            preorden(n.izquierda);
            preorden(n.derecha);
        }
    }
    public void inorden(Nodo  n){
    if(n!=null){
            inorden(n.izquierda);
            JOptionPane.showMessageDialog(null,"El recorrido en inorden es: "+ n.contenido,
                                "Metodo inorden",JOptionPane.QUESTION_MESSAGE);
            inorden(n.derecha);
    }
    }
    public void posorden(Nodo n){
    if(n!=null){
            posorden(n.izquierda);
            posorden(n.derecha);
            JOptionPane.showMessageDialog(null,"El recorrido en postorden es: "+ n.contenido,
                                "Metodo en postorden",JOptionPane.QUESTION_MESSAGE);       
    }
    }
    public Nodo  buscar(int busca){
    Nodo aux=raiz;
               
            while(aux.llave==busca){
            if(busca<aux.llave){
                aux=aux.izquierda;
            }else{
                aux=aux.derecha;
            }
            if(aux==null){
                return null;
            }
        }
        return aux;
    }           
    public boolean eliminar(int dato){
        Nodo auxiliar=raiz;
        Nodo padre=raiz;
        boolean eshijoizquierdo=true;
        while(auxiliar.llave!=dato){
            padre=auxiliar;
            if(dato<auxiliar.llave){
                eshijoizquierdo=true;
                auxiliar=auxiliar.izquierda;
            }else{
                eshijoizquierdo=false;
                auxiliar=auxiliar.derecha;
            }
            if(auxiliar==null){
                return false;
            }
        }//fin de while
        if(auxiliar.izquierda==null && auxiliar.derecha==null){
            if(auxiliar==raiz){
                raiz=null;
            }else if(eshijoizquierdo){
                padre.izquierda=null;
            }else{
                padre.derecha=null;
            }
        }else if(auxiliar.derecha==null){
            if(auxiliar==raiz){
                raiz=auxiliar.izquierda;
            }else if(eshijoizquierdo){
                padre.izquierda=auxiliar.izquierda;
            }else{
                padre.derecha=auxiliar.izquierda;
            }
        }else if(auxiliar.izquierda==null){
            if(auxiliar==raiz){
                raiz=auxiliar.derecha;
            }else if(eshijoizquierdo){
                padre.izquierda=auxiliar.derecha;
            }else{
                padre.derecha=auxiliar.izquierda;
            }            
        }
        return true;
   } 
}
