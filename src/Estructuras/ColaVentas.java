/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Entidades.Cliente;
import Entidades.Persona;
import Entidades.Venta;
import java.io.Serializable;
import javax.swing.JOptionPane;
import sistema.Configuracion;

/**
 *
 * @author USUARIO
 */
public class ColaVentas  implements Serializable{
    
    
    Venta cab,ult;
    int cantidadVentas;
    
    int id ;
    public ColaVentas(){
        cantidadVentas= 0;
        cab=null;
        ult=null;
        id=0;
    }
    
    public int getID(){
        return id;
    }
    
    public void incrementarID(){
        id++;
    }
    
    public boolean agregar(Venta v){
        boolean retorno = false;
        
        
        if(v != null){
            
            if(!this.findVenta(v.getNumeroVenta())){
                
                if(cab == null){
                cab = v;
                ult =v;
                }else{
                    ult.setSig(v);
                    ult = v;
                     
                 }
               retorno = true; 
            }else{
                System.out.println("ya existe");
            }  
           this.cantidadVentas++;
        }
        
      
        return retorno;
    }
    
    
   public String[][] getMatrizVenta(){
       String[][] result = new String[this.cantidadVentas][5];
         int i=0; 
           Venta aux;
           if(cab == null){
               System.out.println("Lista vacia");

           }else{
               aux=cab;
               while(aux!=null){
                   result[i][0] = String.valueOf(aux.getNumeroVenta());
                    result[i][1] = aux.getCliente().getNombre();
                    result[i][2] = String.valueOf(aux.cantOperaciones());
                    result[i][3] = aux.getTipo_entrega();
                    result[i][4] = String.valueOf(aux.montoTotal());
                   
                   
                   
                   //System.out.println("Nombre->"+aux.getNombre()+"POS->"+aux.g);
                   aux= aux.getSig();
                   i++;
               }
           }
           
       
       
       return result;
       
   } 
   
     public String[][] getMatrizVentaCliente(String nombre){
       String[][] result = new String[this.cantidadVentasClientes(nombre)][5];
         int i=0; 
           Venta aux;
           if(cab == null){
               System.out.println("Lista vacia");

           }else{
               aux=cab;
               while(aux!=null){
                   if(aux.getCliente().getNombre().equalsIgnoreCase(nombre)){
                       result[i][0] = String.valueOf(aux.getNumeroVenta());
                    result[i][1] = aux.getCliente().getNombre();
                    result[i][2] = String.valueOf(aux.cantOperaciones());
                    result[i][3] = aux.getTipo_entrega();
                    result[i][4] = String.valueOf(aux.montoTotal());
                    i++;
                   }
                  
               
                   aux= aux.getSig();
                   
               }
           }
           
       
       
       return result;
       
   }
   
     public int cantidadVentasClientes(String nombre){
         int i=0;
         
         Venta aux;
           if(cab == null){
               System.out.println("Lista vacia");

           }else{
               aux=cab;
               while(aux!=null){
                   if(aux.getCliente().getNombre().equalsIgnoreCase(nombre)){   
                    i++;
                   }
            
                   aux= aux.getSig();
                   
               }
           }
           
         return i;
     }
   
    public String[][] getMatrizVentaExpress(){
       String[][] result = new String[this.cantidadExpress()][5];
       
         int i=0; 
           Venta aux;
           if(cab == null){
               System.out.println("Lista vacia");

           }else{
               aux=cab;
               while(aux!=null){
                   if(aux.getPrioridad()==1){
                     
                      
                    result[i][0] = String.valueOf(aux.getNumeroVenta());
                    result[i][1] = aux.getCliente().getNombre();
                    result[i][2] = String.valueOf(aux.cantOperaciones());
                    result[i][3] = aux.getTipo_entrega();
                    result[i][4] = String.valueOf(aux.montoTotal());
                   
                   
                   
                   //System.out.println("Nombre->"+aux.getNombre()+"POS->"+aux.g);
                   
                   i++;
                   }
                   aux= aux.getSig();
               }
           }
           
       
       
       return result;
       
   }
   
    
    public String[][] getMatrizVentaRegular(){
       String[][] result = new String[this.cantidadRegular()][5];
         int i=0; 
           Venta aux;
           if(cab == null){
               System.out.println("Lista vacia");

           }else{
               aux=cab;
               while(aux!=null){
                   if(aux.getPrioridad()==2){
                     
                      
                    result[i][0] = String.valueOf(aux.getNumeroVenta());
                    result[i][1] = aux.getCliente().getNombre();
                    result[i][2] = String.valueOf(aux.cantOperaciones());
                    result[i][3] = aux.getTipo_entrega();
                    result[i][4] = String.valueOf(aux.montoTotal());
                   
                   
                   
                   //System.out.println("Nombre->"+aux.getNombre()+"POS->"+aux.g);
                   
                   i++;
                   }
                   aux= aux.getSig();
               }
           }
           
       
       
       return result;
       
   }
    
