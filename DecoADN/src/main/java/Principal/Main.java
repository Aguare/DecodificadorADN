package Principal;

/**
 *
 * @author aguare
 */
public class Main {

    private static String[] respuestas;
    private String respuesta;

    public Main(String sA, String sB) {
        respuestas = new String[1];
        separarCaracteres(sA, sB);
        obtenerRespuesta();
    }

    public String getRespuesta() {
        return respuesta;
    }

    /**
     * Se separa la cadena de texto recibidas para luego ser comparadas
     *
     * @param sA cadena de texto 1
     * @param sB cadena de texto 2
     */
    private void separarCaracteres(String sA, String sB) {
        char[] sec1 = new char[sA.length()];
        char[] sec2 = new char[sB.length()];

        for (int i = 0; i < sA.length(); i++) {
            sec1[i] = sA.charAt(i);
        }

        for (int i = 0; i < sB.length(); i++) {
            sec2[i] = sB.charAt(i);
        }
        obtenerConjunto(sec1, sec2);
    }

    private static void obtenerConjunto(char[] sec1, char[] sec2) {
        String r = "";
        for (int i = 0; i < sec1.length; i++) {
            for (int j = 0; j < sec2.length; j++) {
                if (sec1[i] == sec2[j]) {
                    r = obtenerCadena(i, j, sec1, sec2);
                    agregarRespuesta(r);
                }
            }
        }

    }

    private static String obtenerCadena(int a, int b, char[] sec1, char[] sec2) {
        String r = "";
        for (int i = a; i < sec1.length; i++) {
            for (int j = b; j < sec2.length; j++) {
                if (i < sec1.length && sec1[i] == sec2[j]) {
                    r += sec1[i];
                    i++;
                } else {
                    i = sec1.length;
                    break;
                }
            }
        }
        return r;
    }

    private static void agregarRespuesta(String r) {
        for (int i = 0; i < respuestas.length; i++) {
            if (respuestas[i] == null) {
                respuestas[i] = r;
                break;
            }
        }
        String[] copia = respuestas;
        respuestas = new String[respuestas.length + 1];
        System.arraycopy(copia, 0, respuestas, 0, copia.length);
    }

    private void obtenerRespuesta() {
        String r = "";
        for (int i = 0; i < respuestas.length - 1; i++) {
            if (r.length() < respuestas[i].length()) {
                r = respuestas[i];
            }
        }
        this.respuesta = r;
    }
}
