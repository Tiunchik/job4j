/**
 * Пакет для работы с IO, создание сетевого бота
 *
 * @author Maksim Tiunchik
 */

package ru.job4j.oracle;

import java.io.IOException;

/**
 * Класс Input - интерфейс для работы клиента
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 25.01.2020
 */
public interface Input {

    public String answer() throws IOException;
}
