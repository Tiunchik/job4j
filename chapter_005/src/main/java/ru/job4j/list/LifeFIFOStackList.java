/**
 * Пакет для работы с коллекциями, разаботка упрощённых аналогов коллекций
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.list;

/**
 * Класс LifeFIFOStackList - класс коллкеция с сортировкой по принципу FIFO,
 * основанная на композиции двух классов LifeStackList, работающих по принципу LIFO
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.3
 * @since 10.01.2019
 */
public class LifeFIFOStackList<E> {
    /**
     * Внутрнние коллекции на принципе LIFO
     */
    private LifeStackList<E> back = new LifeStackList<>();
    private LifeStackList<E> prime = new LifeStackList<>();

    /**
     * Дефолтный конструктор
     */
    public LifeFIFOStackList() {
    }

    /**
     * Метод возвращает из коллекции первое добавленое туда значение и удаляет его из коллекции
     *
     * @return - первое добавленное значение
     */
    public E poll() {
        if (prime.getSize() == 0) {
            while (back.getSize() != 0) {
                prime.push(back.poll());
            }
        }
        return prime.poll();
    }

    /**
     * Метод добавляет в коллекцию значение
     *
     * @param value добавляемое значение
     */
    public void push(E value) {
        back.push(value);
    }
}
