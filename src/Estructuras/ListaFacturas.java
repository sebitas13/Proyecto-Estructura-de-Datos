/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;


import Entidades.Factura;
import java.io.Serializable;


/**
 *
 * @author USUARIO
 */
public class ListaFacturas  implements Serializable{
    
    Factura cab;
    int cantidadFacturas;
    
    public ListaFacturas(){
        cantidadFacturas= 0;
        cab=null;
       // ult=null;
    }
    
    public boolean agregar(Factura p){
        boolean retorno = false;
        
        
        if(p != null){
            
            
                
                if(cab == null){
                cab = p;
                
                }else{
                    p.setSig(cab);
                    cab = p;
                     
                 }
               retorno = true; 
             
           this.cantidadFacturas++;
        }
        
      
        return retorno;
    }
    
     public boolean eliminarFactura(String ID) {

        boolean encontre = false;
        boolean retorno = false;

        Factura recorre = cab;
       Factura  anterior = null;

        if (cab == null) {
            System.out.println("Lista vacia");
        } else {

            while (recorre != null && !encontre) {

                if (recorre.getID().equals(ID)) {
                       
                    if (recorre == cab) {
                        cab = cab.getSig();
                    } else {
                        anterior.setSig(recorre.getSig());
                    }
                    encontre = true;
                    this.cantidadFacturas--;
                }
                anterior = recorre;
                recorre = recorre.getSig();
            }
            System.out.println("Factura dado de baja");
        }

        return retorno;

    }
    
       
   
     
     
     
}
