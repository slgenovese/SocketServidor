/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sockets;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sgenovese
 */
public class Servidor extends ConexionSockets{
    public Servidor() throws IOException{
        super("Servidor");
    }
    public void startServer(){
        try {
            //El metodo accept inicializa el socket
            //queda a la espera de solicitudes
            System.out.println("Esperando una conexion");
            socketCliente=socketServidor.accept();

            //Se obtiene el flujo de salida del cliente
            System.out.println("Cliente en linea");
            salidaCliente= new DataOutputStream(socketCliente.getOutputStream());
            
            //Enviamos un mensaje al cliente
            salidaCliente.writeUTF("Paticion recibida y aceptada");
            
            //Se obtiene el flujo entrante del cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            
            //Mientras haya mensajes del cliente
            while((mensajeServidor = entrada.readLine())!= null){
                //Mostramos los mensajes recibidos
                System.out.println(mensajeServidor);
            }

            //Una vez que termino de leer los mensajes
            //Finalizamos la conexion
            System.out.println("Fin de la conexion");
            socketServidor.close();
            
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
