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
public class Persona  implements Serializable{
    
    private String DNI;
    private String nombre;
    private String direccion;
    private String distrito;
    private String celular;
    


    public Persona(String DNI, String nombre, String direccion, String distrito, String celular) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.direccion = direccion;
        this.distrito = distrito;
        this.celular = celular;
    }

    public Persona(String nombre){
        this.nombre=nombre;
    }
    
    
    public Persona() {
       this.DNI = null;
        this.nombre = null;
        this.direccion = null;
        this.distrito = null;
        this.celular = null; 
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    
    
    
    
}
