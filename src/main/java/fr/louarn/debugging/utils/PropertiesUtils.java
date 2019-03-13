package fr.louarn.debugging.utils;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Classe utilitaire de gestion du chargement et de la sauvegarde des
 * configuration.
 *
 */
public class PropertiesUtils {

    /**
     * Attribute
     */
    static final Logger logger = Logger.getLogger(MethodesUtils.class);

    /**
     * constructeur
     */
    private PropertiesUtils() {
    }

    /**
     * Chargement des propriétés de configuration de l'application (depuis un
     * éventuel fichier de configuration).
     */
    public static Properties loadProperties(String configurationFilePath) {
        Properties properties = new Properties();

        // Si le fichier de configuration existe
        if (new File(configurationFilePath).exists()) {
            FileInputStream in = null;
            try {
                in = new FileInputStream(configurationFilePath);
                properties.load(in);
            } catch (IOException e) {
                MethodesUtils.logger.error("Impossible de charger les configurations", e);
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        MethodesUtils.logger.error("Erreur lors de la fermeture du flux sur le fichier de configuration", e);
                    }
                }
            }
        }

        return properties;
    }

    /**
     * Ecriture du fichier de configuration.
     *
     * @param properties            , Configurations enregistrées?§
     * @param configurationFilePath , Chemin du fichier de configuration à écrire.
     */
    public static void writeProperties(Properties properties, String configurationFilePath) {
        if (properties != null) {
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(configurationFilePath);
                properties.store(out, "Configuration de l'application");
            } catch (IOException e) {
                MethodesUtils.logger.error("Impossible d'enregistrer les configurations", e);
            } finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        MethodesUtils.logger.error("Erreur lors de la fermeture du flux sur le fichier de configuration", e);
                    }
                }
            }
        }
    }
}
