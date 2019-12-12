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
public class Scheduler extends Manager {
    /**
     * Отображает уровень паники планировщика
     */
    public byte alarm;

    /**
     * Проверка сроков расписания работы, поднятие паники и активизация топа если дедлайн близко
     *
     * @param top - привлекаемый к решению проблемы менеджер проекта
     */
    public void deadLineAlarm(ProjectManager top) {

    }
}
