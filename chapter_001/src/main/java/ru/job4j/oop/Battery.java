/**
 * Тестовое задание по отработке взаимодействия между объектами посредством методов
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop;

/**
 * Класс по отработке взаимодействия между объектами посредством методов
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 11.12.2019
 */
public class Battery {
    /**
     * В переменной записан заряд батареи
     */
    short charge;

    /**
     * Конструктор класса Battery
     *
     * @param load - аргумент параметра load передаётся переменной экземпляра charge
     */
    public Battery(int load) {
        this.charge = (short) load;
    }

    /**
     * Забирает значение charge у вызвавшего метод объекта, и добавляет другому
     *
     * @param another - объект у котоого забирают значение charge
     */
    public void exchange(Battery another) {
        another.charge += this.charge;
        this.charge = 0;
    }
}
