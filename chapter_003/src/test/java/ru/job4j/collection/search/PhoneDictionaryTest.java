/**
 * Пакет для тестов классов содержащихся в пакете ru.job4j.colliection.search
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection.search;

import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Класс PhoneDictionaryTest - класс содержит автоматические методы для проверки работы класса PhoneDictionary
 * тесты предоставлены Petr Arsentev (job4j.ru)
 *
 * @author -
 * @version 0.2
 * @since 31.12.2019
 */
public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }
}
