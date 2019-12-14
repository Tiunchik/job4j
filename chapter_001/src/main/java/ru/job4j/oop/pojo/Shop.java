/**
 * Тестовое задание по работе с циклами, объектами (моделями данных) - удаление значений в массиве и его сортировка
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.pojo;

/**
 * Shop - класс для отработки удаления значения из массива объектов с его пследующей сортировкой
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 14.12.2019
 */
public class Shop {
    /**
     * Метод для занулеия значния в амссиве ссылочных переменных и его сортировки
     *
     * @param array - пердаваемый на удаление и сортировку массив
     * @param index - индекс ячейки массива, которую зануляют
     * @return - возвращаемый массив, с занулённой переменной, отсортрованный ( все значения null перемещены
     * к часть массива с наибольшими значениями индексов
     */
    public Product[] delete(Product[] array, int index) {
        array[index] = null;
        for (int mainCircle = 0; mainCircle < array.length; mainCircle++) {
            if (array[mainCircle] == null) {
                int secCircle = mainCircle;
                while (array[mainCircle] == null && secCircle < array.length) {
                    if (array[secCircle] != null) {
                        array[mainCircle] = array[secCircle];
                        array[secCircle] = null;
                    }
                    secCircle++;
                }
            }
        }
        return array;
    }

    /**
     * Метод для вывода значений массива в консоль
     *
     * @param array - выводимый в консоль массив
     */
    public void print(Product[] array) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] != null) {
                System.out.println(array[index].getName() + " " + array[index].getCount());
            } else {
                System.out.println("null");
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        Product[] rec = new Product[7];
        rec[0] = new Product("Eggs", 17);
        rec[1] = new Product("Bread", 12);
        rec[2] = new Product("Oil", 25);
        rec[3] = new Product("Meat", 4);
        shop.print(rec);
        rec = shop.delete(rec, 3);
        shop.print(rec);
    }
}
