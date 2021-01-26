/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import Entidades.Operacion;
import Entidades.Usuario;
import Estructuras.ArbolUsuario;
import Estructuras.ColaVentas;
import Estructuras.ListaClientes;
import Estructuras.ListaFacturas;
import Estructuras.ListaProductos;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Configuracion {
    
    public static ListaClientes listaClientes = new ListaClientes();
    public static ListaProductos listaProductos = new ListaProductos();
    public static ListaFacturas listaFacturas = new ListaFacturas();
    public static ColaVentas colaventas = new ColaVentas();
    public static ArbolUsuario usuarios = new ArbolUsuario();
    public static Usuario usuario;
   // public static int ID =  0;
    public static int IDP =36;
    
    public static  ArrayList<Operacion> operaciones = new ArrayList<>();
}
