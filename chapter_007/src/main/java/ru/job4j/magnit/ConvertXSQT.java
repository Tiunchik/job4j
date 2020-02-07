/**
 * Пакет ru.job4j.magnit для решения тестового здания магазина Магнит с использованем SQLlite
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.magnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

/**
 * Класс ConvertXSQT - класс конвертер xml файла
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since м
 */
public class ConvertXSQT {
    private static final Logger LOG = LogManager.getLogger(ConvertXSQT.class.getName());

    public void convert(File source, File dest, File scheme) {
        TransformerFactory factory = TransformerFactory.newInstance();
        try {
            try {
                Transformer transformer = factory.newTransformer(new StreamSource(
                        new FileReader(scheme)));
                transformer.transform(new StreamSource(new FileReader(source)),
                        new StreamResult(dest));
            } catch (IOException x) {
                x.printStackTrace();
            }

        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
