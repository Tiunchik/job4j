/**
 * Учебное задание по дефрагментации массива (null знчения перемещаються в конец массива)
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.array;

/**
 * Класс для метода организации дефрагментации массива (null знчения перемещаються в конец массива)
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 08.12.2019
 */
public class Defragment {

    /**
     * Метод по сортировке линейного массива типа String, значения null перемещаються в конец массива
     *
     * @param array - массив подвергаемый сортровке/дефрагментации
     * @return возвращаемый отсортированный массив
     */
    public static String[] compress(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                int j = i;
                while (array[i] == null && j < array.length) {
                    if (array[j] != null) {
                        array[i] = array[j];
                        array[j] = null;
                    }
                    j++;
                }
            }
            System.out.print(array[i] + " ");
        }
        return array;
    }

    /**
     * Метод main
     *
     * @param args - args.
     */
    public static void main(String[] args) {
        String[] input = {"I", null, "wanna", null, "be", null, "compressed"};
        String[] compressed = compress(input);
        System.out.println();
        for (int index = 0; index < compressed.length; index++) {
            System.out.print(compressed[index] + " ");
        }
    }
}
