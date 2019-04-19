package org.vipsion.oca.vista;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle;

import org.vipsion.oca.controlador.Coordinador;

/**
 * Interfaz gráfica del juego
 *
 * @author Alvaro Perez
 * @see PanelJugador 
 */

public class PanelJugador extends JPanel {

    private JButton tiraDado;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JTextField valorDado;
    private JTextField posicionTablero;
    private Coordinador coordinador;
    private int id;

    /**
     * Asigna una id pasada por parametro
     * @param id numero de identificacion
     */
    public PanelJugador(int id) {
        this.id = id;
        initComponents();
    }
    /**
     * Asigna un coordinador pasado por parametro
     * @param coordinador Objeto de tipo Coordinador
     * @see Coordinador
     */
    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    /**
     * Muestra el valor del dado
     * @param valor valor de Dado
     */
    public void setValorDado(int valor) {
        valorDado.setText(Integer.toString(valor));
    }
    /**
     * Muestra la posicion en el Tablero
     * @param posicion posicion de una ficha en el tablero
     */
    public void setPosicionTablero(int posicion) {
        posicionTablero.setText(Integer.toString(posicion));
    }
    /**
     * 
     */
    public void disableTiraDado() {
        tiraDado.setEnabled(false);
    }
    /**
     * Muestra por pantalla el ganador del juego
     */
    public void setGanador() {
        jLabel1.setText("Jugador " + id + " Ganador!!");
        jLabel1.setForeground(Color.RED);
    }
    
    public void enableTiraDado() {
        tiraDado.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        valorDado = new JTextField();
        posicionTablero = new JTextField();
        tiraDado = new JButton();
        // setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setText("Jugador " + id);
        jLabel2.setText("Estado de la partida:");
        jLabel3.setText("Posición de la ficha: ");
        tiraDado.setText("TiraDado");
        tiraDado.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                juegaActionPerformed(evt);
            }
        });
        valorDado.setText("0");
        valorDado.setPreferredSize(new Dimension(25, 50));
        posicionTablero.setText("1");
        posicionTablero.setPreferredSize(new Dimension(50, 50));
        jLabel1.setFont(jLabel1.getFont().deriveFont(32.0f));
        jLabel2.setFont(jLabel2.getFont().deriveFont(32.0f));
        jLabel3.setFont(jLabel3.getFont().deriveFont(32.0f));

        tiraDado.setFont(tiraDado.getFont().deriveFont(32.0f));
        valorDado.setFont(valorDado.getFont().deriveFont(32.0f));
        posicionTablero.setFont(posicionTablero.getFont().deriveFont(32.0f));
        GroupLayout jPanel1Layout = new GroupLayout(this);
        this.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addGap(58, 58, 58)
                                                                .addComponent(posicionTablero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel1)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(60, 60, 60).addComponent(tiraDado)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(valorDado, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))).addContainerGap(275, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup().addGap(51, 51, 51)
                                .addComponent(jLabel1)
                                .addGap(58, 58, 58)
                                .addComponent(jLabel2)
                                .addGap(57, 57, 57)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(posicionTablero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(85, 85, 85)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(tiraDado)
                                        .addComponent(valorDado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(102, Short.MAX_VALUE)));
    }

    /**
     * Da la ordena de jugar a Coordinador
     * @param evt ?
     */
    private void juegaActionPerformed(ActionEvent evt) {
        coordinador.juega();
    }

}
