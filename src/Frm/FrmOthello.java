/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frm;

import Clases.Othelo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Francisco
 */
public class FrmOthello extends javax.swing.JFrame {
    
    Clip clip;
    private int fila = 12;
    private int colum = 12;
    private JButton[][] boton;
    Othelo otelo = new Othelo();
    // se craean variables para contar las ficas de los jugadores
    private int fichasJ1 = 2;//fichas jugador1
    private int fichasJ2 = 2;//fichas jugador2
    int turno;
    ImageIcon iconobtn = new ImageIcon("src\\Imagenes\\ficha-de-casino1.png");
    ImageIcon iconobtn1 = new ImageIcon("src\\Imagenes\\ficha-de-casino2.png");
    ImageIcon iconobtn3 = new ImageIcon("src\\Imagenes\\posible.png");
    ImageIcon iconobtn4 = new ImageIcon("src\\Imagenes\\posible2.png");
    Icon icon1 = new ImageIcon(iconobtn.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    Icon icon2 = new ImageIcon(iconobtn1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    Icon icon3 = new ImageIcon(iconobtn3.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    Icon icon4 = new ImageIcon(iconobtn4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

    /**
     * Creates new form FrmOthello
     */
    public FrmOthello() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.ocultar();
        this.crearMatriz();
        otelo.mostrar();
        turno = 1;
        this.panelFondo.setBackground(Color.BLACK);
    }
    
    public void crearJugadres() {
        otelo.crearJugadores();
        lblNombre1.setText(otelo.j1.getNombre());
        lblNombreTurno.setText(otelo.j1.getNombre());
        lblNombre2.setText(otelo.j2.getNombre());
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                boton[i][j].setBackground(Color.BLACK);
            }
        }
    }
    
    public void ocultar() {
        btnCerrar.setVisible(false);
        panelMatriz.setVisible(false);
        lblNombre1.setVisible(false);
        lblNombre2.setVisible(false);
        lblJugador1.setVisible(false);
        lblJugador2.setVisible(false);
        lblFondo1.setVisible(false);
        lblFondo2.setVisible(false);
        lblFichaN.setVisible(false);
        lblFichaR.setVisible(false);
        lbl1.setVisible(false);
        lblContadorCantidad1.setVisible(false);//se agrega
        lblContadorCantidad2.setVisible(false);//se agrega
        lbl2.setVisible(false);
        lblLetras.setVisible(false);
        lblContador1.setVisible(false);
        lblContador2.setVisible(false);
        lblFichaTurnoActual.setVisible(false);
        lblNombreTurno.setVisible(false);
        lblMarcoTurno.setVisible(false);
        lblTurno.setVisible(false);
        btnReiniciar.setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icono = new ImageIcon("src/Imagenes/Othellogame1.png");//pone el icono en la ventana
        this.setIconImage(icono.getImage());
    }
    
    public void crearMatriz() {
        int x = 20;
        int y = 10;
        int n = 0;
        boton = new JButton[fila][colum];
        ImageIcon primerTurno = new ImageIcon("src\\Imagenes\\fichaNegra2.png");
        Icon lblprimerTurno = new ImageIcon(primerTurno.getImage().getScaledInstance(38, 38, Image.SCALE_DEFAULT));
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < colum; j++) {
                boton[i][j] = new JButton();
                boton[i][j].setBackground(Color.darkGray);
                boton[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                boton[i][j].setBounds(y, x, 58, 58);
                
                y += 57;
                n += 1;
                //
                lblFichaTurnoActual.setIcon(lblprimerTurno);
                
                switch (otelo.getCeldasJuego(i, j)) {
                    case 'X' ->
                        boton[i][j].setIcon(icon1);
                    case 'O' ->
                        boton[i][j].setIcon(icon2);
                    case 'p' ->
                        boton[i][j].setIcon(icon3);
                    default -> {
                    }
                }
                boton[i][j].addActionListener(new Action());
                panelMatriz.add(boton[i][j]);
                
            }
            x += 57;
            y = 10;
        }
        //Se asignan la cantidad de ficahas por defecto de cada jugar
        this.lblContadorCantidad1.setText(String.valueOf(this.fichasJ1));
        this.lblContadorCantidad2.setText(String.valueOf(this.fichasJ2));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        btnIniciar = new javax.swing.JButton();
        lblNombreTurno = new javax.swing.JLabel();
        lblFichaTurnoActual = new javax.swing.JLabel();
        lblTurno = new javax.swing.JLabel();
        btnReiniciar = new javax.swing.JButton();
        lblContadorCantidad1 = new javax.swing.JLabel();
        lblContadorCantidad2 = new javax.swing.JLabel();
        lblContador2 = new javax.swing.JLabel();
        lblLetras = new javax.swing.JLabel();
        lblContador1 = new javax.swing.JLabel();
        lblNombre1 = new javax.swing.JLabel();
        lblNombre2 = new javax.swing.JLabel();
        lblJugador1 = new javax.swing.JLabel();
        lblJugador2 = new javax.swing.JLabel();
        lblFichaR = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lblFondo2 = new javax.swing.JLabel();
        lblFichaN = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lblFondo1 = new javax.swing.JLabel();
        lblMarcoTurno = new javax.swing.JLabel();
        lblStart = new javax.swing.JLabel();
        lblFondoEstatico = new javax.swing.JLabel();
        panelMatriz = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelFondo.setBackground(new java.awt.Color(7, 8, 84));
        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCerrar.setBackground(new java.awt.Color(0, 0, 0));
        btnCerrar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setText("CERRAR");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        panelFondo.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 80, 120, 40));

        btnIniciar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(204, 204, 255));
        btnIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LetrasOthelloBtn.png"))); // NOI18N
        btnIniciar.setText("TOCA ACÁ PARA INICIAR");
        btnIniciar.setContentAreaFilled(false);
        btnIniciar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIniciar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LetrasOthelloBtn.png"))); // NOI18N
        btnIniciar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LetrasOthelloBtn2.png"))); // NOI18N
        btnIniciar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        panelFondo.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 470, 600, 270));

        lblNombreTurno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNombreTurno.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreTurno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelFondo.add(lblNombreTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 510, 70, 20));

        lblFichaTurnoActual.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFichaTurnoActual.setForeground(new java.awt.Color(255, 255, 255));
        lblFichaTurnoActual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFichaTurnoActual.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblFichaTurnoActual.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblFichaTurnoActual.setName(""); // NOI18N
        panelFondo.add(lblFichaTurnoActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 490, 50, 60));

        lblTurno.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblTurno.setForeground(new java.awt.Color(204, 204, 255));
        lblTurno.setText(" TURNO PARA:");
        lblTurno.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblTurno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblTurno.setName(""); // NOI18N
        panelFondo.add(lblTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 480, 80, 28));

        btnReiniciar.setBackground(new java.awt.Color(0, 0, 0));
        btnReiniciar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnReiniciar.setForeground(new java.awt.Color(255, 255, 255));
        btnReiniciar.setText("REINICIAR JUEGO");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });
        panelFondo.add(btnReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 780, 120, 60));

        lblContadorCantidad1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblContadorCantidad1.setForeground(new java.awt.Color(255, 255, 255));
        lblContadorCantidad1.setText("2");
        lblContadorCantidad1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblContadorCantidad1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblContadorCantidad1.setName(""); // NOI18N
        panelFondo.add(lblContadorCantidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 358, 60, 20));

        lblContadorCantidad2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblContadorCantidad2.setForeground(new java.awt.Color(255, 255, 255));
        lblContadorCantidad2.setText("2");
        lblContadorCantidad2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblContadorCantidad2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblContadorCantidad2.setName(""); // NOI18N
        panelFondo.add(lblContadorCantidad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 640, 60, 30));

        lblContador2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblContador2.setForeground(new java.awt.Color(204, 204, 255));
        lblContador2.setText("FICHAS:");
        panelFondo.add(lblContador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 645, 50, 20));

        lblLetras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/OthelloLetras.png"))); // NOI18N
        panelFondo.add(lblLetras, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, 220, 100));

        lblContador1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblContador1.setForeground(new java.awt.Color(204, 204, 255));
        lblContador1.setText("FICHAS:");
        panelFondo.add(lblContador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 360, 50, -1));

        lblNombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNombre1.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblNombre1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblNombre1.setName(""); // NOI18N
        panelFondo.add(lblNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 300, 140, 28));

        lblNombre2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNombre2.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblNombre2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblNombre2.setName(""); // NOI18N
        panelFondo.add(lblNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 590, 140, 28));

        lblJugador1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblJugador1.setForeground(new java.awt.Color(204, 204, 255));
        lblJugador1.setText("JUGADOR:");
        lblJugador1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblJugador1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblJugador1.setName(""); // NOI18N
        panelFondo.add(lblJugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 300, 70, 28));

        lblJugador2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblJugador2.setForeground(new java.awt.Color(204, 204, 255));
        lblJugador2.setText("JUGADOR:");
        lblJugador2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblJugador2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblJugador2.setName(""); // NOI18N
        panelFondo.add(lblJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 590, 70, 28));

        lblFichaR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblFichaR.setForeground(new java.awt.Color(255, 255, 255));
        lblFichaR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fichaRoja2.png"))); // NOI18N
        panelFondo.add(lblFichaR, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 670, 40, 50));

        lbl2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl2.setForeground(new java.awt.Color(204, 204, 255));
        lbl2.setText("2");
        panelFondo.add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 590, -1, -1));

        lblFondo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Marco.png"))); // NOI18N
        panelFondo.add(lblFondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 570, 300, 190));

        lblFichaN.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblFichaN.setForeground(new java.awt.Color(255, 255, 255));
        lblFichaN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fichaNegra2.png"))); // NOI18N
        panelFondo.add(lblFichaN, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 370, 40, 50));

        lbl1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl1.setForeground(new java.awt.Color(204, 204, 255));
        lbl1.setText("1");
        panelFondo.add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 300, -1, -1));

        lblFondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Marco.png"))); // NOI18N
        panelFondo.add(lblFondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 280, 300, 190));

        lblMarcoTurno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MarcoTurno.png"))); // NOI18N
        panelFondo.add(lblMarcoTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 470, 150, 100));

        lblStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/gifStart.gif"))); // NOI18N
        panelFondo.add(lblStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 82, 1080, 750));

        lblFondoEstatico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoNegro.gif"))); // NOI18N
        panelFondo.add(lblFondoEstatico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1080, 740));

        panelMatriz.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout panelMatrizLayout = new javax.swing.GroupLayout(panelMatriz);
        panelMatriz.setLayout(panelMatrizLayout);
        panelMatrizLayout.setHorizontalGroup(
            panelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        panelMatrizLayout.setVerticalGroup(
            panelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );

        panelFondo.add(panelMatriz, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 700, 710));

        getContentPane().add(panelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -90, 1090, 830));

        pack();
    }// </editor-fold>//GEN-END:initComponents
  private void inicioJuego(int i, int j) {
///

        if (i < 12) {
            if (j < 12) {
                if (otelo.getCeldasJuego(i, j) == 'p') {
                    boton[i][j].setIcon(icon3);
                    inicioJuego(i, j += 1);
                }
                if (otelo.getCeldasJuego(i, j) == 'X') {
                    boton[i][j].setIcon(icon1);
                    inicioJuego(i, j += 1);
                }
                if (otelo.getCeldasJuego(i, j) == 'O') {
                    boton[i][j].setIcon(icon2);
                    inicioJuego(i, j += 1);
                }
                if (otelo.getCeldasJuego(i, j) == '.') {
                    boton[i][j].setIcon(null);
                    inicioJuego(i, j += 1);
                }
            } else {
                j = 0;
                inicioJuego(i += 1, j);
            }
            
        }
        
    }

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        panelMatriz.setVisible(true);
        lblNombre1.setVisible(true);
        lblNombre2.setVisible(true);
        lblJugador1.setVisible(true);
        lblJugador2.setVisible(true);
        lblFondo1.setVisible(true);
        lblFondo2.setVisible(true);
        lblFichaN.setVisible(true);
        lblFichaR.setVisible(true);
        lbl1.setVisible(true);
        lbl2.setVisible(true);
        btnIniciar.setVisible(false);
        lblLetras.setVisible(true);
        lblContador1.setVisible(true);
        lblContador2.setVisible(true);
        lblContadorCantidad1.setVisible(true);//se agrega
        lblContadorCantidad2.setVisible(true);//se agrega
        lblFichaTurnoActual.setVisible(true);
        lblNombreTurno.setVisible(true);
        lblMarcoTurno.setVisible(true);
        lblTurno.setVisible(true);
        btnReiniciar.setVisible(true);
        lblStart.setVisible(false);
        lblFondoEstatico.setVisible(true);
        btnCerrar.setVisible(true);
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/Sonidos/Start.wav")));
            clip.start();
        } catch (Exception e) {
        }
        this.crearJugadres();
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        this.dispose();
        FrmOthello frm = new FrmOthello();
        frm.setVisible(true);
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    ///ESTO SIRVE PARA CUANDO SE TOQUE CUALQUIER BOTON SE REALICE UNA ACCION
    class Action implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 12; j++) {
                    if (e.getSource() == boton[i][j] && turno == 1 && otelo.getCeldasJuego(i, j) == 'p') {
                        
                        otelo.setCeldasJuego(i, j, 'X', 'O');
                        otelo.clean();
                        otelo.buscar('O', 'X');
                        ///

                        for (int x = 0; x < 12; x++) {
                            for (int y = 0; y < 12; y++) {
                                if (otelo.getCeldasJuego(x, y) == 'p') {
                                    boton[x][y].setIcon(icon4);
                                    
                                }
                                if (otelo.getCeldasJuego(x, y) == 'X') {
                                    boton[x][y].setIcon(icon1);
                                    
                                }
                                if (otelo.getCeldasJuego(x, y) == 'O') {
                                    boton[x][y].setIcon(icon2);
                                    
                                }
                                if (otelo.getCeldasJuego(x, y) == '.') {
                                    boton[x][y].setIcon(null);
                                    
                                }
                            }
                        }
                        
                        System.out.println("");
                        otelo.mostrar();
                        turno = 2;
                        turnoJugador(turno);
                        contarFichas();//cuenta fichas
                        comprovarNoHayMovimiento();//si no hay movimientodice ganador
                        ganador();
                        
                    } else if (e.getSource() == boton[i][j] && turno == 2 && otelo.getCeldasJuego(i, j) == 'p') {
                        turno = 1;
                        
                        otelo.setCeldasJuego(i, j, 'O', 'X');
                        otelo.clean();
                        otelo.buscar('X', 'O');
                        
                        turnoJugador(turno);
                        for (int x = 0; x < 12; x++) {
                            for (int y = 0; y < 12; y++) {
                                if (otelo.getCeldasJuego(x, y) == 'p') {
                                    boton[x][y].setIcon(icon3);
                                    
                                }
                                if (otelo.getCeldasJuego(x, y) == 'X') {
                                    boton[x][y].setIcon(icon1);
                                    
                                }
                                if (otelo.getCeldasJuego(x, y) == 'O') {
                                    boton[x][y].setIcon(icon2);
                                    
                                }
                                if (otelo.getCeldasJuego(x, y) == '.') {
                                    boton[x][y].setIcon(null);
                                    
                                }
                            }
                        }
                        
                        System.out.println("");
                        otelo.mostrar();
                        contarFichas();//cuenta fichas
                        comprovarNoHayMovimiento();//si no hay movimientodice ganador
                        ganador();
                        
                    }
                    
                }
                
            }
        }
    }

    /*
    Metodo para contar las fichas rojas y negras total de cada jugador
     */
    public void contarFichas() {
        int cont1 = 0;
        int cont2 = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                if (otelo.getCeldasJuego(i, j) == 'X') {
                    cont1++;
                    fichasJ1 = cont1;
                    lblContadorCantidad1.setText(String.valueOf(fichasJ1));
                }
                if (otelo.getCeldasJuego(i, j) == 'O') {
                    cont2++;
                    fichasJ2 = cont2;
                    lblContadorCantidad2.setText(String.valueOf(fichasJ2));
                }
            }
        }
    }

    /*
    metodo para mostrar el nombre y ficha de turno del hugador
     */
    public void turnoJugador(int turno) {
        ImageIcon iconolbl = new ImageIcon("src\\Imagenes\\fichaNegra2.png");
        ImageIcon iconolb2 = new ImageIcon("src\\Imagenes\\fichaRoja2.png");
        Icon lblTurno1 = new ImageIcon(iconolbl.getImage().getScaledInstance(38, 38, Image.SCALE_DEFAULT));
        Icon lblTurno2 = new ImageIcon(iconolb2.getImage().getScaledInstance(38, 38, Image.SCALE_DEFAULT));
        if (turno == 1) {
            lblFichaTurnoActual.setIcon(lblTurno1);
            lblNombreTurno.setText(otelo.j1.getNombre());
        } else if (turno == 2) {
            lblFichaTurnoActual.setIcon(lblTurno2);
            lblNombreTurno.setText(otelo.j2.getNombre());
        }
    }/*
    comprueba que hay espaciocios disponibles y dice ganador
     */
    public void comprovarNoHayMovimiento() {
        int p = 0;
        int fNegras = Integer.parseInt(lblContadorCantidad1.getText());
        int fRojas = Integer.parseInt(lblContadorCantidad2.getText());
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                if (otelo.getCeldasJuego(i, j) == 'p') {
                    p++;
                }
            }
        }
        if (p != 0) {

        } else if (fNegras > fRojas) {
            JOptionPane.showMessageDialog(null, "El ganador es el jugador1  con : [" + fNegras + "] fichas", "Ganador", JOptionPane.INFORMATION_MESSAGE);
        } else if (fNegras < fRojas) {
            JOptionPane.showMessageDialog(null, "El ganador es el jugador2  con : [" + fRojas + "] fichas", "Ganador", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Es un empate ambos jugadores tienen: [" + fNegras + "]  [" + fRojas + "] fichas", "Empate", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    /*
    si el tablero esta totalmente lleno comprueba quien es el ganador
     */
    public void ganador() {
        int cont = 0;
        int fNegras = Integer.parseInt(lblContadorCantidad1.getText());
        int fRojas = Integer.parseInt(lblContadorCantidad2.getText());
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                if (otelo.getCeldasJuego(i, j) == '.') {
                    cont++;
                }
            }
        }
        if (cont != 0) {

        } else if (fNegras > fRojas) {
            JOptionPane.showMessageDialog(null, "El ganador es el jugador1  con : [" + fNegras + "] fichas", "Ganador", JOptionPane.INFORMATION_MESSAGE);
        } else if (fNegras < fRojas) {
            JOptionPane.showMessageDialog(null, "El ganador es el jugador2  con : [" + fRojas + "] fichas", "Ganador", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Es un empate ambos jugadores tienen: [" + fNegras + "]  [" + fRojas + "] fichas", "Empate", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                    
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmOthello.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmOthello.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmOthello.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmOthello.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmOthello().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lblContador1;
    private javax.swing.JLabel lblContador2;
    private javax.swing.JLabel lblContadorCantidad1;
    private javax.swing.JLabel lblContadorCantidad2;
    private javax.swing.JLabel lblFichaN;
    private javax.swing.JLabel lblFichaR;
    private javax.swing.JLabel lblFichaTurnoActual;
    private javax.swing.JLabel lblFondo1;
    private javax.swing.JLabel lblFondo2;
    private javax.swing.JLabel lblFondoEstatico;
    private javax.swing.JLabel lblJugador1;
    private javax.swing.JLabel lblJugador2;
    private javax.swing.JLabel lblLetras;
    private javax.swing.JLabel lblMarcoTurno;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombreTurno;
    private javax.swing.JLabel lblStart;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JPanel panelFondo;
    public javax.swing.JPanel panelMatriz;
    // End of variables declaration//GEN-END:variables

}
