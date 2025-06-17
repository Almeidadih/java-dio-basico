import view.TelaInicial;
import javax.swing.*;

public class MainApp {
    public static void main (String [] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }
}
