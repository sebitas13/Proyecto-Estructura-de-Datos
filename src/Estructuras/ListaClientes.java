/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Entidades.Cliente;
import Entidades.Persona;
import java.io.Serializable;
import sistema.Configuracion;

/**
 *
 * @author USUARIO
 */
public class ListaClientes  implements Serializable{
    
    Cliente cab;
    int cantidadClientes;
    
    public ListaClientes(){
        cantidadClientes= 0;
        cab=null;
       // ult=null;
    }
    
    public boolean agregar(Persona p){
        boolean retorno = false;
        
        
        if(p != null){
            
            if(!this.findPersona(((Cliente)p).getDNI())){
                
                if(cab == null){
                cab = ((Cliente)p);
                
                }else{
                    ((Cliente)p).setSig(cab);
                    cab = ((Cliente)p);
                     
                 }
               retorno = true; 
            }else{
                System.out.println("ya existe");
            }  
           this.cantidadClientes++;
        }
        
      
        return retorno;
    }
    
    
   public String[][] getMatrizPersona(){
       //String[][] retorno = null;
       
       String[][] result = new String[this.cantidadClientes][7];
       int i=0;
      
           
           Cliente aux;
           if(cab == null){
               System.out.println("Lista vacia");

           }else{
               aux=cab;
               while(aux!=null){
                   
                    result[i][0] = String.valueOf(Configuracion.listaClientes.posicionDeCliente(aux)+1);
                    result[i][1] = aux.getNombre();
                    result[i][2] = aux.getDNI();
                    result[i][3] = aux.getDireccion();
                    result[i][4] = aux.getCelular();
                    result[i][5] = String.valueOf(aux.getNumeroCompras());
                    result[i][6] = String.valueOf(aux.getTotalCompras());
                   
                   System.out.println("Nombre->"+aux.getNombre());
                   aux= aux.getSig();
                   i++;
               }
           }
           
   
       
       return result;
   } 
   
   
   
   public String[] getTituloPersonas() {
        String[] retorno = null;
        
            String[] result = new String[7];

            result[0] = "Pos:";
            result[1] = "Nombre";
            result[2] = "DNI";
            result[3] = "Direccion";
            result[4] = "Celular";
            result[5] = "N°compras";
            result[6] = "GASTO";    
            retorno = result;


        return retorno;
    }
    
   
   public int posicionDeCliente(Cliente c) {
        int result = 0;
        int i = 0; //this.cantidadClientes-1;
        Cliente aux;
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
   
   
    
 public boolean findPersona(String DNI){
        boolean encontrado=false;
        boolean retorno = false;
        Cliente recorre = cab;
        
        while(recorre!=null && !encontrado ){
            
            if(recorre.getDNI().equals(DNI) ){
                encontrado=true;
                retorno=true;
            }else{
                recorre = recorre.getSig();
            }
            
        }
      
        return retorno;
 }
    
     public Cliente obtenerPersonaPorDni(String dni){
        Cliente retorno = null;
        Cliente aux;
        boolean encontrado = false;
        
        if(cab == null){
            System.out.println("lista vacia");
        }else{
            aux = cab;
            while(aux!=null && !encontrado){
                if(dni.equals(aux.getDNI()) ){
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
     
    public Cliente obtenerPersonaPorNombre(String nombre){
        Cliente retorno = null;
        Cliente aux;
        boolean encontrado = false;
        
        if(cab == null){
            System.out.println("lista vacia");
        }else{
            aux = cab;
            while(aux!=null && !encontrado){
                if(nombre.equalsIgnoreCase(aux.getNombre()) ){
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
     
     
    public Cliente obtenerPersonaPorPosicion(int pos){
        Cliente retorno = null;
        Cliente aux;
        boolean encontrado = false;
        
        if(cab == null){
            System.out.println("lista vacia");
        }else{
            aux = cab;
            while(aux!=null && !encontrado){
                if( this.posicionDeCliente(aux) == pos ){
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
    
    
    public boolean modificarPersona(Cliente c){
      
        Cliente aux;
        boolean encontrado = false;
        
        if(cab == null){
            System.out.println("lista vacia");
        }else{
            aux = cab;
            while(aux!=null && !encontrado){
                if( aux.equals(c) ){
                    encontrado = true;
                    aux.setCelular(c.getCelular());
                    aux.setDNI(c.getDNI());
                    aux.setDireccion(c.getDireccion());
                    aux.setDistrito(c.getDistrito());
                    aux.setNombre(c.getNombre());
                   
                    
                }else{
                    aux = aux.getSig();
                }
            }
           if(encontrado==false ){
               System.out.println("no se encontro");
           }else{
               System.out.println("encontrado");
           }
            
        }
        return encontrado   ;
   }
    
    
    //baja logica del cliente
     public boolean eliminarClientePorDni(String DNI) {

        boolean encontre = false;
        boolean retorno = false;

        Cliente recorre = cab;
       Cliente  anterior = null;

        if (cab == null) {
            System.out.println("Lista vacia");
        } else {

            while (recorre != null && !encontre) {

                if (recorre.getDNI().equals(DNI)) {
                      
                    if (recorre == cab) {
                        cab = cab.getSig();
                    } else {
                        anterior.setSig(recorre.getSig());
                    }
                    encontre = true;
                    this.cantidadClientes--;
                }
                anterior = recorre;
                recorre = recorre.getSig();
            }
            System.out.println("Cliente dado de baja");
        }

        return retorno;

    }
     
     
    
     public boolean eliminarCliente(Cliente c) {

        boolean encontre = false;
        boolean retorno = false;

        Cliente recorre = cab;
       Cliente  anterior = null;

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
                    this.cantidadClientes--;
                }
                anterior = recorre;
                recorre = recorre.getSig();
            }
            System.out.println("Cliente dado de baja");
        }

        return retorno;

    }
     
     
}
