package gm.zona_fit;

import com.formdev.flatlaf.FlatDarculaLaf;
import gm.zona_fit.gui.ZonaFitForma;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class ZonaFitSwing {
    public static void main(String[] args) {
        // Configuramos el modo obscuro
        FlatDarculaLaf.setup();
        // Instancia la Fabrica Spring
        ConfigurableApplicationContext contextSpring =
                new SpringApplicationBuilder(ZonaFitSwing.class)
                        .headless(false)
                        .web(WebApplicationType.NONE)
                        .run(args);

        // Crear un objeto Swing
        SwingUtilities.invokeLater(() ->{
            ZonaFitForma zonaFitForma = contextSpring.getBean(ZonaFitForma.class);
            zonaFitForma.setVisible(true);
        });
    }
}
