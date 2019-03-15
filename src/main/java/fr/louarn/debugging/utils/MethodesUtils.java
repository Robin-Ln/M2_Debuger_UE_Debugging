package fr.louarn.debugging.utils;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodesUtils {

    /**
     * Attribute
     */
    static final Logger logger = Logger.getLogger(MethodesUtils.class);


    /**
     * Constructeur
     */

    private MethodesUtils() {
        super();
    }

    /**
     * Methodes
     */
    public static void writeObject(Serializable serializable, String path) {
        if (serializable != null) {
            ObjectOutputStream oos = null;
            try {
                // on simplifie le code en retirant la gestion des exceptions
                File fichier = new File(path);

                // ouverture d'un flux sur un fichier
                oos = new ObjectOutputStream(new FileOutputStream(fichier));

                // sérialization de l'objet
                oos.writeObject(serializable);

                // fermeture du flux dans le bloc finally
            } catch (IOException e) {
                MethodesUtils.logger.error("fail MethodesUtils.writeObject()", e);
            } finally {
                if (oos != null) {
                    try {
                        oos.close();
                    } catch (IOException e) {
                        MethodesUtils.logger.error("fail oos.close()", e);
                    }
                }
            }
        }
    }

    public static Object readObject(String path) {
        // Si le fichier de configuration existe
        if (new File(path).exists()) {
            ObjectInputStream ois = null;
            try {
                // on simplifie le code en retirant la gestion des exceptions
                File fichier = new File(path);

                // ouverture d'un flux sur un fichier
                ois = new ObjectInputStream(new FileInputStream(fichier));

                return ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                MethodesUtils.logger.error("fail MethodesUtils.readObject()",e);
            } finally {
                if (ois != null) {
                    try {
                        ois.close();
                    } catch (IOException e) {
                        MethodesUtils.logger.error("fail ois.close()",e);
                    }
                }
            }
        }
        return null;
    }

    public static PrintStream createPrintStream(String path) {
        try {
            return new PrintStream(new FileOutputStream(path));
        } catch (IOException e) {
            MethodesUtils.logger.error("fail MethodesUtils.createPrintStream()",e);
        }
        return null;
    }

    public static Map<Integer,String> getFileLine(File file, Integer min, Integer max) {
        Map<Integer,String> resultat = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            Integer index = 0;
            while ((line = br.readLine()) != null) {
               if(index >= min && index <= max){
                   resultat.put(index, line);
               }
               index ++;
            }
        } catch (IOException e) {
            MethodesUtils.logger.error("fail MethodesUtils.getFileLine()", e);
        }
        return resultat;
    }

    public static String listeRepertoire(File repertoire, String fichier_chercher) {
        String res = null;
        if (repertoire.isDirectory()) {
            File[] list = repertoire.listFiles();
            for (int i = 0; i < list.length; i++) {
                // Appel récursif sur les sous-répertoires
                File file = list[i];
                if (file.isDirectory()) {
                    res = listeRepertoire(file, fichier_chercher);
                } else {
                    if (fichier_chercher.equals(file.getName())) {
                        res = file.getAbsolutePath();
                    }
                }
            }
        }
        return res;
    }


}
