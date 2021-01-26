/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.awt.BorderLayout;
import java.io.Serializable;

/**
 *
 * @author USUARIO
 */
public class Factura  implements Serializable{
    
    private Venta venta;
    private float montoTotal;
    private Cliente cliente;
    private String ID;
    private Factura sig;
    
    public Factura(Venta venta,String ID){
        this.venta=venta;
        this.cliente = venta.getCliente();
        this.montoTotal = calculoTotal(venta);
        this.ID=ID;
        
    }
    
    public float calculoTotal(Venta v){
        float result=0;
        for(Operacion e : v.getOperaciones()){
            
            result = result + e.subtotal();
        }
        return result;
    } 
    
    
   /* public void mostrarFactura(){
        
        System.out.println("Cliente-> "+cliente.getNombre());
        System.out.println("OPERACIONES: ");
        for(Operacion e : venta.getOperaciones()){
            
            System.out.println(e.getProducto().getNombre()+"->"+e.getCantidad()+"->"+e.subtotal());
            
        }
        System.out.println("TOTAL DEL MONTO -> "+this.montoTotal);
        
    }*/

    public String getID() {
        return ID;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Factura getSig() {
        return sig;
    }

    public void setSig(Factura sig) {
        this.sig = sig;
    }
    
    public  String mostrarResultado(){
       String result="";
       String mensaje="";
      
      
       result = "DATOS DEL USUARIO" +"\n\n"+
               "USUARIO\t"+venta.getCliente().getNombre() +"\n"+
               "DNI\t"+venta.getCliente().getDNI() +"\n"+
               "DISTRITO\t"+venta.getCliente().getDistrito() +"\n"+
               "CELULAR\t"+venta.getCliente().getCelular() +"\n\n"+
               "DATOS DE LA VENTA" +"\n\n"+
               "\tPRODUCTO\t"+"CANTIDAD\t"+"COSTO\n\n"+
               stringOperaciones()+"\n\n"+
                "MONTO TOTAL :"+venta.montoTotal();
       
       
                
       
       return result;
   }
    
   public String stringOperaciones(){
       String result="";
       for(Operacion e : venta.getOperaciones()){
           result = result + "\n\t"+e.getProducto().getNombre()+"\t"+String.valueOf(e.getCantidad())+"\t"+String.valueOf(e.subtotal())+"\n";
       }
       return result;
       
   } 
    
    
}
