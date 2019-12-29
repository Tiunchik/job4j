/**
 * Пакет для работы с лямдlа выражениями и Steam API
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
 * @version 0.1
 * @since 29.12.2019
 */
public class Profiles {

    /**
     * Метод извлечения всех адресов из профилей клиентов
     *
     * @param profiles - коллекция профилей клиетов фирмы
     * @return - коллкеция адресов клиетов фирмы
     */
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
    }
}
