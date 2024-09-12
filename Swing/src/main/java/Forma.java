import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Forma extends JFrame{
    private JPanel panelPrincipal;
    private JTextField campoTexto;
    private JLabel replicadorLabel;

    public Forma(){
        inicializarForma();
        //campoTexto.addActionListener(e -> {
        //  replicarTexto();
        //});
        campoTexto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                replicarTexto();
            }
        });
    }

    private void inicializarForma(){
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierre de aplicacion
        setSize(600, 400); // Tamaño de ventana
        setLocationRelativeTo(null); // centrar ventana
    }

    private void replicarTexto(){
        this.replicadorLabel.setText(this.campoTexto.getText());
    }

    public static void main(String[] args) {
        FlatDarculaLaf.setup(); // cambiar look and feel a modo oscuro
        Forma  forma = new Forma();
        forma.setVisible(true);
    }
}
