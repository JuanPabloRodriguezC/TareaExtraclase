//bibliotecas necesarias
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server {
    //metodo principal
    public static void main(String[] args) throws IOException{
        //variables de entrada y salida al servidor
        DataInputStream in;
        DataOutputStream out;

        //numero de puerto
        int puerto = 5030;

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
                out = new DataOutputStream(socketCliente.getOutputStream());

                //mensaje de entrada para corroborar conexion con cliente
                String mensaje = in.readUTF();
                System.out.println(mensaje);

                //mensaje respuesta al cliente
                out.writeUTF("Servidor conectado con cliente");

                //cierra el socket de cliente
                socketCliente.close();
                System.out.println("cliente desconectado");
            }
        } catch (IOException ex){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);

        }





    }

}
