//bibliotecas necesarias
import java.net.*;
import java.io.*;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server extends Observable implements Runnable{
    //metodo principal
    private int puerto;

    public Server(int puerto){
        this.puerto = puerto;
    }

    @Override
    public void run() {
        DataInputStream in;

        //funcionamiento principal
        try {
            //se crea el servidor con la clase ServerSocket
            ServerSocket servidor = new ServerSocket(puerto);

            //mensaje que afirma la creacion del socket
            System.out.println("Servidor iniciado");

            //loop para correr el programa
            while(true){
                //el servidor espera a la conexion de un cliente
                Socket socketCliente = servidor.accept();

                in = new DataInputStream(socketCliente.getInputStream());


                //mensaje de entrada para corroborar conexion con cliente
                String mensaje = in.readUTF();
                System.out.println(mensaje);

                this.setChanged();
                this.notifyObservers();
                this.clearChanged();

                //cierra el socket de cliente
                socketCliente.close();
                System.out.println("cliente desconectado");
            }
        } catch (IOException ex){
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
