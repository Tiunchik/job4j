/**
 * Учебное задание по поиску значения в массиве
 * @author Maksim Tiunchik
 */
package ru.job4j.array;
/**
 * Класс для осуществелния поиска в одномерных массивах зданного значения
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @since 08.12.2019
 * @version 0.1
 */
public class FindLoop {
    /**
     * Метод для организации поиска заданного изначально значения и
     * возвращения индекса переменной, в котрой есть это значениеж
     * @param data - массив в ктором производиться поиск
     * @param el - значение. которое ищется в массиве
     * @return - возврат индкеса ячейки массива, где находится искомое значение
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++ ) {
            if  (data[index] == el)  {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
