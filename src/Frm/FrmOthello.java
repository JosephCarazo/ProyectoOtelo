/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frm;

import Clases.Othelo;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icono = new ImageIcon("src/Imagenes/Othellogame1.png");//pone el icono en la ventana
        this.setIconImage(icono.getImage());
        this.crearMatriz();
        jPanel1.setVisible(false);
        lblNombre1.setVisible(false);
        lblNombre2.setVisible(false);
        lblJugador1.setVisible(false);
        lblJugador2.setVisible(false);
        lblFondo1.setVisible(false);
        lblFondo2.setVisible(false);
//        Mortar();
    }

    public void crearJugadres() {
        otelo.crearJugadores();
        lblNombre1.setText(otelo.j1.getNombre());
        lblNombre2.setText(otelo.j2.getNombre());
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
//                boton[i][j].setBounds(y, x, 63, 63);
                boton[i][j].setBounds(y, x, 58, 58);

                y += 54;
                n += 1;

                boton[i][j].addActionListener(new Action());
                jPanel1.add(boton[i][j]);
                inicioJuego(0, 0);

            }
//            x += 60;
//            y = 10;
            x += 57;
            y = 10;
        }
        /*
        ImageIcon iconobtn = new ImageIcon("src\\Imagenes\\ficha-de-casino1.png");
        ImageIcon iconobtn1 = new ImageIcon("src\\Imagenes\\ficha-de-casino2.png");
        Icon icon1 = new ImageIcon(iconobtn.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        Icon icon2 = new ImageIcon(iconobtn1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

        boton[5][5].setIcon(icon1);
        boton[5][6].setIcon(icon2);
        boton[6][5].setIcon(icon2);
        boton[6][6].setIcon(icon1);
         */
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblNombre1 = new javax.swing.JLabel();
        lblNombre2 = new javax.swing.JLabel();
        lblJugador1 = new javax.swing.JLabel();
        lblJugador2 = new javax.swing.JLabel();
        lblFondo2 = new javax.swing.JLabel();
        lblFondo1 = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(7, 8, 84));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 32, 710, 690));

        jPanel2.setBackground(new java.awt.Color(7, 8, 84));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNombre1.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblNombre1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblNombre1.setName(""); // NOI18N
        jPanel2.add(lblNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 300, 140, 28));

        lblNombre2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNombre2.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblNombre2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblNombre2.setName(""); // NOI18N
        jPanel2.add(lblNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 580, 140, 28));

        lblJugador1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblJugador1.setForeground(new java.awt.Color(255, 255, 255));
        lblJugador1.setText("JUGADOR:");
        lblJugador1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblJugador1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblJugador1.setName(""); // NOI18N
        jPanel2.add(lblJugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 300, 70, 28));

        lblJugador2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblJugador2.setForeground(new java.awt.Color(255, 255, 255));
        lblJugador2.setText("JUGADOR:");
        lblJugador2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblJugador2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblJugador2.setName(""); // NOI18N
        jPanel2.add(lblJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 580, 70, 28));

        lblFondo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Marco.png"))); // NOI18N
        jPanel2.add(lblFondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(757, 551, 313, 216));

        lblFondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Marco.png"))); // NOI18N
        jPanel2.add(lblFondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(757, 269, 313, 216));

        btnIniciar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(255, 255, 255));
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
        jPanel2.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 130, 280, 140));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -100, 1090, 840));

        pack();
    }// </editor-fold>//GEN-END:initComponents
  private void inicioJuego(int i, int j) {
        ImageIcon iconobtn = new ImageIcon("src\\Imagenes\\ficha-de-casino1.png");
        ImageIcon iconobtn1 = new ImageIcon("src\\Imagenes\\ficha-de-casino2.png");
        Icon icon1 = new ImageIcon(iconobtn.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        Icon icon2 = new ImageIcon(iconobtn1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        if (i < 12) {
            if (j < 12) {
                if (otelo.getCeldasJuego(i, j) == 'p') {
                    boton[i][j].setBackground(Color.GREEN);
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
                } else {
                    j = 0;
                    inicioJuego(i += 1, j);
                }

            }

        }
    
    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        jPanel1.setVisible(true);
        lblNombre1.setVisible(true);
        lblNombre2.setVisible(true);
        lblJugador1.setVisible(true);
        lblJugador2.setVisible(true);
        lblFondo1.setVisible(true);
        lblFondo2.setVisible(true);
        this.crearJugadres();
    }//GEN-LAST:event_btnIniciarActionPerformed

    ///ESTO SIRVE PARA CUANDO SE TOQUE CUALQUIER BOTON SE REALICE UNA ACCION
    class Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 12; j++) {
                    if (e.getSource() == boton[i][j]) {
                        otelo.mosta(i, j, otelo.getCeldasJuego(i, j));
                        otelo.mostrar();
                        inicioJuego(0, 0);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblFondo1;
    private javax.swing.JLabel lblFondo2;
    private javax.swing.JLabel lblJugador1;
    private javax.swing.JLabel lblJugador2;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre2;
    // End of variables declaration//GEN-END:variables

}
