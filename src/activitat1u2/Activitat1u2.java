package activitat1u2;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Activitat1u2 {
    /**
     * Metode que captura totes les interficies.
     * Un cop capturades a la llista entrem en bucle recorrent una rere altre, agafem la seva direccio mac i la completem en un String
     * Un cop fet aixo la imprimim la interficie la qual tingui mac, les altres no.
     * @param args
     * @throws SocketException 
     */
    public static void main(String[] args) throws SocketException {
        //Llista que captura totes les interficies.
        Enumeration<NetworkInterface> interficies = NetworkInterface.getNetworkInterfaces();
        //Bucle que recorreix la llista
        while (interficies.hasMoreElements()) {
            //Mirem la interficie seguent
            NetworkInterface network = interficies.nextElement();
            //Creem un array de bytes on fiquem la adresa de la interifice
            byte[] direccion = network.getHardwareAddress();
            //En cas de que la interficie tingui una direccio mac entrem dins.
            if (direccion != null) {
                //Inicialitzem un StringBuilder per despres imprimir la MAC en forma de String
                StringBuilder sb = new StringBuilder();
                //Fem un bucle for de la llargada de la direccio MAC
                for (int i = 0; i < direccion.length; i++) {
                    //Anem afegint al string cada parell de numeros seguit d'un gui. En cas de ser l'utlim parell no posem guio.
                    sb.append(String.format("%02X%s", direccion[i], (i < direccion.length - 1) ? "-" : ""));
                }
                //Imprimim la interficie amb la MAC
                System.out.println("Interficie: " + network.getName() + "amb MAC: " + sb.toString());
                System.out.println("--------------------------------------------------");
            }
        }
    }
}
