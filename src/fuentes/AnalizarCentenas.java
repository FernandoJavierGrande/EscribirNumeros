package fuentes;

public class AnalizarCentenas {
    //campos

    String trio;
    private boolean banderauno;
    private String unidad, decena, centena;

//    constructor
    public AnalizarCentenas() {

        trio = "";
        banderauno = false;
        unidad = "";
        decena = "";
        centena = "";
    }

    //metodos
    public String escribirTrio(String trio, boolean banderaUno) {

        this.banderauno = banderaUno;
        this.trio = trio;
        String salida = "", numCen, centLocal, decenaYUnidad = "", unBase = "";

        if (trio.equals("100")) {
            salida = "cien";
        
        } else {                            
            centena = trio.substring(0, 1);
            decena = trio.substring(1, 2);
            unidad = trio.substring(2, 3);

            numCen = unidadBase(centena);

            switch (centena) {
                case "0":
                    centLocal = "";
                    numCen = "";
                    break;
                case "1":
                    centLocal = "ciento";
                    numCen = "";
                    break;
                case "5":
                    centLocal = "quinientos";
                    numCen = "";
                    break;
                case "7":
                    centLocal = "cientos";
                    numCen = "sete";
                    break;
                case "9":
                    centLocal = "cientos";
                    numCen = "nove";
                    break;
                default:
                    centLocal = "cientos";
                    break;
            }
            salida += numCen + centLocal;

            decenaYUnidad = escribirDecena();  // acá entra a la decena y unidad

            if (!centena.equals("0")) {
                salida += " ";

                if (decenaYUnidad.equals("")) {
                    salida += decenaYUnidad;
                } else {
                    salida += decenaYUnidad + " ";
                }
            }else{
                salida += decenaYUnidad + " ";
                
            }

                
        }
        return salida;

    }

    private String escribirDecena() {

        String numUnidad, decenaYUnidad = "", salida = "";
        numUnidad = unidadBase(unidad);

        switch (decena) {
            case "0":
                decenaYUnidad = numUnidad;
                if (unidad.equals("0")) {
                    decenaYUnidad = "";
                }
                break;
            case "1":
                switch (unidad) {
                    case "0":
                        decenaYUnidad = "diez";
                        break;
                    case "1":
                        decenaYUnidad = "once";
                        break;
                    case "2":
                        decenaYUnidad = "doce";
                        break;
                    case "3":
                        decenaYUnidad = "trece";
                        break;
                    case "4":
                        decenaYUnidad = "catorce";
                        break;
                    case "5":
                        decenaYUnidad = "quince";
                        break;
                    case "6":
                        decenaYUnidad = "dieciséis";
                        break;
                    case "7":
                    case "8":
                    case "9":
                        decenaYUnidad = "dieci" + numUnidad;
                        break;
                    default:
                        break;
                }
                break;

            case "2":
                switch (unidad) {
                    case "0":
                        decenaYUnidad = "veinte";
                        break;
                    case "1":
                        decenaYUnidad = "veintiún";
                        if (banderauno) {
                            decenaYUnidad = "veintiuno";
                        }
                        break;
                    case "2":
                        decenaYUnidad = "veintidós";
                        break;
                    case "3":
                        decenaYUnidad = "veintitrés";
                        break;
                    case "4":
                    case "5":
                    case "7":
                    case "8":
                    case "9":
                        decenaYUnidad = "veinti" + numUnidad;
                        break;
                    case "6":
                        decenaYUnidad = "ventiséis";
                        break;
                    default:
                        break;
                }
                break;
            case "3":
                decenaYUnidad = "treinta";
                if (!unidad.equals("0")) {
                    decenaYUnidad = "treinta y " + numUnidad;
                }
                break;
            case "4":
                decenaYUnidad = "cuarenta";
                if (!unidad.equals("0")) {
                    decenaYUnidad = "cuarenta y " + numUnidad;
                }
                break;
            case "5":
                decenaYUnidad = "cincuenta";
                if (!unidad.equals("0")) {
                    decenaYUnidad = "cincuenta y " + numUnidad;
                }
                break;
            case "6":
                decenaYUnidad = "sesenta";
                if (!unidad.equals("0")) {
                    decenaYUnidad = "sesenta y " + numUnidad;
                }
                break;
            case "7":
                decenaYUnidad = "setenta";
                if (!unidad.equals("0")) {
                    decenaYUnidad = "setenta y " + numUnidad;
                }
                break;
            case "8":
                decenaYUnidad = "ochenta";
                if (!unidad.equals("0")) {
                    decenaYUnidad = "ochenta y " + numUnidad;
                }
                break;
            case "9":
                decenaYUnidad = "noventa";
                if (!unidad.equals("0")) {
                    decenaYUnidad = "noventa y " + numUnidad;
                }
                break;
        }

        salida += decenaYUnidad;

        return salida;
    }

    private String unidadBase(String uBase) {
        String salida = "";

        switch (uBase) {
            case "0":
                salida = "";

                if (!banderauno) {
                    salida = "cero";
                }
                break;
            case "1":
                salida = "un";
                if (banderauno) {
                    salida = "uno";
                }
                break;
            case "2":
                salida = "dos";
                break;
            case "3":
                salida = "tres";
                break;
            case "4":
                salida = "cuatro";
                break;
            case "5":
                salida = "cinco";
                break;
            case "6":
                salida = "seis";
                break;
            case "7":
                salida = "siete";
                break;
            case "8":
                salida = "ocho";
                break;
            case "9":
                salida = "nueve";
                break;

        }

        return salida;
    }
}
