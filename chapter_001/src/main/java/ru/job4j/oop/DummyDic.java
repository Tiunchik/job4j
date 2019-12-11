/**
 * Тестовое задание по работе с методами возвращющими значение
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop;

/**
 * Класс для тестового задания по работе с методами возвращющими значение
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 11.12.2019
 */
public class DummyDic {
    /**
     * Метод возвращающий назад значние типа String с добавлнием дополнитльных слов
     *
     * @param eng - вводимый в метод апраметр типа String
     * @return - взващает "Неизвестное слово. " + eng
     */
    public String engToRus(String eng) {
        return "Неизвестное слово. " + eng;
    }
}
