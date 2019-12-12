/**
 * Тестовое задание по работе с аннотацией
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
public class HtmlReport extends TextReport {
    /**
     * Отдельный метод генерации отчёта
     *
     * @param name - имя отчёта
     * @param body - тело отчёта
     * @return - отчёт
     */
    @Override
    public String generate(String name, String body) {
        return "<h1>" + name + "</h1>"
                + "<br/>"
                + "<span>" + body + "</span>";
    }
}