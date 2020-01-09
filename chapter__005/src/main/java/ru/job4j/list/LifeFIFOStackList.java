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
 * @version 0.2
 * @since 07.01.2019
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
        E temp = prime.poll(); //Так как poll вытягивает значение навсегда, то вытягиваем первое значение из стека который должен "возвращать" в FIFO
        while (temp != null) { //Если данное значение не равно нулю, то значит это не первая итерация и все значения переписываються во второй стэк
            back.push(temp);
            temp = prime.poll();
        }
        back.push(value); //Потом новое значение кладём последним в только что записанный второй стэк
        temp = back.poll(); // запускаем цикл и все значения LIFO стэка переписываем в цикл, который имулирует FIFO
        while (temp != null) {
            prime.push(temp);
            temp = back.poll();
        }
    } // Профит
}
