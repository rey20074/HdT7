/*

    Clase diseñada para convertir las oraciones

    José Mariano Reyes 20074

*/

import java.util.ArrayList;

public class ConvertirO {
    
    //metodo principal encargado de realizar la traduccion
    public static void traducir(String[] oracion, ArrayList<String> primer, ArrayList<String> segundo, ArrayList<String> nuevo) {

        for (int i = 0; i < oracion.length; i++) {

            if (!ConvertirO.PalabraGuardada(nuevo, oracion[i])) {
                //2 casos para los 2 diferentes lenguajes a los caules traducir
                
                if (ConvertirO.PalabraGuardada(primer, oracion[i])) 
                {
                    oracion[i] = ConvertirO.remplazar(primer, nuevo, oracion[i]);
                } 
                else if (ConvertirO.PalabraGuardada(segundo, oracion[i])) 
                {
                    oracion[i] = ConvertirO.remplazar(segundo, nuevo, oracion[i]);
                }
            }

        }

        //Imprime cada palabra en la nueva oracion traducida
        for (String palabra : oracion) {
            System.out.print(palabra + " ");
        }

        System.out.println("\n");
    }

    public static int getIndex(ArrayList<String> lista, String palabra) {

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equalsIgnoreCase(palabra)) {
                return i;
            }
        }

        return -1;
    }

    public static boolean PalabraGuardada(ArrayList<String> palabras, String palabra) {

        for (String guardada : palabras) {
            if (guardada.equalsIgnoreCase(palabra)) {
                return true;
            }
        }

        return false;
    }

    public static String remplazar(ArrayList<String> viejo, ArrayList<String> nuevo, String palabra) {

        int numero = ConvertirO.getIndex(viejo, palabra);
        String nueva = nuevo.get(numero);
        return nueva;
    }

    
}
