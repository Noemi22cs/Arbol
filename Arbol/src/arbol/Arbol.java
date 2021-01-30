package arbol;
import javax.swing.JOptionPane;
/**
 *
 * @author Noemi
 */
public class Arbol {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int opcion=0,elemento;
        String nombre;
        Abinario arbol2=new Abinario();     
        do{
            try{
                opcion= Integer.parseInt(JOptionPane.showInputDialog(null,
                        "\tOpciones:"
                       +"\n1. Agrgar un nuevo nodo"
                       +"\n2. Recorrer el arbol en inorden"
                       +"\n3. Recorrer el arbol en preorden"
                       +"\n4. Recorrer el arbol en posorden"
                       +"\n5. Buscar un nodo del arbol"
                       +"\n6. Eliminar un nodo del arbol"
                       +"\n7. Mostrar el nodo que reemplazará el nodo eliminado"
                       +"\n8. Salir"
                       +"\n Eliga alguna opción ","Arbol binario",JOptionPane.QUESTION_MESSAGE));
              
                switch (opcion){
                    case 1:
                        elemento=Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingrese el numero del nodo...","Ingrese el nodo",JOptionPane.QUESTION_MESSAGE));
                        nombre=JOptionPane.showInputDialog(null,"Ingrese un nombre para el nodo",
                                "Agregando",JOptionPane.QUESTION_MESSAGE);
                        arbol2.agregarNODO(elemento, nombre);
                        break;
                    case 2:
                        if(!arbol2.estaVACIO()){
                           
                            arbol2.inORDEN(arbol2.raiz);
                        }else{
                            JOptionPane.showMessageDialog(null,"El arbol está vacío",
                                "vacío",JOptionPane.QUESTION_MESSAGE);
                        }
                        break;
                    case 3:
                        if(!arbol2.estaVACIO()){
                            System.out.println();
                            arbol2.preORDEN(arbol2.raiz);
                        }else{
                            JOptionPane.showMessageDialog(null,"El arbol está vacío",
                                "vacío",JOptionPane.QUESTION_MESSAGE);
                        }
                        
                        break;
                    case 4:
                        if(!arbol2.estaVACIO()){
                            System.out.println();
                            arbol2.posORDEN(arbol2.raiz);
                        }else{
                            JOptionPane.showMessageDialog(null,"El arbol está vacío",
                                "vacío",JOptionPane.QUESTION_MESSAGE);
                        }
                        break;
                    case 5:
                        if(!arbol2.estaVACIO()){
                            elemento=Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingrese el nodo que desea buscar: ","Buscando",JOptionPane.QUESTION_MESSAGE));
                            if(arbol2.buscarNODO(elemento)==null){
                            JOptionPane.showMessageDialog(null,""+elemento+" El nodo no se encuentra en el arbol",
                                "No fue encontrado",JOptionPane.QUESTION_MESSAGE);
                            }else{
                                JOptionPane.showMessageDialog(null,"Nodo encontrado, "+ arbol2.buscarNODO(elemento),
                                "Metodo postorden",JOptionPane.QUESTION_MESSAGE);
                             
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,"El árbol está vacío",
                                "Vacío",JOptionPane.QUESTION_MESSAGE);
                        }
                            
                        
                        break;
                    case 6:
                        if(!arbol2.estaVACIO()){
                            elemento=Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingrese el numero del nodo que desea eliminar: ","Eliminando nodo",JOptionPane.QUESTION_MESSAGE));
                            if(arbol2.eliminarNODO(elemento)==false){
                            JOptionPane.showMessageDialog(null,"El nodo "+elemento+" no se encuentra en el arbol ",
                                "EL nodo no fue encontrado",JOptionPane.QUESTION_MESSAGE);
                            }else{
                                JOptionPane.showMessageDialog(null,"El nodo "+elemento+" a sido eliminado",
                                "Nodo eliminado",JOptionPane.QUESTION_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,"El árbol está vacío",
                                "vacío",JOptionPane.QUESTION_MESSAGE);
                        }
                        break;
                    case 7:
                        if(!arbol2.estaVACIO()){
                           
                           arbol2.obtenernodoreemplazo(arbol2.raiz);
        
                        }else{
                            JOptionPane.showMessageDialog(null,"El árbol está vacío",
                                "Vacío",JOptionPane.QUESTION_MESSAGE);
                        }
                        
                        break;
                    case 8:
                        JOptionPane.showMessageDialog(null,"Cerrando el programa",
                                "Fin",JOptionPane.QUESTION_MESSAGE);
                    break;
                    default:
                        JOptionPane.showMessageDialog(null,"La opción que eligió es incorrecta",
                                "Error",JOptionPane.QUESTION_MESSAGE);
                        
                }
            }catch(NumberFormatException n){
                JOptionPane.showMessageDialog(null, "Error "+n.getMessage());
            }            
        }while(opcion!=8);
    }
}
