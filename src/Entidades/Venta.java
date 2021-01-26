
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import Entidades.Operacion;
import java.io.Serializable;

/**
 *
 * @author USUARIO
 */
public class Venta  implements Serializable{
    
    private int numeroVenta;
    private Cliente cliente;
    //private DetalleVenta registroV[];
    private String tipo_entrega;
    private float monto_total;
    private int prioridad;
    private boolean estado; // atendido o pendiente
    private Venta sig;
    private Factura factura;

    private ArrayList<Operacion> operaciones;
  

    public Venta() {
    }

    public Venta(int numeroVenta, Cliente cliente, String tipo_entrega, boolean estado) {
        this.numeroVenta = numeroVenta;
        this.cliente = cliente;
        //this.registroV = registroV;
        this.tipo_entrega = tipo_entrega;
        //this.monto_total = monto_total;
        //this.prioridad=prioridad;
        this.estado = estado;
        operaciones = new  ArrayList<>();
        factura =null;
        
        if(tipo_entrega.equals("express")){
            this.prioridad=1;
        }else{
            this.prioridad=2;
        }
    }
    
    public void crearFactura(Venta v,String id){
        
        this.factura = new Factura(v,id);
    }
    
    public void setFactura(Factura f){
        this.factura = f;
    }
 
    public Factura getFactura(){
       
        return this.factura;
    }
    

    
    public void getMatrizOperaciones(){
        int i =1;
        System.out.println("cliente: "+this.cliente.getNombre());
        for(Operacion e : this.operaciones){
            if(e !=null){
                
                System.out.println("op"+i+"-> "+e.getProducto().getNombre());
               
            }
            i++;
        }
        
    }
    
    /*  public String[] getTituloVenta() {
        String[] result = new String[5];

        result[0] = "Nombre";
        result[1] = "Cantidad";
        result[2] = "Precio.Unit";
        result[3] = "Total";
       
        

        return result;
    }

   public String[][] getMatrizVentas() {
        String[][] result = new String[this.cantOperaciones()][5];
        int i = 0;
        for (Operacion e : this.operaciones) {
            
                result[i][0] = e.getProducto().getNombre();
                result[i][1] = String.valueOf(e.getCantidad());
                result[i][2] = String.valueOf(e.getProducto().getPrecio());
                result[i][3] = String.valueOf(e.subtotal());
               
                i++;

            

        }
        return result;
    }*/

    public int getNumeroVenta() {
        return numeroVenta;
    }

    public void setNumeroVenta(int numeroVenta) {
        this.numeroVenta = numeroVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Operacion> getOperaciones() {
        return operaciones;
    }


    public String getTipo_entrega() {
        return tipo_entrega;
    }

    public void setTipo_entrega(String tipo_entrega) {
        this.tipo_entrega = tipo_entrega;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Venta getSig() {
        return sig;
    }

    public void setSig(Venta sig) {
        this.sig = sig;
    }

    public float montoTotal(){
        float result=0;
        for(Operacion e : operaciones){
            if(e!=null){
                result = result + e.subtotal();
            }
            
        }
        
        return result;
    }

    
   
    
    public void setOperaciones(ArrayList<Operacion> operaciones) {
       
        
        for(Operacion e : operaciones){
            if(e!=null){
                
                this.operaciones.add(e);
            }
        }
    }
    
    public int cantOperaciones(){
        return this.operaciones.size();
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    
    
    
    
}
