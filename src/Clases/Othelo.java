/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author joans
 */
public class Othelo {

    private int columnas = 12;
    private int filas = 12;
    char[][] celdasJuego = new char[filas][columnas];
    public int[] xcor;
    public int[] ycor;
    public Jugador j1 = new Jugador();
    public Jugador j2 = new Jugador();
    public int[] xPosibles = {0, 0, 0, 1, 1, 2, 2, 2};
    public int[] yPosibles = {0, 1, 2, 0, 2, 0, 1, 2};
    int xInicial;
    int yInicial;

    public Othelo() {
        InicioJuego();
    }

    public char getCeldasJuego(int i, int j) {
        return celdasJuego[i][j];
    }

    public void InicioJuego() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i == 5 && j == 5 || i == 6 && j == 6) {
                    celdasJuego[i][j] = 'X';
                } else if (i == 5 && j == 6 || i == 6 && j == 5) {
                    celdasJuego[i][j] = 'O';
                } else {
                    celdasJuego[i][j] = '.';
                }

            }
        }
        
        celdasJuego[5][7]='p';
        celdasJuego[6][4]='p';
        celdasJuego[7][5]='p';
        celdasJuego[4][6]='p';
        
      

    }

    public void mostrar() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < filas; j++) {
                System.out.print(celdasJuego[i][j] + "\t");
                if (j == 11) {
                    System.out.println("\n");
                }
            }
        }
    }

    public boolean compMovimiento(int i, int j, char contrario) {
        boolean result = false;
        if (i >= 0 && j >= 0 && i < celdasJuego[0].length && j < celdasJuego[0].length) {
            if (celdasJuego[i][j] == '.') {
                result = false;
            }
            if(celdasJuego[i][j] == contrario){
             result = true;
            }
        }
        return result;
    }

    /**
     * SE COMPRUEBA POSIBLES ESPACIOS
     *
     * @param filaOrigen
     * @param columnaOrigen
     * @param c
     * @return
     */
    public void adyacentesA(int filaOrigen, int columnaOrigen, char c) {

        if (!(filaOrigen >= 0
                && filaOrigen <= (filas - 1)
                && columnaOrigen >= 0
                && columnaOrigen <= (columnas - 1))) {
            return;
        }

        int numPosiciones;

        if (filaOrigen == 0 || filaOrigen == (filas - 1)) {
            if (columnaOrigen == 0 || columnaOrigen == (columnas - 1)) {
                numPosiciones = 3;
            } else {
                numPosiciones = 5;
            }
        } else {
            if (columnaOrigen == 0 || columnaOrigen == (columnas - 1)) {
                numPosiciones = 5;
            } else {
                numPosiciones = 8;
            }
        }
        //int[][] posiciones = new int[numPosiciones][2];
        int[] arrayFilas = new int[numPosiciones];
        int[] arrayColumnas = new int[numPosiciones];

        int indicePosicion = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {

                if ((i != 0 || j != 0)
                        && (filaOrigen + i) >= 0
                        && (filaOrigen + i) <= (filas - 1)
                        && (columnaOrigen + j) >= 0
                        && (columnaOrigen + j) <= (columnas - 1)) {
                    arrayFilas[indicePosicion] = filaOrigen + i;
                    arrayColumnas[indicePosicion] = columnaOrigen + j;
                    indicePosicion++;
                }

            }

        }
        this.xcor = arrayFilas;
        this.ycor = arrayColumnas;
        //buscarEspaciosDisponibles
       

    }
    int tP;
    public void buscarEspaciosDisponibles(char turn1,char turn2){
      
     for (int i = 0; i < xcor.length; i++) {
     if (compMovimiento(xcor[i],ycor[i],turn2)){
     if(i==0){//ARRIBA IZQUIERDA
     tP=i;
     seguimiento(i,turn2);
     }
     if(i==1){//ARRIBA IZQUIERDA
     tP=i;
     seguimiento(i,turn2);
     }
     if(i==2){//ARRIBA IZQUIERDA
     tP=i;
     seguimiento(i,turn2);
     }
     if(i==3){//ARRIBA IZQUIERDA
     tP=i;
     seguimiento(i,turn2);
     }
     if(i==4){//ARRIBA IZQUIERDA
     tP=i;
     seguimiento(i,turn2);
     }if(i==5){//ARRIBA IZQUIERDA
     tP=i;
     seguimiento(i,turn2);
     }
     if(i==6){//ARRIBA IZQUIERDA
     tP=i;
     seguimiento(i,turn2);
     }
     if(i==7){//ARRIBA IZQUIERDA
     tP=i;
     seguimiento(i,turn2);
     }
     
     
     }
     }
    }

    public void seguimiento(int i,char turn2){
    if(i==0){
    adyacentesA(xcor[i],ycor[i],turn2);
    if(compMovimiento(xcor[i],ycor[i],turn2)){
    seguimiento(0,turn2);
    }else{
    celdasJuego[xcor[i]][ycor[i]]='p';
    }
    }
    if(i==1){
    adyacentesA(xcor[i],ycor[i],turn2);
    if(compMovimiento(xcor[i],ycor[i],turn2)){
    seguimiento(1,turn2);
    }else{
    celdasJuego[xcor[i]][ycor[i]]='p';
    }
    }
    
    if(i==2){
    adyacentesA(xcor[i],ycor[i],turn2);
    if(compMovimiento(xcor[i],ycor[i],turn2)){
    seguimiento(2,turn2);
    }else{
    celdasJuego[xcor[i]][ycor[i]]='p';
    }
    }
    
    if(i==3){
    adyacentesA(xcor[i],ycor[i],turn2);
    if(compMovimiento(xcor[i],ycor[i],turn2)){
    seguimiento(3,turn2);
    }else{
    celdasJuego[xcor[i]][ycor[i]]='p';
    }
    }
    if(i==4){
    adyacentesA(xcor[i],ycor[i],turn2);
    if(compMovimiento(xcor[i],ycor[i],turn2)){
    seguimiento(4,turn2);
    }else{
    celdasJuego[xcor[i]][ycor[i]]='p';
    }
    }
    if(i==5){
    adyacentesA(xcor[i],ycor[i],turn2);
    if(compMovimiento(xcor[i],ycor[i],turn2)){
    seguimiento(5,turn2);
    }else{
    celdasJuego[xcor[i]][ycor[i]]='p';
    }
    }
    if(i==6){
    adyacentesA(xcor[i],ycor[i],turn2);
    if(compMovimiento(xcor[i],ycor[i],turn2)){
    seguimiento(6,turn2);
    }else{
    celdasJuego[xcor[i]][ycor[i]]='p';
    }
    }
    if(i==7){
    adyacentesA(xcor[i],ycor[i],turn2);
    if(compMovimiento(xcor[i],ycor[i],turn2)){
    seguimiento(7,turn2);
    }else{
    celdasJuego[xcor[i]][ycor[i]]='p';
    }
    }
    }
    

  

    public void crearJugadores() {
        try {
            j1.setNombre(JOptionPane.showInputDialog(null, "¿Como podemos nombrar al jugador 1?", "OTHELLO", JOptionPane.QUESTION_MESSAGE).toUpperCase());
            j2.setNombre(JOptionPane.showInputDialog(null, "¿Como podemos nombrar al jugador 2?", "OTHELLO", JOptionPane.QUESTION_MESSAGE).toUpperCase());
        } catch (Exception e) {
            System.out.println("Tratando -> No comentarios.");
        }

    }

    public void mosta(int h, int k, char c) {
        xInicial = h;
        yInicial = k;
        adyacentesA(h, k, c);
        //buscarEspacios();

        System.out.println("8 posiciones");
        for (int i = 0; i < xcor.length; i++) {

            System.out.print(xcor[i] + " ");
            System.out.print(ycor[i] + " ");

            System.out.println("");
        }

    }

}
