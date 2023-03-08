/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sockets;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author sgenovese
 */
public class Cliente extends ConexionSockets{
    public Cliente() throws IOException{
        super("Cliente");
    }

    public void startCliente(){
        try {
            //Flujo de datos hacia el servidor
            salidaServidor= new DataOutputStream(socketCliente.getOutputStream());
            
            //Enviamos tres mensajes para probar
            for (int i=0; i<3;  i++){
                //Se escribe en el servidor usando su flujo de datos
                salidaServidor.writeUTF("Este es el mensaje N° "+ (i+1)+"\n");
            }
            //Finalizamos la conexion
            socketCliente.close();
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
