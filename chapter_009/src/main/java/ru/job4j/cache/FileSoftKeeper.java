/**
 * Package ru.job4j.cache for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.cache;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * Class FileCacheKeeper -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 05.03.2020
 */
public class FileSoftKeeper {
    /**
     * inner logger
     */
    private static final Logger LOG = LogManager.getLogger(FileSoftKeeper.class.getName());

    private final String path;

    /**
     * collection for keeping cache of used files
     */
    private final HashSoftFerMap<String, String> cache = new HashSoftFerMap<>();

    /**
     * Constructor for file keeper, requared url for folder where stored files for caching
     *
     * @param url - link to folder where stored files for caching
     */
    FileSoftKeeper(String url) {
        if (!(url.endsWith("\\") || url.endsWith("/"))) {
            url = url + "/";
        }
        this.path = url;
    }

    public String get(String key) {
        String temp = cache.get(key);
        if (temp == null) {
            temp = load(key);
        }
        if (temp != null) {
            cache.insert(key, temp);
        }
        return temp == null ? "file isn't found" : temp;
    }

    private String load(String key) {
        if (Files.exists(Paths.get(path + key))) {
            try (BufferedReader reader = Files.newBufferedReader(Paths.get(path + key))) {
                return reader.lines().collect(Collectors.joining());
            } catch (IOException e) {
                LOG.error("load file error", e);
            }
        }
        return null;
    }
}
