/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Entidades.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class ArbolUsuario  implements Serializable{
    
    //ArrayList<Usuario> usuarios;
    public Usuario arbol;
    private int size = 0;
    
    public ArbolUsuario(){
        arbol = null;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        //this.usuarios = usuarios;
    }
    
    /*public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }*/
    
    boolean EsHoja(Usuario r) {
	return r.getDer()==null && r.getIzq()==null;
    }
    
    public Usuario validar( String user , String pass){
        //Usuario result = null;
        
        Usuario actual = arbol;
	
	while(!vacio(actual)) {
                //JOptionPane.showMessageDialog(null, actual.getUsuario());
		if(actual.validar(user, pass))
                    return actual;
                else if(user.compareTo(actual.getUsuario())==0){
                    return null;
                }  
		else if(user.compareTo(actual.getUsuario())<0){
                    actual = actual.getIzq();
                }  
		else if(user.compareTo(actual.getUsuario())>0){
                    actual = actual.getDer();
                    
                }
	}
	return null;
        
        /*for(Usuario p : this.usuarios){
            if(p.validar(user, pass)){
                result = p;
                break;
            }
        }
        return result;*/
    }
    
    public boolean add(Usuario u) {
        Usuario padre = null;
        Usuario actual = arbol;
        while(!vacio(actual)&&u.getUsuario().compareTo(actual.getUsuario())!=0){
            padre = actual;
            if(u.getUsuario().compareTo(actual.getUsuario())<0)
                actual = actual.getIzq();
            else
                actual = actual.getDer();
        }
        if(!vacio(actual))
            return false;
        
        if(vacio(padre)) {
		//arbol = (Usuario)malloc(sizeof(Usuario));
		arbol = u;
		arbol.setIzq(null);
                arbol.setDer(null);
	}
	else if(u.getUsuario().compareTo(padre.getUsuario())<0) {
		//actual = (Arbol) malloc (sizeof(tipoNodo));
		actual = u;
		actual.setIzq(null);
                actual.setDer(null);
                padre.setIzq(actual);
	}
	else if(u.getUsuario().compareTo(padre.getUsuario())>0) {
		//actual = (Arbol) malloc (sizeof(tipoNodo));
		actual = u;
		actual.setIzq(null);
                actual.setDer(null);
                padre.setDer(actual);
	}
        size++;
        return true;
        //return this.usuarios.add(u);
    } 
    
    public boolean eliminar(String nom){
        boolean result =false;
        
        Usuario padre = null;
	Usuario actual;
	Usuario nodo;
	Usuario aux;
	actual = arbol;
	while(!vacio(actual)) { 
		if(nom.equals(actual.getUsuario())) {
			if(EsHoja(actual)) { 
				if(padre!=null)
				if(padre.getDer() == actual)
                                    padre.setDer(null); 
				else if(padre.getIzq() == actual)
                                    padre.setIzq(null); 
                                size--;
				return true;
			}
			else {
				padre = actual;
				if(actual.getDer()!=null) {
					nodo = actual.getDer();
					while(nodo.getIzq()!=null) {
						padre = nodo;
						nodo = nodo.getIzq();
					}
				}
				else {
					nodo = actual.getIzq();
					while(nodo.getDer()!=null) {
						padre = nodo;
						nodo = nodo.getDer();
					}
				}
				
				aux = actual; 
				actual = nodo;
				nodo = aux;
				actual = nodo;
			}
		}
		else {
			padre = actual;
			if(nom.compareTo(actual.getUsuario()) > 0)
                            actual = actual.getDer();
			else if(nom.compareTo(actual.getUsuario()) < 0)
                            actual = actual.getIzq();
		}
	}
        
       return result;
    }
    
    public boolean findUsuario(String nom){
        Usuario actual = arbol;
	
	while(!vacio(actual)) {
                
		if(actual.getUsuario().equals(nom))
                    return true;
		else if(nom.compareTo(actual.getUsuario())<0){
                    actual = actual.getIzq();
                }  
		else if(nom.compareTo(actual.getUsuario())>0){
                    actual = actual.getDer();
                    
                }
	}
	return false;
        
    }

    public int cantidadDeUsuarios(){
        return size; //temp
        //return this.usuarios.size();
    }
    
    public String[][] getMatrizUsuario() {
        String[][] result = new String[this.cantidadDeUsuarios()][3];
        Usuario actual = arbol;
        
        leer(actual,0,result);
        
        return result;
    }
    
    private int leer(Usuario u,int i, String[][] result){
        
        if(u.getIzq()!=null)
            i=leer(u.getIzq(), i, result);
	result[i][0]=  u.getNombre();
        result[i][1] = u.getUsuario();
        result[i][2] = u.getContraseña();
        i++;
	if(u.getDer()!=null)
            i=leer(u.getDer(), i, result);
        return i;
    }
    
    public String[] getTitulos(){
        String result[] = new String[3];
        result[0] = "Nombre";
        result[1] = "Usuario";
        result[2] = "Contraseña";
        
        
        return result;
    }  
    
    public boolean vacio(Usuario u){
        return u == null;
    }
        
    
}
