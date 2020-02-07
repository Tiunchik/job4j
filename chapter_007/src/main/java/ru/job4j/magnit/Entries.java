/**
 * Пакет ru.job4j.magnit для решения тестового здания магазина Магнит с использованем SQLlite
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.magnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Класс Entries - список для хранения модели данных и сохранения через JABX
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 07.02.2020
 */

@XmlRootElement(name = "entries")
public class Entries {

    private List<Entry> temp;

    public List<Entry> getTemp() {
        return temp;
    }

    @XmlElement(name = "entry")
    public void setTemp(List<Entry> temp) {
        this.temp = temp;
    }
}
