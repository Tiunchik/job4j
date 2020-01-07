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
 * @version 0.1
 * @since 07.01.2019
 */
public class LifeFIFOStackList<E> {
    /**
     * Внутрнние коллекции на принципе LIFO
     */
    private LifeStackList<E> back;
    private LifeStackList<E> prime = new LifeStackList<>();

    /**
     * Дефолтный конструктор
     */
    public LifeFIFOStackList() {
    }

    /**
     * Метод возвращает из коллекции первое добавленое туда значение и удаляет го из коллекции
     *
     * @return - первое добавленное значение
     */
    public E poll() {
        return prime.poll();
    }

    /**
     * Метод добавляет в оллекцию значение
     *
     * @param value добавляемое значение
     */
    public void push(E value) {
        back = new LifeStackList<>();
        E temp = prime.poll();
        while (temp != null) {
            back.push(temp);
            temp = prime.poll();
        }
        back.push(value);
        temp = back.poll();
        while (temp != null) {
            prime.push(temp);
            temp = back.poll();
        }
    }
}
