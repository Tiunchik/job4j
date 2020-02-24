/**
 * Package ru.job4j.crosszero for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
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
 * @since 24.02.2020
 */
public class Config implements InterfaceProperties {
    private static final Logger LOG = LogManager.getLogger(Config.class.getName());

    private final String url;

    Config(String url) {
        this.url = url;
        createConfig(url);
    }


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

    @Override
    public void save(Properties prop, String url) {
        try (Writer tempOut = Files.newBufferedWriter(Paths.get(url))) {
            prop.store(tempOut, "App propirties");
            tempOut.flush();
        } catch (IOException e) {
            LOG.error("Save exception", e);
        }
    }

    private void createConfig(String url) {
        Path file = Paths.get(url);
        if (!Files.exists(file, LinkOption.NOFOLLOW_LINKS)) {
            Properties prop = new Properties();
            prop.put("ai", "null");
            prop.put("size", "3");
            prop.put("games", "1");
            save(prop, url);
        }
    }
}
