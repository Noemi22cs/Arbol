package arbol;
import javax.swing.JOptionPane;
/**
 *
 * @author Noemi
 */
public class Abinario {
    Nodo_arbol raiz;
    public Abinario(){
        raiz=null;
    }   
    public void agregarNODO(int da,String nombre){
        Nodo_arbol nuevo =new Nodo_arbol(da,nombre);
        if(raiz==null){
            raiz=nuevo;
        }else{
            Nodo_arbol auxiliar=raiz;
            Nodo_arbol padre;
            while(true){
                padre=auxiliar;
                if(da<auxiliar.dato){
                    auxiliar=auxiliar.hijoIZQUIERDO;
                    if(auxiliar==null){
                        padre.hijoIZQUIERDO=nuevo;
                        return;
                    }
                }else{
                    auxiliar=auxiliar.hijoDERECHO;
                    if(auxiliar==null){
                        padre.hijoDERECHO=nuevo;
                        return;
                    }
                }
        }
        }        
    }    
    public boolean estaVACIO(){
        return raiz==null;
    }    
    public void inORDEN(Nodo_arbol r){
        if(r!=null){
            inORDEN(r.hijoIZQUIERDO);
            JOptionPane.showMessageDialog(null,"El recorrido en inorden es: "+ r.dato,
                                "Metodo inorden",JOptionPane.QUESTION_MESSAGE);
            inORDEN(r.hijoDERECHO);
        }       
    }   
    public void preORDEN(Nodo_arbol r){
        if(r!=null){
            JOptionPane.showMessageDialog(null,"El recorrido en preorden es: "+ r.dato,
                                "Metodo preorden",JOptionPane.QUESTION_MESSAGE);
            preORDEN(r.hijoIZQUIERDO);
            preORDEN(r.hijoDERECHO);
        }
    }    
    public void posORDEN(Nodo_arbol r){
        if(r!=null){
            posORDEN(r.hijoIZQUIERDO);
            posORDEN(r.hijoDERECHO);
            JOptionPane.showMessageDialog(null,"Eel recorrido el postorden: "+ r.dato,
                                "Metodo postorden",JOptionPane.QUESTION_MESSAGE);           
        }
    }    
    public Nodo_arbol buscarNODO(int dato){
        Nodo_arbol aux=raiz;
        while(aux.dato!=dato){
            if(dato<aux.dato){
                aux=aux.hijoIZQUIERDO;
            }else{
                aux=aux.hijoDERECHO;
            }
            if(aux==null){
                return null;
            }
        }
        return aux;
    }
    
    public boolean eliminarNODO(int dato){
        Nodo_arbol auxiliar=raiz;
        Nodo_arbol padre=raiz;
        boolean eshijoizquierdo=true;
        while(auxiliar.dato!=dato){
            padre=auxiliar;
            if(dato<auxiliar.dato){
                eshijoizquierdo=true;
                auxiliar=auxiliar.hijoIZQUIERDO;
            }else{
                eshijoizquierdo=false;
                auxiliar=auxiliar.hijoDERECHO;
            }
            if(auxiliar==null){
                return false;
            }
        }
        if(auxiliar.hijoIZQUIERDO==null && auxiliar.hijoDERECHO==null){
            if(auxiliar==raiz){
                raiz=null;
            }else if(eshijoizquierdo){
                padre.hijoIZQUIERDO=null;
            }else{
                padre.hijoDERECHO=null;
            }
        }else if(auxiliar.hijoDERECHO==null){
            if(auxiliar==raiz){
                raiz=auxiliar.hijoIZQUIERDO;
            }else if(eshijoizquierdo){
                padre.hijoIZQUIERDO=auxiliar.hijoIZQUIERDO;
            }else{
                padre.hijoDERECHO=auxiliar.hijoIZQUIERDO;
            }
        }else if(auxiliar.hijoIZQUIERDO==null){
            if(auxiliar==raiz){
                raiz=auxiliar.hijoDERECHO;
            }else if(eshijoizquierdo){
                padre.hijoIZQUIERDO=auxiliar.hijoDERECHO;
            }else{
                padre.hijoDERECHO=auxiliar.hijoIZQUIERDO;
            }
        }else{
            Nodo_arbol reemplazo=obtenernodoreemplazo(auxiliar);
            if(auxiliar==raiz){
                raiz=reemplazo;
            }else if(eshijoizquierdo){
                padre.hijoIZQUIERDO=reemplazo;
            }else{
                padre.hijoDERECHO=reemplazo;
            }
            reemplazo.hijoIZQUIERDO=auxiliar.hijoIZQUIERDO;
        }
        return true;
    }
    
    public Nodo_arbol obtenernodoreemplazo(Nodo_arbol nodoreemplazo){
        Nodo_arbol reemplazarpadre=nodoreemplazo;
        Nodo_arbol reemplazo=nodoreemplazo;
        Nodo_arbol auxiliar=nodoreemplazo.hijoDERECHO;
        while(auxiliar!=null){
            reemplazarpadre=reemplazo;
            reemplazo=auxiliar;
            auxiliar=auxiliar.hijoIZQUIERDO;
        }
        if(reemplazo!=nodoreemplazo.hijoDERECHO){
            reemplazarpadre.hijoIZQUIERDO=reemplazo.hijoDERECHO;
            reemplazo.hijoDERECHO=nodoreemplazo.hijoDERECHO;
        }
        JOptionPane.showMessageDialog(null,"El nodoreemplazado: "+ reemplazo,
                                "Metodo postorden",JOptionPane.QUESTION_MESSAGE);        
        return reemplazo;
    }
}
