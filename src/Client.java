import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Client implements Runnable{

    private int puerto;
    private String mensaje;

    public Client(int puerto, String mensaje){
        this.puerto = puerto;
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        final String host = "127.0.0.1";
        DataInputStream in;
        DataOutputStream out;


        try {
            Socket socketCliente = new Socket(host, puerto);
            out = new DataOutputStream(socketCliente.getOutputStream());

            out.writeUTF(mensaje);

            socketCliente.close();


        }catch (IOException ex){
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
