/**
 * Package ru.job4j.crosszero for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero.options;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.crosszero.interfaces.InterfaceProperties;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Class Config -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 01.03.2020
 */
public class Config implements InterfaceProperties {
    private static final Logger LOG = LogManager.getLogger(Config.class.getName());
    /**
     * name of properties file.
     */
    private final String url;

    /**
     * constructor config file.
     *
     * @param url name of properties file
     */
    public Config(String url) {
        this.url = url;
        createConfig(url);
    }

    /**
     * Load properties file.
     *
     * @param url - name of resource file
     * @return Properties object
     */
    @Override
    public Properties load(String url) {
        try (Reader in = Files.newBufferedReader(Paths.get(url))) {
            Properties config = new Properties();
            config.load(in);
            return config;
        } catch (IOException e) {
            LOG.error("Load exception", e);
        }
        return null;
    }

    /**
     * Save changes into properties file.
     *
     * @param prop saved file
     * @param url name of resource file
     */
    @Override
    public void save(Properties prop, String url) {
        try (Writer tempOut = Files.newBufferedWriter(Paths.get(url))) {
            prop.store(tempOut, "App propirties");
            tempOut.flush();
        } catch (IOException e) {
            LOG.error("Save exception", e);
        }
    }

    /**
     * private config method. create deafult config file if it dosn't exist.
     *
     * @param url name of properties file
     */
    private void createConfig(String url) {
        Path file = Paths.get(url);
        if (!Files.exists(file, LinkOption.NOFOLLOW_LINKS)) {
            Properties prop = new Properties();
            prop.put("aix", "null");
            prop.put("aio", "null");
            prop.put("size", "3");
            prop.put("games", "1");
            save(prop, url);
        }
    }
}
