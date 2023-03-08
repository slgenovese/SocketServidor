/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sockets;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author sgenovese
 */
public class ConexionSockets {
    private final int puerto=8080;//Puerto para conectar
    private final String host="localhost";//Direccion IP
    protected String mensajeServidor;//Variable para mensajes recibidos en el servidor
    protected ServerSocket socketServidor;//Socket del servidor
    protected Socket socketCliente;//Socket del cliente
    protected DataOutputStream salidaServidor, salidaCliente;//Variables de salida

    public ConexionSockets (String tipo) throws IOException { //Constructor
        if(tipo.equalsIgnoreCase("Servidor")){
            //Creamos socket para el servidor
            //usamos el puerto que configuramos anteriormente
            socketServidor= new ServerSocket(puerto);
            //Creamos socket para el cliente
            socketCliente= new Socket();
        }else{
            //Creamos socket para el cliente
            //le pasamos como parametro el host y el puerto
            socketCliente= new Socket(host, puerto);
        }
        
    }

}