   public String[] getTituloVentas() {
        String[] retorno = null;
        
            String[] result = new String[5];

            result[0] = "ID:";
            result[1] = "CLIENTE";
            result[2] = "N°OP";
            result[3] = "TIPO";
            result[4] = "MONTO";
      

            retorno = result;


        return retorno;
    }
    
    
 public boolean findVenta(int ID){
        boolean encontrado=false;
        boolean retorno = false;
        Venta recorre = cab;
        
        while(recorre!=null && !encontrado ){
            
            if(recorre.getNumeroVenta() == ID ){
                encontrado=true;
                retorno=true;
            }else{
                recorre = recorre.getSig();
            }
            
        }
      
        return retorno;
 }
    
     public Venta obtenerVetna(int ID){
        Venta retorno = null;
        Venta aux;
        boolean encontrado = false;
        
        if(cab == null){
            System.out.println("cola vacia");
        }else{
            aux = cab;
            while(aux!=null && !encontrado){
                if(aux.getNumeroVenta()== ID){
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
     
      public Venta obtenerVetnaPorCliente(String nombre){
        Venta retorno = null;
        Venta aux;
        boolean encontrado = false;
        
        if(cab == null){
            System.out.println("cola vacia");
        }else{
            aux = cab;
            while(aux!=null && !encontrado){
                if(aux.getCliente().getNombre().equalsIgnoreCase(nombre)){
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
  
     
     //EL DESPACHO DE UJNA VENTA SE REALIZARA POR EL ID 
      public boolean eliminarVentaPorID(int ID) {

        boolean encontre = false;
        boolean retorno = false;

        Venta recorre = cab;
        Venta  anterior = null;

        if (cab == null) {
            System.out.println("cola vacia");
        } else {

            while (recorre != null && !encontre) {

                if (recorre.getNumeroVenta() == ID) {
                      
                    if (recorre == cab) {
                        cab = cab.getSig();
                    } else {
                        anterior.setSig(recorre.getSig());
                    }
                    //encontre = true;
                    this.cantidadVentas--;
                }
                anterior = recorre;
                recorre = recorre.getSig();
            }
            System.out.println("Venta dado de baja");
        }

        return retorno;

    }
     
     public boolean decolarVenta(){
         Venta aux = cab;
         boolean retorno= false;
         
         if(aux == null){
             ult=null;
         }else{
             cab = cab.getSig();
             retorno =true;
         }
         return retorno;
     }
     
      public int posicionDeVenta(Venta c) {
        int result = 0;
        int i = 0; //this.cantidadClientes-1;
        Venta aux;
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
    
     /* public void ordenarVentasPorPrioridad(){
          
          Venta actual;
          Venta sgte;
          Venta aux;
          int p_aux =0;
          
          actual = cab;
          
          while(actual.getSig()!=null){
              sgte = actual.getSig();
              
              while(sgte!=null){
                  if(actual.getPrioridad()>sgte.getPrioridad()){
                      p_aux =actual.getPrioridad();
                      aux = actual;
                      
                      actual.setPrioridad(sgte.getPrioridad());
                      actual = sgte;
                      
                      sgte.setPrioridad(p_aux);
                      sgte = aux;
                  }
                    sgte = sgte.getSig();
              }
              actual  = actual.getSig();
              sgte = actual.getSig();
              
          }
          
          
      }*/
      
      public int cantidadExpress(){
        int retorno=0;
        Venta aux;
        
       
        
        if(cab == null){
            System.out.println("cola vacia");
        }else{
            aux = cab;
            while(aux!=null){
                if(aux.getPrioridad()== 1){
                        retorno = retorno+ 1;
                }
                    aux = aux.getSig();
            }
        
        }
        return retorno;
      }
      
   public int cantidadRegular(){
        int retorno=0;
        Venta aux;
        
       
        
        if(cab == null){
            System.out.println("cola vacia");
        }else{
            aux = cab;
            while(aux!=null){
                if(aux.getPrioridad()== 2){
                        retorno = retorno+ 1;
                }
                    aux = aux.getSig();
            }
        
        }
        return retorno;
   }   
      
}
