/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Entidades.Cliente;
import Entidades.Producto;
import java.io.Serializable;
import sistema.Configuracion;

/**
 *
 * @author USUARIO
 */
public class ListaProductos  implements Serializable{
    
    public Producto cab;
    int contador;
    
    public ListaProductos(){
        
        cab=null;
        
        contador=0;
    }
    
    public boolean agregar(Producto p){
        
        boolean retorno = false;
        
        
        if(p != null){
            
            if(!this.findProducto(p.getID())){
                
                if(cab == null){
                cab = p;
                
                }else{
                    p.setSig(cab);
                    cab = p; 
                     
                 }
               retorno = true; 
            }else{
                System.out.println("ya existe");
            }  
           contador++;
        }
        
      
        return retorno;
    }
   
    
 public boolean findProducto(String ID){
        boolean encontrado=false;
        boolean retorno = false;
        Producto recorre = cab;
        
        while(recorre!=null && !encontrado){
            
            if(recorre.getID().equals(ID) ){
                encontrado=true;
                retorno=true;
            }else{
                recorre = recorre.getSig();
            }
            
        }
      
        return retorno;
 }
 
  public Producto obtenerProducto(String ID){
        boolean encontrado=false;
        Producto retorno=null;
        
        if(cab==null){
            System.out.println("lista vacia");
        }else{
            Producto aux = cab;
            while(aux!=null && !encontrado){
                if(ID.equals(aux.getID()) ){
                    retorno = aux;
                    encontrado=true;
                }else{
                    aux=aux.getSig();
                }
            }
          
        }
        return retorno;
     }
 
 public boolean ModificarProducto(Producto p){
        Producto aux;
        boolean retorno = false;
        
        boolean encontrado=false;
        if (cab==null) {
           
            
        }else{
            aux=cab;
            while(aux!=null&&!encontrado){
                if (aux.equals(p)) {
                    encontrado=true;
                    retorno=true;
                    aux.setNombre(p.getNombre());
                    aux.setPrecio(p.getPrecio());
                    aux.setStock(p.getStock());
                    aux.setID(p.getID());
                    aux.setCategoria(p.getCategoria());
                    System.out.println("Modificado");
                }else{
                    aux=aux.getSig();
                }
            }
           
            
        }
        return retorno;
        
    }
 
 
 
 
    public boolean eliminarProductoPorID(String ID) {

        boolean encontre = false;
        boolean retorno = false;

        Producto recorre = cab;
        Producto anterior = null;

        if (cab == null) {
            System.out.println("Lista vacia");
        } else {

            while (recorre != null && !encontre) {

                if (recorre.getID().equals(ID) ) {
                       recorre.setStatus(false);
                    if (recorre == cab) {
                        cab = cab.getSig();
                    } else {
                        anterior.setSig(recorre.getSig());
                    }
                    encontre = true;
                    contador--;
                }
                anterior = recorre;
                recorre = recorre.getSig();
            }
            System.out.println("Producto dado de baja");
        }

        return retorno;

    }
 
    
     public boolean eliminarProducto(Producto c) {

        boolean encontre = false;
        boolean retorno = false;

        Producto recorre = cab;
       Producto  anterior = null;

        if (cab == null) {
            System.out.println("Lista vacia");
        } else {

            while (recorre != null && !encontre) {

                if (recorre.equals(c)) {
                      
                    if (recorre == cab) {
                        cab = cab.getSig();
                    } else {
                        anterior.setSig(recorre.getSig());
                    }
                    encontre = true;
                    this.contador--;
                }
                anterior = recorre;
                recorre = recorre.getSig();
            }
            System.out.println("Producto dado de baja");
        }

        return retorno;

    }
    
    
     public String[][] getMatrizProducto(){
       //String[][] retorno = null;
       
       String[][] result = new String[this.contador][6];
       int i=0;
      
           
           Producto aux;
           if(cab == null){
               System.out.println("Lista vacia");

           }else{
               aux=cab;
               while(aux!=null){
                   
                    result[i][0] = String.valueOf(Configuracion.listaProductos.posicionDeProducto(aux)+1);
                    result[i][1] = aux.getID();
                    result[i][2] = aux.getNombre();
                    result[i][3] = String.valueOf(aux.getPrecio());
                    result[i][4] = aux.getCategoria();
                    result[i][5] = String.valueOf(aux.getStock());
                   
                   
                   //System.out.println("Nombre->"+aux.getNombre()+"POS->"+aux.g);
                   aux= aux.getSig();
                   i++;
               }
           }
           
   
       
       return result;
   } 
    
     
    public String[][] getMatrizProductoPorCategoria(String cat){
       //String[][] retorno = null;
       
       
       
       //String[][] result = new String[this.contador][1];
       int i=0;
      
           int cant = 0;
           Producto aux;
           aux = cab;
           while(aux!=null){
               if(aux.getCategoria().equals(cat)){
                   cant++;
               }
               aux =aux.getSig();
           }
           
           String[][] result = new String[cant][1];
           
           
           if(cab == null){
               System.out.println("Lista vacia");

           }else{
               aux=cab;
               while(aux!=null){
                   if(aux.getCategoria().equals(cat)){
                       
                   // result[i][0] = String.valueOf(Configuracion.listaProductos.posicionDeProducto(aux)+1);
                   // result[i][1] = aux.getID();
                    result[i][0] = aux.getNombre();
                   // result[i][3] = String.valueOf(aux.getPrecio());
                   // result[i][4] = aux.getCategoria();
                    //result[i][5] = String.valueOf(aux.getStock());
                       i++;
                   }
                    
                   
                   
                   //System.out.println("Nombre->"+aux.getNombre()+"POS->"+aux.g);
                   aux= aux.getSig();
                  // i++;
               }
           }
           
   
       
       return result;
   }  
     
