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

    Scanner scan=new Scanner(System.in);
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
            Scanner contentFileScanner = new Scanner(archivo);

            while (contentFileScanner.hasNextLine()) {

               
                String data = contentFileScanner.nextLine();
                String[] splittedData = data.split(",");
                HashMap<String, String> wordsHashMap = new HashMap<String, String>();

                
                if (splittedData.length == 3) {

                    eng.add(splittedData[0]);
                    esp.add(splittedData[1]);
                    fra.add(splittedData[2]);

                    for (int i = 0; i < 3; i++) {
                        wordsHashMap.put(leng[i], splittedData[i]);
                    }
                }

               
                final HashMap<String, String> newMap = info.put(splittedData[0], wordsHashMap);
                final Association<String, String> association = BT.put(newMap);
                AS.add(association);
            }

            
            contentFileScanner.close();

        // Manejo de errores.
        } catch (FileNotFoundException exception) {

          
            System.out.println("Archivo no encontrado...");
        }
        
    }
}