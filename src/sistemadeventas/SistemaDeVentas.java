/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeventas;

import Entidades.Usuario;
import Entidades.Cliente;
import Entidades.Factura;
import Entidades.Operacion;
import Entidades.Producto;
import Entidades.Venta;
import Estructuras.ArbolUsuario;
import Estructuras.ColaVentas;
import Estructuras.ListaClientes;
import Estructuras.ListaFacturas;
import Estructuras.ListaProductos;
import Formularios.FrameLogin;
import Formularios.FramePrincipal;
import javax.swing.UIManager;
import java.io.Serializable;
import sistema.SerializadoraGen;

import sistema.Configuracion;

/**
 *
 * @author USUARIO
 */
public class SistemaDeVentas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
         try {
             
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
         
         
       
        
        
        /*Cliente cliente1 = new Cliente("0000", "Juan", "Luz", "SJM", "9181");  
        Cliente cliente2 = new Cliente("0001", "Sebastian", "lima", "sjl", "1234");
        Cliente cliente3 = new Cliente("0002", "Luis", "lima", "sjl", "0034");
        Cliente cliente4 = new Cliente("0004", "diana", "ate", "abancay", "369");
        Cliente cliente5 = new Cliente("0005", "Administrador", "ate", "abancay", "387");*/
        
       
      
       // Configuracion.usuarios.add(new Usuario("Sebastian", "sebas", "123"));
       
        
       
        /*Configuracion.listaClientes.agregar(cliente1);
        Configuracion.listaClientes.agregar(cliente2);
        Configuracion.listaClientes.agregar(cliente3);
        Configuracion.listaClientes.agregar(cliente4);
        Configuracion.listaClientes.agregar(cliente5);
        */
        
        //--------------------
        /*
          Configuracion.usuarios.add(new Usuario("Administrador", "admin", "123"));
          Configuracion.listaClientes.agregar(new Cliente("0000", "Administrador", "ate", "abancay", "387"));
     
       //PRODUCTOS
        
        Producto prod1 = new Producto("1","Microsoft Wedge Mobile Keyboard", 150,"TECLADO", 50);
        Producto prod2 = new Producto("2","Microsoft Sculpt Mobile Keyboard.", 200,"TECLADO", 50);
        Producto prod3 = new Producto("3","Apple Keyboard Bluetooth", 300,"TECLADO", 50);
        Producto prod4 = new Producto("4","Logitech Solar K750", 450,"TECLADO", 50);
        Producto prod5 = new Producto("5","Logitech Bluetooth Illuminated Keyboard K810", 500,"TECLADO", 50);
        
       
        Producto prod6 = new Producto("6","Ryzen 9 5950X", 1500,"PROCESADOR", 30);
        Producto prod7 = new Producto("7","Core i9-10850K", 1200,"PROCESADOR", 30);
        Producto prod8 = new Producto("8","Core i5-10600K", 1000,"PROCESADOR", 30);
        Producto prod9 = new Producto("9","Ryzen 5 3600", 780,"PROCESADOR", 30);
        Producto prod10 = new Producto("10","Core i3-10100F", 600,"PROCESADOR", 30);
        
       Producto prod11 = new Producto("11","Corsair Scimitar Pro RGB", 600,"MOUSE", 100);
       Producto prod12 = new Producto("12","MX Ergo de Logitech", 600,"MOUSE", 400);
       Producto prod13 = new Producto("13","UtechSmart Venus", 600,"MOUSE", 500);
       Producto prod14 = new Producto("14","Tt eSports Nemesis", 600,"MOUSE", 600);
       Producto prod15 = new Producto("15","Razer Naga Trinity", 600,"MOUSE", 700);
       
       
       Producto prod16 = new Producto("16","RTX 3060 Ti EAGLE 8G", 1200,"TARJETA", 20);
       Producto prod17 = new Producto("17","GTX 1660 Super Dual Fan", 1300,"TARJETA", 20);
       Producto prod18 = new Producto("18","RTX 3070 Twin Edge Gaming", 2000,"TARJETA", 20);
       Producto prod19 = new Producto("19","RX 6900 XT", 1800,"TARJETA", 20);
       Producto prod20 = new Producto("20","RTX 3090 VENTUS 3X 24G", 5000,"TARJETA", 20);
       
       
       Producto prod21 = new Producto("21","Crucial BX500, 480 GB", 1000,"DISCO", 60);
       Producto prod22 = new Producto("22","Samsung 870 QVO, 1 TB", 800,"DISCO", 60);
       Producto prod23 = new Producto("23","SK Hynix Gold P31, 500 GB", 600,"DISCO", 60);
       Producto prod24 = new Producto("24","Black de Western Digital ", 500,"DISCO", 60);
       Producto prod25 = new Producto("25","Seagate Barracuda Pro", 300,"DISCO", 60);
       
       Producto prod26 = new Producto("26","Corsair Value Select 8 GB, DDR4-2133, CL 15", 600,"RAM", 80);
       Producto prod27 = new Producto("27","G.Skill Aegis 8 GB, DDR4-2133, CL15", 500,"RAM", 80);
       Producto prod28 = new Producto("28","Corsair Vengeance LPX, 8 GB ", 300,"RAM", 80);
       Producto prod29 = new Producto("29","Crucial 8 GB, DDR4-2400, CL 17", 180,"RAM", 80);
       Producto prod30 = new Producto("30","Crucial 16 GB, DDR4-2400, CL ", 90,"RAM", 80);
       
       Producto prod31 = new Producto("31","Asus H410M-K PRIME", 600,"PLACA", 40);
       Producto prod32 = new Producto("32","Gigabyte H410M S2", 360,"PLACA", 40);
       Producto prod33 = new Producto("33","ASRock H410M-ITX/ac", 200,"PLACA", 40);
       Producto prod34 = new Producto("34","Asus B460-PLUS TUF GAMING", 300,"PLACA", 40);
       Producto prod35 = new Producto("35","ASRock Z490 Phantom Gaming 4", 500,"PLACA", 40);
       
        
        
       //AGREGAMOS PRODUCTO A LA LISTA DE PRODUCTOS
        
         Configuracion.listaProductos.agregar(prod1);
         Configuracion.listaProductos.agregar(prod2);
         Configuracion.listaProductos.agregar(prod3);
         Configuracion.listaProductos.agregar(prod4);
         Configuracion.listaProductos.agregar(prod5);
         Configuracion.listaProductos.agregar(prod6);
         Configuracion.listaProductos.agregar(prod7);
         Configuracion.listaProductos.agregar(prod8);
         Configuracion.listaProductos.agregar(prod9);
         Configuracion.listaProductos.agregar(prod10);
         Configuracion.listaProductos.agregar(prod11);
         Configuracion.listaProductos.agregar(prod12);
         Configuracion.listaProductos.agregar(prod13);
         Configuracion.listaProductos.agregar(prod14);
         Configuracion.listaProductos.agregar(prod15);
         Configuracion.listaProductos.agregar(prod16);
         Configuracion.listaProductos.agregar(prod17);
         Configuracion.listaProductos.agregar(prod18);
         Configuracion.listaProductos.agregar(prod19);
         Configuracion.listaProductos.agregar(prod20);
         Configuracion.listaProductos.agregar(prod21);
         Configuracion.listaProductos.agregar(prod22);
         Configuracion.listaProductos.agregar(prod23);
         Configuracion.listaProductos.agregar(prod24);
         Configuracion.listaProductos.agregar(prod25);
         Configuracion.listaProductos.agregar(prod26);
         Configuracion.listaProductos.agregar(prod27);
         Configuracion.listaProductos.agregar(prod28);
         Configuracion.listaProductos.agregar(prod29);
         Configuracion.listaProductos.agregar(prod30);
         Configuracion.listaProductos.agregar(prod31);
         Configuracion.listaProductos.agregar(prod32);
         Configuracion.listaProductos.agregar(prod33);
         Configuracion.listaProductos.agregar(prod34);
         Configuracion.listaProductos.agregar(prod35);
      
        */ 
       
        Configuracion.listaClientes = (ListaClientes)SerializadoraGen.deserializarObject(
                            "ClientesBD");
            Configuracion.usuarios = (ArbolUsuario)SerializadoraGen.deserializarObject(
                            "UsuariosBD");
            Configuracion.listaProductos = (ListaProductos)SerializadoraGen.deserializarObject(
                            "ProductosBD");
            Configuracion.listaFacturas = (ListaFacturas)SerializadoraGen.deserializarObject(
                            "FacturasBD");
            Configuracion.colaventas = (ColaVentas)SerializadoraGen.deserializarObject(
                            "VentasBD");
        
         
           FrameLogin frmL = new FrameLogin("","");
        frmL.setVisible(true);
        frmL.setLocationRelativeTo(null);
       
  
         
         
         
        
      
         
}

}   