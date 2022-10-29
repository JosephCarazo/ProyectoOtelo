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
 public int[] xPosibles= {0,0,0,1,1,2,2,2};
  public int[] yPosibles={0,1,2,0,2,0,1,2};
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
            if (celdasJuego[i][j] == contrario) {
                result = true;
            }
        }
        return result;
    }

    /**
     * SE COMPRUEBA POSIBLES ESPACIOS
     * @param filaOrigen
     * @param columnaOrigen
     * @param c
     * @return 
     */
    public void adyacentesA(int filaOrigen, int columnaOrigen,char c) {

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
this.xcor= arrayFilas;
this.ycor= arrayColumnas;
buscarFicha(c,0);

    }
    
    public void comprobador(int[] fila,int[] colum,char c){
        if(fila.length>1){
        int size = 0;
        for(int i=0;i<fila.length;i++){
        if(compMovimiento(fila[i],colum[i],c)){
           size++;   
        }
        }
        
        }else{
        
        
        }
    }
    
    public void buscarFicha(char c,int cont){
        if(xcor.length<cont){
    if(this.compMovimiento(xcor[cont] ,ycor[cont], c)){
    for (int i = 0; i < xcor.length; i++) {
            if(xcor[cont]-xInicial==xPosibles[i]&&ycor[cont]-yInicial==yPosibles[i]){
                System.out.println(i);
            }
        }
    }else{
    buscarFicha(c,cont+=1);
    }
        }
    }
    
    public void crearJugadores(){       
        j1.setNombre(JOptionPane.showInputDialog(null, "¿Como podemos nombrar al jugador 1?", "OTHELLO", JOptionPane.QUESTION_MESSAGE));
        j2.setNombre(JOptionPane.showInputDialog(null, "¿Como podemos nombrar al jugador 2?", "OTHELLO", JOptionPane.QUESTION_MESSAGE));
        
    }
    

    public void mosta(int h,int k, char c) {
        xInicial=h;
        yInicial=k;
       adyacentesA(h, k,c);

        System.out.println("8 posiciones");
        for (int i = 0; i < xcor.length; i++) {
            
                System.out.print(xcor[i] + " ");
                System.out.print(ycor[i] + " ");
            
            System.out.println("");
        }

    }

}
