/**
 * Тестовое задание по отработке наследования, поля объектов, методы, создание линейки суперклассов
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.career;

/**
 * Подкласс управленческих профессий
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 12.12.2019
 */
public class ProjectManager extends Manager {
    /**
     * Переменная премиальных для топ-менеджера
     */
    private int bonus;

    /**
     * Стимуляция спецалиста на работу
     * @param soft - стимулируем спецалист
     */
    public void kickDeveloper(SoftwareDeveloper soft) {
    }

    /**
     * Стимуляция спецалиста на работу
     * @param hard - стимулируем спецалист
     */
    public void kickDeveloper(HardwareDevelopers hard) {
    }
}
