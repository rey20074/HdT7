/**
 * Hoja de Trabajo 7: Binary Search Trees
 * 
 * 
 * José Mariano Reyes 20074
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;

public class MainDic {

    static Scanner scan=new Scanner(System.in);
    public static void main(String[] args) {

        //atributos iniciales

        String[] leng = {"Inglés", "Español", "Francés"};
        ArrayList<String> eng = new ArrayList<String>();
        ArrayList<String> esp = new ArrayList<String>();
        ArrayList<String> fra = new ArrayList<String>();

        ArrayList<Association<String, String>> AS = new ArrayList<Association<String, String>>();
        HashMap<String, HashMap<String, String>> info = new HashMap<String, HashMap<String, String>>();
        BinaryTree<HashMap<String, String>> BT = new BinaryTree<HashMap<String, String>>();

        // Codigo para abrir el archivo y alamcenar las palabras en listas
        try {

            File archivo = new File("diccionario.txt");
            Scanner scanArch = new Scanner(archivo);

            while (scanArch.hasNextLine()) {

               
                String data = scanArch.nextLine();
                String[] sepcoma = data.split(",");
                HashMap<String, String> wordsHashMap = new HashMap<String, String>();

                
                if (sepcoma.length == 3) {

                    //Se usara esto para convertir las oraciones
                    eng.add(sepcoma[0]);
                    esp.add(sepcoma[1]);
                    fra.add(sepcoma[2]);

                    for (int i = 0; i < 3; i++) {
                        wordsHashMap.put(leng[i], sepcoma[i]);
                    }
                }

               
                HashMap<String, String> newMap = info.put(sepcoma[0], wordsHashMap);
                Association<String, String> association = BT.almacenar(newMap);
                AS.add(association);
            }

            System.out.println("Palabras almacenadas con exito");
            
            scanArch.close();

        // Manejo de errores.
        } catch (FileNotFoundException exception) {

          
            System.out.println("No hay un archivo con ese nombre");
        }

        boolean run = true;

        while (run) {

            System.out.print("1. Leer archivo.\n2. Salir.\n\nElige una opción: ");
            int option = 0;

            try {

                option = scan.nextInt();

            } catch (InputMismatchException exception) {

                option = 0;
            }

            switch (option) {

                case 1: {

                    System.out.print("\n\nEscoga un Lenguaje:\n1. Inglés.\n2. Español.\n3. Francés.\n-> ");
                    int language = 0;

                    try {

                        language = scan.nextInt();
        
                    } catch (InputMismatchException exception) {
        
                        language = 0;
                    }

                    try {

                        File oracion = new File("oracion.txt");
                        Scanner ScannerOr = new Scanner(oracion);
                        ArrayList<String[]> oracionConvertir = new ArrayList<String[]>();

                        while (ScannerOr.hasNextLine()) {
                            String fila = ScannerOr.nextLine();
                            String[] splitEsp = fila.split(" ");
                            oracionConvertir.add(splitEsp);
                        }

                        switch (language) {

                            case 1: {

                                for (String[] oracionAnali : oracionConvertir) {
                                    ConvertirO.traducir(oracionAnali, esp, eng, fra);
                                }

                                break;

                            } case 2: {

                                for (String[] oracionAnali : oracionConvertir) {
                                    ConvertirO.traducir(oracionAnali, esp, eng, fra);
                                }

                                break;

                            } case 3: {

                                for (String[] oracionAnali : oracionConvertir) {
                                    ConvertirO.traducir(oracionAnali, esp, eng, fra);
                                }

                                break;

                            } default: {

                                System.out.println("No es una opción valida\n");
                                break;
                            }
                        }

                        ScannerOr.close();

                    } catch (FileNotFoundException exception) {

                        // Texto que indica que no se encontró el archivo.
                        System.out.println("No hay un archivo con ese nombre");
                    }

                    break;

                } case 2: {

                    run = false;
                    break;

                } default: {

                    System.out.println("No es una opción valida\n");
                    run = false;
                    break;
                }
            }
        }
        
    }
}