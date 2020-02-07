/**
 * Пакет ru.job4j.magnit для решения тестового здания магазина Магнит с использованем SQLlite
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.magnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.*;
import java.io.File;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс StoreXML - сохранение списка в xml файл
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 07.02.2019
 */
public class StoreXML {
    private static final Logger LOG = LogManager.getLogger(StoreXML.class.getName());

    private String targetPath;

    public StoreXML(File target) {
        this.targetPath = target.getAbsolutePath();
    }

    public StoreXML(Path target) {
        this.targetPath = target.toAbsolutePath().toString();
    }

    public void save(List<Entry> list) {
        try {
            Entries tempList = new Entries();
            tempList.setTemp(list);
            File file = new File(targetPath);
            JAXBContext context = JAXBContext.newInstance(Entries.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(tempList, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
