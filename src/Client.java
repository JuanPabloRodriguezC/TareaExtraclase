import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Client {
    //metodo principal
    public static void main(String[] args) throws IOException{
        String host = "127.0.0.1";
        int puerto = 5030;
        DataInputStream in;
        DataOutputStream out;


        try {
            Socket socketCliente = new Socket(host, puerto);
            in = new DataInputStream(socketCliente.getInputStream());
            out = new DataOutputStream(socketCliente.getOutputStream());

            out.writeUTF("Cliente concectado con servidor");

            String mensaje = in.readUTF();

            System.out.println(mensaje);

            socketCliente.close();


        }catch (IOException ex){

        }



    }
}