    public String[] getTituloProducto() {
        String[] retorno = null;
        
            String[] result = new String[6];

            result[0] = "Pos:";
            result[1] = "ID";
            result[2] = "NOMBRE";
            result[3] = "PRECIO";
            result[4] = "CATEGORIA";
            result[5] = "STOCK";

            retorno = result;


        return retorno;
    } 
    
     public String[] getTituloProductoPorCategoria() {
        String[] retorno = null;
        
            String[] result = new String[1];

            result[0] = "PRODUCTOS";
           
            retorno = result;


        return retorno;
    }
     
     
    public int posicionDeProducto(Producto c) {
        int result = 0;
        int i = 0; //this.cantidadClientes-1;
        Producto aux;
        aux =cab;
        
        if(aux == null){
            System.out.println("Lista vacia");
        }else{
            
            while(aux!=null){
                if(c.equals(aux)){
                    result=i;
                    break;
                }
                aux =aux.getSig();
                i++;
            }
        }
       
        return result;
    }
    
    
     public Producto obtenerProductoPorPosicion(int pos){
        Producto retorno = null;
        Producto aux;
        boolean encontrado = false;
        
        if(cab == null){
            System.out.println("lista vacia");
        }else{
            aux = cab;
            while(aux!=null && !encontrado){
                if( this.posicionDeProducto(aux) == pos ){
                    encontrado = true;
                    retorno = aux;
                    
                }else{
                    aux = aux.getSig();
                }
            }
           if(retorno == null ){
               System.out.println("no se encontro");
           }else{
               System.out.println("encontrado");
           }
            
        }
        return retorno;
   }
     
     public Producto obtenerProductoPorNombre(String nombre){
        boolean encontrado=false;
        Producto retorno=null;
        
        if(cab==null){
            System.out.println("lista vacia");
        }else{
            Producto aux = cab;
            while(aux!=null && !encontrado){
                if(nombre.equals(aux.getNombre()) ){
                    retorno = aux;
                    encontrado=true;
                }else{
                    aux=aux.getSig();
                }
            }
          
        }
        return retorno;
     }
    

}

