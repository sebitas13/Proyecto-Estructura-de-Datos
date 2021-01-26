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
public class Usuario extends Persona implements Serializable{
    
    //private String nombre;
    private String usuario;
    private String contraseña;
    private boolean loguin;
    private boolean remember;
    private Usuario izq;
    private Usuario der;

    public Usuario(String nombre, String usuario, String contraseña) {
        super(nombre);
       // this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.loguin = false;
    }
    
    
    public boolean validar(String user , String pass){
        boolean result=false;
        
        if(usuario.equalsIgnoreCase(user) 
                &&contraseña.equalsIgnoreCase(pass) && !this.loguin ){
            this.setLoguin(true);
            result = true;
            
        }
     return result;   
    }
    
    
     public boolean cerrarSesion(){
        boolean result = false;
        
        if(this.isLoguin()){
            this.setLoguin(false);
            result=true;
        }
        
        return result;
    }
    
     //Get and Set
    
    public boolean isLoguin() {    
        return loguin;
    }

   
    public void setLoguin(boolean loguin) {
        this.loguin = loguin;
    }

   /* @Override
    public String getNombre(){
        
        return super.getNombre();
    } */
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Usuario getIzq() {
        return izq;
    }

    public Usuario getDer() {
        return der;
    }

    public void setIzq(Usuario izq) {
        this.izq = izq;
    }

    public void setDer(Usuario der) {
        this.der = der;
    }

    
    
    
    
    
}
