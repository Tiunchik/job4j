/**
 * Пакет для работы с лямдда выражениями и Steam API
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.lambda.tourism;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс Profile - класс модель данных
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 29.12.2019
 */
public class Profiles {

    /**
     * Метод извлечения всех адресов из профилей клиентов
     *
     * @param profiles - коллекция профилей клиетов фирмы
     * @return - коллекция адресов клиентов фирмы
     */
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).distinct().
                sorted(((o1, o2) -> o1.toString().compareTo(o2.toString()))).collect(Collectors.toList());
    }
}
