/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

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

    int x;
    int y;

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
    public int[][] adyacentesA(int filaOrigen, int columnaOrigen,char c) {

        if (!(filaOrigen >= 0
                && filaOrigen <= (filas - 1)
                && columnaOrigen >= 0
                && columnaOrigen <= (columnas - 1))) {
            return null;
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
        int[][] posiciones = new int[numPosiciones][2];
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
                    posiciones[indicePosicion][0] = filaOrigen + i;
                    posiciones[indicePosicion][1] = columnaOrigen + j;
                    indicePosicion++;
                }

            }

        }

        return posiciones;

    }
    
    public void comprobador(int[] fila,int[] colum,char c){
        if(fila.length>1){
        int size = 0;
        for(int i=0;i<fila.length;i++){
        if(compMovimiento(fila[i],colum[i],c)){
           size++;   
        }
        }
        int[] arrayFilas = new int[size];
        int[] arrayColumnas = new int[size];
        for(int i=0;i<fila.length;i++){
        if(compMovimiento(fila[i],colum[i],c)){
             arrayFilas[i]=fila[i];
             arrayColumnas[i]=colum[i];
        }
        }
        comprobador(arrayFilas,arrayColumnas,c);
        }else{
        
        }
    }
    
/*
    public void mosta() {
       /// int[][] posiciones8Pos = adyacentesA(0, 0);

        System.out.println("8 posiciones");
        for (int i = 0; i < posiciones8Pos.length; i++) {
            for (int j = 0; j < posiciones8Pos[0].length; j++) {
                System.out.print(posiciones8Pos[i][j] + " ");
            }
            System.out.println("");
        }

    }
*/
}
