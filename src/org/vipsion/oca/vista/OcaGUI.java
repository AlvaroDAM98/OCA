package org.vipsion.oca.vista;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import org.vipsion.oca.controlador.Coordinador;
/**
 * Panel que controla el juego de la OCA
 *
 * @author Alvaro Perez
 * @version 1.0
 * @see PanelJugador
 */
public class OcaGUI extends JFrame {

    private List<PanelJugador> panelesJugador;
    private JLabel label;
    private Coordinador coordinador;

    /**
     * Asigna un coordinador a OcaGUI
     * 
     * @see Coordinador
     * @param coordinador Objeto de tipo Coordinador
     */
    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
        for (PanelJugador panelJugador : panelesJugador) {
            panelJugador.setCoordinador(coordinador);
        }
    }

    /**
     * Inicializa OcaGUI
     */
    public OcaGUI() {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Asigna un valor al dado
     * @param turno Jugador al que pertenece el turno
     * @param valor valor dado por el dado
     * @see org.vipsion.oca.modelo.Dado
     */
    public void setValorDado(int turno, int valor) {
        PanelJugador panelJugador = panelesJugador.get(turno);
        panelJugador.setValorDado(valor);
    }

    /**
     * Asigna una posicion en el tablero para el jugador con el turno actual
     * @param turno Jugador al que pertenece el turno
     * @param valor valor dado por el dado
     */
    public void setPosicionTablero(int turno, int valor) {
        PanelJugador panelJugador = panelesJugador.get(turno);
        panelJugador.setPosicionTablero(valor);
    }
    /**
     * Termia el turno del jugador
     * @param turno Jugador al que pertenece el turno
     */
    public void disableTurno(int turno) {
        PanelJugador panelJugador = panelesJugador.get(turno);
        panelJugador.disableTiraDado();
    }
    /**
     * 
     @param turno Jugador al que pertenece el turno 
     */
    public void sigTurno(int turno) {
        for (PanelJugador panelJugador : panelesJugador) {
            panelJugador.disableTiraDado();
        }
        panelesJugador.get(turno).enableTiraDado();
    }
    /**
     * Inicia el turno del siguiente jugador
     @param turno Jugador al que pertenece el turno 
     */
    public void enableTurno(int turno) {
        PanelJugador panelJugador = panelesJugador.get(turno);
        panelJugador.enableTiraDado();
    }
    /**
     * Asigna un ganador
     @param turno Jugador al que pertenece el turno
     */
    public void setGanador(int turno) {
        PanelJugador panelJugador = panelesJugador.get(turno);
        panelJugador.setGanador();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        panelesJugador = new ArrayList<>();
        PanelJugador panelJugador1 = new PanelJugador(1);
        PanelJugador panelJugador2 = new PanelJugador(2);
        panelesJugador.add(panelJugador1);
        panelesJugador.add(panelJugador2);
        label = new JLabel();
        label.setText("OCA");
        label.setFont(label.getFont().deriveFont(50.0f));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(panelJugador1, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelJugador2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(label)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(panelJugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(panelJugador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))));
        pack();
    }

    public static void main(String args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OcaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OcaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OcaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OcaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new OcaGUI().setVisible(true);
            }
        });
    }
}
