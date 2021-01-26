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
public class Producto  implements Serializable{
    
    private String ID;
    private String nombre;
    private float precio;
    private String categoria;
    private int stock;
    private Producto sig;
    private boolean status; //alta -  baja
    
    
 public Producto(String ID, String nombre, float precio, String categoria, int stock) {
        this.ID = ID;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
        this.sig = null;
        this.status=true;
    }
    
    public Producto() {
        this.ID = null;
        this.nombre = null;
        this.precio = 0;
        this.categoria = null;
        this.stock = 0;
        this.sig = null;
    }
 
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Producto getSig() {
        return sig;
    }

    public void setSig(Producto sig) {
        this.sig = sig;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}

