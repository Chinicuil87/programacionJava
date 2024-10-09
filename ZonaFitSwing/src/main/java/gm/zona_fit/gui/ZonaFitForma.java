package gm.zona_fit.gui;

import gm.zona_fit.servicio.IUsuarioServicio;
import gm.zona_fit.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

@Component
public class ZonaFitForma extends JFrame{
    private JPanel panelPrincipal;
    private JTable clientesTabla;

    IUsuarioServicio usuarioServicio;
    private DefaultTableModel tableModeloUsuarios;

    @Autowired
    public ZonaFitForma(UsuarioServicio usuarioServicio){
        this.usuarioServicio = usuarioServicio;
        iniciarForma();
    }

    private void iniciarForma(){
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,700);
        setLocationRelativeTo(null);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        this.tableModeloUsuarios = new DefaultTableModel(0,4);
    }
}
