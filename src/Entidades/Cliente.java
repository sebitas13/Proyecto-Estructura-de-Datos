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
public class Cliente extends Persona  implements Serializable{
    
    private int numeroCompras;
    private float totalCompras;
    private Cliente sig;
    private float gastoTotal;
    //private boolean status;

    public Cliente(String DNI, String nombre, String direccion, String distrito, String celular) {
        super(DNI, nombre, direccion, distrito, celular);
        //status = true;
        this.numeroCompras=0;
        this.totalCompras=0;
    }

    public int getNumeroCompras() {
        return numeroCompras;
    }

    public void setNumeroCompras(int numeroCompras) {
        this.numeroCompras = numeroCompras;
    }
    
    public void incrementarTotalCompras(float suma){
        totalCompras= totalCompras + suma;
    }
    
    public void incrementarNumCompras(int suma){
         numeroCompras =numeroCompras + suma;
    }

    public float getTotalCompras() {
        return totalCompras;
    }

    public void decrecentarTotalCompras(float suma) {
        this.totalCompras = this.totalCompras - suma;
    }

    public Cliente getSig() {
        return sig;
    }

    public void setSig(Cliente sig) {
        this.sig = sig;
    }

 
   /* public void ingrementarGastoTotal(float suma){
        
        this.gastoTotal = this.gastoTotal+suma;
        
    }*/
    
    
    
    
    
}
