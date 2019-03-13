package fr.louarn.debugging.debuggueur.utils;

import java.io.*;

public class MethodesUtils {

    /**
     * Constructeur
     */

    private MethodesUtils() {
        super();
    }

    /**
     * Methodes
     */
    static public void writeObject(Serializable serializable, String path) {
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
            System.err.println("fail MethodesUtils.writeObject()");
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static public Object readObject(String path) {
        ObjectInputStream ois = null;
        try {
            // on simplifie le code en retirant la gestion des exceptions
            File fichier = new File(path);

            // ouverture d'un flux sur un fichier
            ois = new ObjectInputStream(new FileInputStream(fichier));

            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("fail MethodesUtils.readObject()");
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    static public PrintStream createPrintStream(String path) {
        try {
            return new PrintStream(new FileOutputStream(path));
        } catch (IOException e) {
            System.err.println("fail MethodesUtils.createPrintStream()");
            e.printStackTrace();
        }
        return null;
    }
}