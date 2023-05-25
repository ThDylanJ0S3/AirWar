package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Clase que representa un servidor que acepta conexiones de clientes y maneja diversas operaciones.
 *
 *@author Vidal Flores
 *@author Dylan Meza
 *@author Brayner Moncada
 */
public class Servidor implements Runnable{

    private ServerSocket servidorSocket;
    private Socket socket;

    /**
     * Constructor de la clase Servidor que inicializa el objeto Servidor.
     *
     * @param puerto el número de puerto en el que se va a ejecutar el servidor.
     */
    public Servidor(int puerto) {
        try {
            servidorSocket = new ServerSocket(puerto);
        } catch (IOException e) {
            e.printStackTrace();
        }      
    }

    /**
     * Método para iniciar el servidor y aceptar conexiones entrantes.
     * Se ejecuta en un bucle infinito para mantener el servidor activo.
     */
    public void iniciarServidor() {
        while (true) {
            try {
                System.out.println("Esperando conexión...");
                System.out.println(socket+"esto es socket");
                socket = servidorSocket.accept();
                recibirSocket(socket);
                System.out.println("Conexión aceptada de " + socket.getInetAddress());
                // Aquí puedes manejar la conexión con el cliente en otro hilo o clase
        
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Método para cerrar el servidor y liberar los recursos utilizados.
     */
    public void cerrarServidor() {
        try {
            if (socket != null) {
                socket.close();
            }
            if (servidorSocket != null) {
                servidorSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método run de la interfaz Runnable.
     * Llama al método iniciarServidor para iniciar el servidor.
     */
    @Override
    public void run() {
        iniciarServidor();
    }

    /**
     * Método para recibir el socket y realizar operaciones basadas en los datos enviados por el cliente.
     *
     * @param socket el socket de la conexión establecida con el cliente.
     */
    public void recibirSocket(Socket socket) {
        try {
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            
            Object inputData = input.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
