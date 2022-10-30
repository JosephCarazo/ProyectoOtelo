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

    /**
     * Creates new form FrmOthello
     */
    public FrmOthello() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.ocultar();
        this.crearMatriz();
        otelo.mostrar();
    }

    public void crearJugadres() {
        otelo.crearJugadores();
        lblNombre1.setText(otelo.j1.getNombre());
        lblNombreTurno.setText(otelo.j1.getNombre());
        lblNombre2.setText(otelo.j2.getNombre());
    }

    public void ocultar() {
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
        lbl2.setVisible(false);
        lblLetras.setVisible(false);
        lblContador1.setVisible(false);
        lblContador2.setVisible(false);
        lblNombreTurno.setVisible(false);
        lblMarcoTurno.setVisible(false);
        lblTurno.setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icono = new ImageIcon("src/Imagenes/Othellogame1.png");//pone el icono en la ventana
        this.setIconImage(icono.getImage());
    }

    public void crearMatriz() {
        int x = 20;
        int y = 10;
        int n = 0;
        boton = new JButton[fila][colum];
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < colum; j++) {
                boton[i][j] = new JButton();
                boton[i][j].setBackground(Color.darkGray);
                boton[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                boton[i][j].setBounds(y, x, 58, 58);

                y += 57;
                n += 1;
                ImageIcon iconobtn = new ImageIcon("src\\Imagenes\\ficha-de-casino1.png");
                ImageIcon iconobtn1 = new ImageIcon("src\\Imagenes\\ficha-de-casino2.png");
                ImageIcon iconobtn2 = new ImageIcon("src\\Imagenes\\posible.png");
                Icon icon3 = new ImageIcon(iconobtn2.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

                Icon icon1 = new ImageIcon(iconobtn.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
                Icon icon2 = new ImageIcon(iconobtn1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
                if (otelo.getCeldasJuego(i, j) == 'X') {
                    boton[i][j].setIcon(icon1);
                } else if (otelo.getCeldasJuego(i, j) == 'O') {
                    boton[i][j].setIcon(icon2);
                } else if (otelo.getCeldasJuego(i, j) == 'p') {
                    boton[i][j].setIcon(icon3);
                }
                boton[i][j].addActionListener(new Action());
                panelMatriz.add(boton[i][j]);

            }
            x += 57;
            y = 10;
        }
        //inicioJuego(0, 0);
    }

//    public void Mortar() {
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                System.out.println(boton[i][j].toString());
//            }
//
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMatriz = new javax.swing.JPanel();
        panelFondo = new javax.swing.JPanel();
        lblPatineta = new javax.swing.JLabel();
        lblNombreTurno = new javax.swing.JLabel();
        lblTurno = new javax.swing.JLabel();
        lblContadorCantidad1 = new javax.swing.JLabel();
        lblContadorCantidad2 = new javax.swing.JLabel();
        lblContador2 = new javax.swing.JLabel();
        lblContador1 = new javax.swing.JLabel();
        lblLetras = new javax.swing.JLabel();
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
        btnIniciar = new javax.swing.JButton();
        lblMarcoTurno = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMatriz.setBackground(new java.awt.Color(7, 8, 84));

        javax.swing.GroupLayout panelMatrizLayout = new javax.swing.GroupLayout(panelMatriz);
        panelMatriz.setLayout(panelMatrizLayout);
        panelMatrizLayout.setHorizontalGroup(
            panelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        panelMatrizLayout.setVerticalGroup(
            panelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );

        getContentPane().add(panelMatriz, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 32, 710, 710));

        panelFondo.setBackground(new java.awt.Color(7, 8, 84));
        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPatineta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GifInicio_2.gif"))); // NOI18N
        lblPatineta.setText("jLabel2");
        panelFondo.add(lblPatineta, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 480, 560));

        lblNombreTurno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNombreTurno.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreTurno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreTurno.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblNombreTurno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblNombreTurno.setName(""); // NOI18N
        panelFondo.add(lblNombreTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 510, 130, 28));

        lblTurno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTurno.setForeground(new java.awt.Color(204, 204, 255));
        lblTurno.setText(" TURNO");
        lblTurno.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblTurno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblTurno.setName(""); // NOI18N
        panelFondo.add(lblTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 480, 60, 28));

        lblContadorCantidad1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblContadorCantidad1.setForeground(new java.awt.Color(255, 255, 255));
        lblContadorCantidad1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblContadorCantidad1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblContadorCantidad1.setName(""); // NOI18N
        panelFondo.add(lblContadorCantidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 350, 60, 28));

        lblContadorCantidad2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblContadorCantidad2.setForeground(new java.awt.Color(255, 255, 255));
        lblContadorCantidad2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblContadorCantidad2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblContadorCantidad2.setName(""); // NOI18N
        panelFondo.add(lblContadorCantidad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 640, 60, 28));

        lblContador2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblContador2.setForeground(new java.awt.Color(204, 204, 255));
        lblContador2.setText("FICHAS:");
        panelFondo.add(lblContador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 650, 50, -1));

        lblContador1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblContador1.setForeground(new java.awt.Color(204, 204, 255));
        lblContador1.setText("FICHAS:");
        panelFondo.add(lblContador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 360, 50, -1));

        lblLetras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/OthelloLetras.png"))); // NOI18N
        panelFondo.add(lblLetras, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 140, 220, 100));

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
        panelFondo.add(lblFichaR, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 690, 40, 50));

        lbl2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl2.setForeground(new java.awt.Color(204, 204, 255));
        lbl2.setText("2");
        panelFondo.add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 590, -1, -1));

        lblFondo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Marco.png"))); // NOI18N
        panelFondo.add(lblFondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 570, 300, 190));

        lblFichaN.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblFichaN.setForeground(new java.awt.Color(255, 255, 255));
        lblFichaN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fichaNegra2.png"))); // NOI18N
        panelFondo.add(lblFichaN, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 400, 40, 50));

        lbl1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl1.setForeground(new java.awt.Color(204, 204, 255));
        lbl1.setText("1");
        panelFondo.add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 300, -1, -1));

        lblFondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Marco.png"))); // NOI18N
        panelFondo.add(lblFondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 280, 300, 190));

        btnIniciar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(204, 204, 255));
        btnIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/OthelloLetras.png"))); // NOI18N
        btnIniciar.setText("TOCA ACÁ PARA INICIAR");
        btnIniciar.setContentAreaFilled(false);
        btnIniciar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIniciar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/OthelloLetras.png"))); // NOI18N
        btnIniciar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/OthelloLetrasGrande.png"))); // NOI18N
        btnIniciar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        panelFondo.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 140, 280, 120));

        lblMarcoTurno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MarcoTurno.png"))); // NOI18N
        panelFondo.add(lblMarcoTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 470, 150, 100));

        getContentPane().add(panelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -100, 1090, 840));

        pack();
    }// </editor-fold>//GEN-END:initComponents
  private void inicioJuego(int i, int j) {
        ImageIcon iconobtn = new ImageIcon("src\\Imagenes\\ficha-de-casino1.png");
        ImageIcon iconobtn1 = new ImageIcon("src\\Imagenes\\ficha-de-casino2.png");
        ImageIcon iconobtn2 = new ImageIcon("src\\Imagenes\\posible.png");
        Icon icon1 = new ImageIcon(iconobtn.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        Icon icon2 = new ImageIcon(iconobtn1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        Icon icon3 = new ImageIcon(iconobtn2.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

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
        lblPatineta.setVisible(false);
        lblNombreTurno.setVisible(true);
        lblMarcoTurno.setVisible(true);
        lblTurno.setVisible(true);
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/Sonidos/Start.wav")));
            clip.start();
        } catch (Exception e) {
        }
        this.crearJugadres();
    }//GEN-LAST:event_btnIniciarActionPerformed

    ///ESTO SIRVE PARA CUANDO SE TOQUE CUALQUIER BOTON SE REALICE UNA ACCION
    class Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 12; j++) {
                    if (e.getSource() == boton[i][j]) {
                        otelo.setCeldasJuego(i, j, 'X');
                        inicioJuego(0, 0);
                        otelo.clean();
                        inicioJuego(0, 0);
                        otelo.buscar();
                        inicioJuego(0, 0);
                        System.out.println("");
                        otelo.mostrar();
                    }

                }

            }

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
            java.util.logging.Logger.getLogger(FrmOthello.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmOthello.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmOthello.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmOthello.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmOthello().setVisible(true);
            }
        });
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.WHITE);
        g.fillRoundRect(15, 51, 4, 800, 1, 1);
        g.fillRoundRect(16, 51, 1048, 2, 1, 1);//Linea de arriba
        g.fillRoundRect(1060, 51, 4, 788, 1, 1);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lblContador1;
    private javax.swing.JLabel lblContador2;
    private javax.swing.JLabel lblContadorCantidad1;
    private javax.swing.JLabel lblContadorCantidad2;
    private javax.swing.JLabel lblFichaN;
    private javax.swing.JLabel lblFichaR;
    private javax.swing.JLabel lblFondo1;
    private javax.swing.JLabel lblFondo2;
    private javax.swing.JLabel lblJugador1;
    private javax.swing.JLabel lblJugador2;
    private javax.swing.JLabel lblLetras;
    private javax.swing.JLabel lblMarcoTurno;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombreTurno;
    private javax.swing.JLabel lblPatineta;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JPanel panelMatriz;
    // End of variables declaration//GEN-END:variables

}
