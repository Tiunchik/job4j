/**
 * Тестовое задание по отработке наследования и переопределения методов
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.textreport;

/**
 * TextReport - подкласс, в нём переопределён метод генерации отчета
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 12.12.2019
 */
public class JSONReport extends TextReport {
    /**
     * метод по генерации отчёта в формету JSON
     *
     * @param name - имя отчёта
     * @param body - тело отчёта
     * @return - отчёт
     */
    public String generate(String name, String body) {
        return "{" + "\n" + "name : " + name + "\n" + "body : " + body + "\n" + "}";
    }

}
