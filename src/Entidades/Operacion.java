/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;

/**
 *
 * @author USUARIO
 */
public class Operacion  implements Serializable{
    
    private Producto producto;
    private int cantidad;
    private boolean procede ;
    
    public Operacion(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
           
    }

    public Operacion() {
    }

    public boolean isProcede() {
        
        if(cantidad<=this.producto.getStock()){
            this.procede = true;
            this.producto.setStock(this.producto.getStock()-cantidad);
            
        }else{
            this.procede = false;
        }
        
        return procede;
    }

    

    
    
    //Metodos getter y setter
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    
    
    
    //metodos propios
    
    public float subtotal(){ 
        
        return producto.getPrecio()*cantidad;
        
    }
    
    
}
