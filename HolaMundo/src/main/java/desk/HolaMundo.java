package desk;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;

public class HolaMundo extends JFrame {
    private JButton Iniciar;
    private JPanel deskPrincipal;

    public HolaMundo(){
        deskInit();
        Iniciar.addActionListener(e -> validar());
    }

    private void deskInit(){
        setContentPane(deskPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null);
    }

    private void validar(){
        JOptionPane.showMessageDialog(this,"Hola Mundo");
    }

    public static void main(String[] args){
        FlatDarculaLaf.setup();
        HolaMundo holaMundo= new HolaMundo();
        holaMundo.setVisible(true);
    }
}