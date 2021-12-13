/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuentes;

/**
 *
 * @author ferna
 */
public class EscribirNumeros {

    AnalizarCentenas analizar = new AnalizarCentenas();
    private String numeroIngresado, salida, trio;

    public String EscribirNumero(long numero) {  //  actualizar a double
        salida = "";
        trio = "";
        this.numeroIngresado = Long.toString(numero);

        int largo;

        largo = numeroIngresado.length();
        double modulo = largo % 3;

        if (modulo == 1) {                 // completo con ceros a la izquierda
            numeroIngresado = "00" + numeroIngresado;

        } else if (modulo == 2) {

            numeroIngresado = "0" + numeroIngresado;
        }
        largo = numeroIngresado.length();

        if (largo == 3) {
            salida = analizar.escribirTrio(numeroIngresado, true);  // el arg true-
            // se utiliza cuando no hay sustantivo despues del 1 para no terminar en "un" y si en "uno"
        } else {
            int periodo = largo;

            for (int i = 0; i < largo - 1; i += 3) {

                trio = numeroIngresado.substring(i, i + 3);

                switch (periodo) {
                    case 12:

                        if (trio.equals("000")) {
                            salida += "mil";
                        } else {
                            salida += analizar.escribirTrio(trio, false) + "mil ";
                        }

                        periodo -= 3;
                        break;
                    case 9:

                        if (trio.equals("001") && largo <=9) {
                            salida += "un millon ";
                        } else if (trio.equals("000")) {
                            salida += "millones ";
                        } else {
                            salida += analizar.escribirTrio(trio, false) + "millones ";
                        }

                        periodo -= 3;
                        break;
                    case 6:
                        
                        if (!trio.equals("000")) {
                            salida += analizar.escribirTrio(trio, false) + "mil ";
                        }
                        periodo -= 3;
                        break;
                    case 3:
                        salida += analizar.escribirTrio(trio, true);
                        break;
                }
            }
        }
        return salida;
    }

}
