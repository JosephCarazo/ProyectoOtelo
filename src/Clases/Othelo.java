/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
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

    public void setCeldasJuego(int i, int j, char guardar, char contrario) {
        this.celdasJuego[i][j] = guardar;
        this.adyacentesB(i, j, contrario, guardar);

    }

    public void adyacentesB(int filaOrigen, int columnaOrigen, char contrario, char finall) {

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
        ArrayList<Integer> Xpos = new ArrayList<>();
        ArrayList<Integer> Ypos = new ArrayList<>();
        for (int i = 0; i < arrayFilas.length; i++) {

            if (compMovimiento(arrayFilas[i], arrayColumnas[i], contrario)) {

                voltearDemasFichas(arrayFilas.length, i, arrayFilas[i], arrayColumnas[i], contrario, finall, Xpos, Ypos);

            }

        }
    }

    public void voltearDemasFichas(int tamañoA, int i, int fila, int columna, char c, char finall, ArrayList XposInic, ArrayList YposInic) {
        switch (tamañoA) {
            case 8:
                if (i == 0) {
                    if (compMovimiento(fila, columna, c) && compMovimiento(fila - 1, columna - 1, c) || compMovimiento(fila - 1, columna - 1, finall)) {
                        XposInic.add(fila);
                        YposInic.add(columna);
                        voltearDemasFichas(tamañoA, i, fila - 1, columna - 1, c, finall, XposInic, YposInic);

                    } else if (compMovimiento(fila, columna, finall)) {
                        for (int x = 0; x < XposInic.size(); x++) {
                            int xp = (int) XposInic.get(x);
                            int yp = (int) YposInic.get(x);
                            celdasJuego[xp][yp] = finall;
                        }

                        return;
                    }
                }

                if (i == 1) {
                    if (compMovimiento(fila, columna, c) && compMovimiento(fila - 1, columna, c) || compMovimiento(fila - 1, columna, finall)) {
                        XposInic.add(fila);
                        YposInic.add(columna);
                        voltearDemasFichas(tamañoA, i, fila -= 1, columna, c, finall, XposInic, YposInic);

                    } else if (compMovimiento(fila, columna, finall)) {
                        System.out.println("opaaaa");
                        for (int x = 0; x < XposInic.size(); x++) {
                            int xp = (int) XposInic.get(x);
                            int yp = (int) (YposInic.get(x));
                            celdasJuego[xp][yp] = finall;
                        }

                        return;
                    }
                }
                if (i == 2) {
                    if (compMovimiento(fila, columna, c) && compMovimiento(fila - 1, columna + 1, c) || compMovimiento(fila - 1, columna + 1, finall)) {
                        XposInic.add(fila);
                        YposInic.add(columna);
                        voltearDemasFichas(tamañoA, i, fila -= 1, columna += 1, c, finall, XposInic, YposInic);
                    } else if (compMovimiento(fila, columna, finall)) {
                        for (int x = 0; x < XposInic.size(); x++) {
                            int xp = (int) XposInic.get(x);
                            int yp = (int) (YposInic.get(x));
                            celdasJuego[xp][yp] = finall;
                        }

                        return;
                    }
                }
                if (i == 3) {
                    if (compMovimiento(fila, columna, c) && compMovimiento(fila, columna - 1, c) || compMovimiento(fila, columna - 1, finall)) {
                        XposInic.add(fila);
                        YposInic.add(columna);
                        voltearDemasFichas(tamañoA, i, fila, columna -= 1, c, finall, XposInic, YposInic);

                    } else if (compMovimiento(fila, columna, finall)) {
                        for (int x = 0; x < XposInic.size(); x++) {
                            int xp = (int) XposInic.get(x);
                            int yp = (int) (YposInic.get(x));
                            celdasJuego[xp][yp] = finall;
                        }

                        return;

                    }
                }
                if (i == 4) {
                    if (compMovimiento(fila, columna, c) && compMovimiento(fila, columna + 1, c) || compMovimiento(fila, columna + 1, finall)) {
                        XposInic.add(fila);
                        YposInic.add(columna);
                        voltearDemasFichas(tamañoA, i, fila, columna += 1, c, finall, XposInic, YposInic);

                    } else if (celdasJuego[fila][columna] == finall) {
                        for (int x = 0; x < XposInic.size(); x++) {
                            int xp = (int) XposInic.get(x);
                            int yp = (int) (YposInic.get(x));
                            celdasJuego[xp][yp] = finall;
                        }
                        return;
                    }
                }

                if (i == 5) {
                    if (compMovimiento(fila, columna, c) && compMovimiento(fila + 1, columna - 1, c) || compMovimiento(fila + 1, columna - 1, finall)) {
                        XposInic.add(fila);
                        YposInic.add(columna);
                        voltearDemasFichas(tamañoA, i, fila += 1, columna -= 1, c, finall, XposInic, YposInic);

                    } else if (compMovimiento(fila, columna, finall)) {
                        for (int x = 0; x < XposInic.size(); x++) {
                            int xp = (int) XposInic.get(x);
                            int yp = (int) (YposInic.get(x));
                            celdasJuego[xp][yp] = finall;
                        }

                        return;
                    }
                }
                if (i == 6) {
                    if (compMovimiento(fila, columna, c) && compMovimiento(fila + 1, columna, c) || compMovimiento(fila + 1, columna, c)) {
                        XposInic.add(fila);
                        YposInic.add(columna);
                        voltearDemasFichas(tamañoA, i, fila + 1, columna, c, finall, XposInic, YposInic);

                    } else if (compMovimiento(fila, columna, finall)) {
                        for (int x = 0; x < XposInic.size(); x++) {
                            int xp = (int) XposInic.get(x);
                            int yp = (int) YposInic.get(x);
                            System.out.println(xp);
                            System.out.println(yp);
                            celdasJuego[xp][yp] = finall;
                        }

                        return;
                    }
                }
                if (i == 7) {
                    if (compMovimiento(fila, columna, c) && compMovimiento(fila + 1, columna + 1, c) || compMovimiento(fila + 1, columna + 1, finall)) {
                        XposInic.add(fila);
                        YposInic.add(columna);
                        voltearDemasFichas(tamañoA, i, fila += 1, columna += 1, c, finall, XposInic, YposInic);

                    } else if (compMovimiento(fila, columna, finall)) {

                        for (int x = 0; x < XposInic.size(); x++) {
                            int xp = (int) XposInic.get(x);
                            int yp = (int) (YposInic.get(x));
                            celdasJuego[xp][yp] = finall;
                        }

                        return;
                    }
                }
                break;
            case 5:

                if (columna == 0 && fila <= 11 && fila >= 0) {  //LADO IZQUIERDO
                    if (i == 0 && fila >= 0 && columna >= 0) {
                        voltearDemasFichas(8, 1, fila, columna, c, finall, XposInic, YposInic);
                    }
                    if (i == 1 && fila >= 0 && columna >= 0) {
                        voltearDemasFichas(8, 2, fila, columna, c, finall, XposInic, YposInic);
                    }
                    if (i == 2 && fila >= 0 && columna >= 0) {
                        voltearDemasFichas(8, 4, fila, columna, c, finall, XposInic, YposInic);
                    }
                    if (i == 3 && fila >= 0 && columna >= 0) {
                        voltearDemasFichas(8, 6, fila, columna, c, finall, XposInic, YposInic);
                    }
                    if (i == 4 && fila >= 0 && columna >= 0) {
                        voltearDemasFichas(8, 7, fila, columna, c, finall, XposInic, YposInic);
                    }

                }
                if (columna == 11 && fila <= 11 && fila >= 0) { //LADO DERECHO
                    if (i == 0 && fila <= 11 && columna <= 11) {
                        voltearDemasFichas(8, 0, fila, columna, c, finall, XposInic, YposInic);
                    }
                    if (i == 1 && fila <= 11 && columna <= 11) {
                        voltearDemasFichas(8, 1, fila, columna, c, finall, XposInic, YposInic);
                    }
                    if (i == 2 && fila <= 11 && columna <= 11) {
                        voltearDemasFichas(8, 3, fila, columna, c, finall, XposInic, YposInic);
                    }
                    if (i == 3 && fila <= 11 && columna <= 11) {
                        voltearDemasFichas(8, 5, fila, columna, c, finall, XposInic, YposInic);
                    }
                    if (i == 4 && fila <= 11 && columna <= 11) {
                        voltearDemasFichas(8, 6, fila, columna, c, finall, XposInic, YposInic);
                    }
                }
                if (fila == 11 && columna >= 0 && columna <= 11) {//LADO ABAJO
                    if (i == 0 && fila <= 11 && columna <= 11) {
                        voltearDemasFichas(8, 0, fila, columna, c, finall, XposInic, YposInic);
                    }
                    if (i == 1 && fila <= 11 && columna <= 11) {
                        voltearDemasFichas(8, 1, fila, columna, c, finall, XposInic, YposInic);
                    }
                    if (i == 2 && fila <= 11 && columna <= 11) {
                        voltearDemasFichas(8, 2, fila, columna, c, finall, XposInic, YposInic);
                    }
                    if (i == 3 && fila <= 11 && columna <= 11) {
                        voltearDemasFichas(8, 3, fila, columna, c, finall, XposInic, YposInic);
                    }
                    if (i == 4 && fila <= 11 && columna <= 11) {
                        voltearDemasFichas(8, 4, fila, columna, c, finall, XposInic, YposInic);
                    }
                }
                if (fila == 0 && columna >= 0 && columna <= 11) {//LADO ARRIBA
                    if (i == 0 && fila <= 11 && columna <= 11) {
                        voltearDemasFichas(8, 3, fila, columna, c, finall, XposInic, YposInic);
                    }
                    if (i == 1 && fila <= 11 && columna <= 11) {
                        voltearDemasFichas(8, 4, fila, columna, c, finall, XposInic, YposInic);
                    }
                    if (i == 2 && fila <= 11 && columna <= 11) {
                        voltearDemasFichas(8, 5, fila, columna, c, finall, XposInic, YposInic);
                    }
                    if (i == 3 && fila <= 11 && columna <= 11) {
                        voltearDemasFichas(8, 6, fila, columna, c, finall, XposInic, YposInic);
                    }
                    if (i == 4 && fila <= 11 && columna <= 11) {
                        voltearDemasFichas(8, 7, fila, columna, c, finall, XposInic, YposInic);
                    }
                }
                break;
            case 3: ///ESQUINAS
                if (fila == 0 && columna == 0) { //ESQUINA IZQUIERDA-ARRIBA
                    if (i == 0) {
                        voltearDemasFichas(8, 4, fila, columna, c, finall, XposInic, YposInic);
                    }
                    if (i == 1) {
                        voltearDemasFichas(8, 6, fila, columna, c, finall, XposInic, YposInic);
                    }
                    if (i == 2) {
                        voltearDemasFichas(8, 7, fila, columna, c, finall, XposInic, YposInic);
                    }
                }
                if (fila == 11 && columna == 0) {//ESQUINA IZQUIERDA-ABAJO
                    if (i == 0) {
                        voltearDemasFichas(8, 1, fila, columna, c, finall, XposInic, YposInic);
                    }
                    if (i == 1) {
                        voltearDemasFichas(8, 2, fila, columna, c, finall, XposInic, YposInic);
                    }
                    if (i == 2) {
                        voltearDemasFichas(8, 4, fila, columna, c, finall, XposInic, YposInic);
                    }
                }
                if (fila == 11 && columna == 11) { //ESQUINA DERECHA- ABAJO
                    if (i == 0) {
                        voltearDemasFichas(8, 0, fila, columna, c, finall, XposInic, YposInic);
                    }
                    if (i == 1) {
                        voltearDemasFichas(8, 1, fila, columna, c, finall, XposInic, YposInic);
                    }
                    if (i == 2) {
                        voltearDemasFichas(8, 3, fila, columna, c, finall, XposInic, YposInic);
                    }
                }
                if (fila == 0 && columna == 11) {//ESQUINA DERECHA-ARRIBA
                    if (i == 0) {
                        voltearDemasFichas(8, 3, fila, columna, c, finall, XposInic, YposInic);
                    }
                    if (i == 1) {
                        voltearDemasFichas(8, 5, fila, columna, c, finall, XposInic, YposInic);
                    }
                    if (i == 2) {
                        voltearDemasFichas(8, 6, fila, columna, c, finall, XposInic, YposInic);
                    }
                }

                break;

        }
    }

    public void buscar(char porBuscar, char contraria) {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                if (celdasJuego[i][j] == porBuscar) {
                    adyacentesA(i, j, contraria);

                }
            }
        }

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

        celdasJuego[5][7] = 'p';
        celdasJuego[6][4] = 'p';
        celdasJuego[7][5] = 'p';
        celdasJuego[4][6] = 'p';

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
     *
     * @param filaOrigen
     * @param columnaOrigen
     * @param c
     * @return
     */
    public void adyacentesA(int filaOrigen, int columnaOrigen, char contrario) {

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

        for (int i = 0; i < arrayFilas.length; i++) {

            if (compMovimiento(arrayFilas[i], arrayColumnas[i], contrario)) {
                seguir(arrayFilas.length, i, arrayFilas[i], arrayColumnas[i], contrario);

            }

        }
    }

    public void clean() {
        for (int k = 0; k < 12; k++) {
            for (int l = 0; l < 12; l++) {
                if (celdasJuego[k][l] == 'p') {
                    celdasJuego[k][l] = '.';

                }
            }
        }
    }

    // this.xcor = arrayFilas;
    // this.ycor = arrayColumnas;
    public void seguir(int tamañoA, int i, int fila, int columna, char c) {
        switch (tamañoA) {
            case 8:
                if (i == 0) {

                    if (compMovimiento(fila, columna, c)) {
                        seguir(tamañoA, i, fila - 1, columna - 1, c);
                    } else if (compMovimiento(fila, columna, '.') && compMovimiento(fila + 1, columna + 1, c)) {
                        celdasJuego[fila][columna] = 'p';
                        return;
                    }
                }

                if (i == 1) {
                    if (compMovimiento(fila, columna, c)) {
                        seguir(tamañoA, i, fila - 1, columna, c);
                    } else if (compMovimiento(fila, columna, '.') && compMovimiento(fila + 1, columna, c)) {
                        celdasJuego[fila][columna] = 'p';
                        return;
                    }
                }
                if (i == 2) {
                    if (compMovimiento(fila, columna, c)) {
                        seguir(tamañoA, i, fila - 1, columna + 1, c);
                    } else if (compMovimiento(fila, columna, '.') && compMovimiento(fila + 1, columna - 1, c)) {
                        celdasJuego[fila][columna] = 'p';
                        return;
                    }
                }
                if (i == 3) {
                    if (compMovimiento(fila, columna, c)) {
                        seguir(tamañoA, i, fila, columna - 1, c);
                        return;
                    } else if (compMovimiento(fila, columna, '.') && compMovimiento(fila, columna + 1, c)) {
                        celdasJuego[fila][columna] = 'p';

                    }
                }
                if (i == 4) {
                    if (celdasJuego[fila][columna] == c) {
                        seguir(tamañoA, i, fila, columna + 1, c);
                        return;
                    } else if (celdasJuego[fila][columna] == '.' && celdasJuego[fila][columna - 1] == c) {
                        celdasJuego[fila][columna] = 'p';
                        return;
                    }
                }

                if (i == 5) {
                    if (compMovimiento(fila, columna, c)) {
                        seguir(tamañoA, i, fila + 1, columna - 1, c);
                    } else if (compMovimiento(fila + 1, columna - 1, '.') && compMovimiento(fila - 1, columna + 1, c)) {
                        celdasJuego[fila][columna] = 'p';
                        return;
                    }
                }
                if (i == 6) {
                    if (celdasJuego[fila][columna] == c) {
                        seguir(tamañoA, i, fila + 1, columna, c);
                    } else if (compMovimiento(fila, columna, '.') && compMovimiento(fila - 1, columna, c)) {
                        celdasJuego[fila][columna] = 'p';
                        return;
                    }
                }
                if (i == 7) {
                    if (compMovimiento(fila, columna, c)) {
                        seguir(tamañoA, i, fila + 1, columna + 1, c);
                    } else if (compMovimiento(fila, columna, '.') && compMovimiento(fila - 1, columna - 1, c)) {
                        celdasJuego[fila][columna] = 'p';
                        return;
                    }
                }
                break;
            case 5:
                if (fila <= 11 && fila >= 0 && columna == 0) {
                    if (i == 0) {
                        seguir(tamañoA, 1, fila, columna, c);
                    }
                    if (i == 2) {
                        seguir(tamañoA, 2, fila, columna, c);

                    }
                }
        }
    }

    int contador;

    public String preguntarNombre(int num) {
        String nombre = JOptionPane.showInputDialog(null, "¿Como podemos nombrar al jugador " + num + "?", "OTHELLO", JOptionPane.QUESTION_MESSAGE).toUpperCase();
        return nombre;
    }

    public void crearJugadores() {
        try {
            do {
                j1.setNombre(preguntarNombre(1));
                j2.setNombre(preguntarNombre(2));
                if ("".equals(j1.getNombre()) || "".equals(j2.getNombre()) && j1.getNombre().length() > 8 || j2.getNombre().length() > 8) {
                    JOptionPane.showMessageDialog(null, "No ha ingresado alguno de los dos nombres para el usuario o los nombres son demasiado largos. \nIntentelo de nuevo", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                j1.setFicha('X');
                j2.setFicha('O');
            } while ("".equals(j1.getNombre()) || "".equals(j2.getNombre()) && j1.getNombre().length() > 8 || j2.getNombre().length() > 8);

        } catch (Exception e) {
            System.out.println("Tratando -> No comentarios.");
        }

    }

    public void mosta(int h, int k, char c) {
        xInicial = h;
        yInicial = k;

        //buscarEspacios();
        System.out.println("8 posiciones");
        for (int i = 0; i < xcor.length; i++) {

            System.out.print(xcor[i] + " ");
            System.out.print(ycor[i] + " ");

            System.out.println("");
        }

    }

}
