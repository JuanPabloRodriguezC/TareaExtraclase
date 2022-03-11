import javax.swing.*;

public class VentanaServidor extends JFrame{
    private JPanel panelPrincipal;
    private JButton enviarButton;
    private JTextField mensajeTextField;
    private JTextArea conversacionTextArea;

    public VentanaServidor(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelPrincipal);
        this.pack();
    }

    public static void main(String[] args){
        JFrame frame = new VentanaServidor("Servidor");
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}
