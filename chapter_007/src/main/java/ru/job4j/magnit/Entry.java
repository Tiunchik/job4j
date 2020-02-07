/**
 * Пакет ru.job4j.magnit для решения тестового здания магазина Магнит с использованем SQLlite
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.magnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Класс Entry - модель данных
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 07.02.2020
 */
@XmlRootElement
class Entry {


    private int entry;

    Entry(int temp) {
        this.entry = temp;
    }

    public Entry() {
    }

    public int getEntry() {
        return entry;
    }

    @XmlElement(name = "field")
    public void setEntry(int entry) {
        this.entry = entry;
    }
}
