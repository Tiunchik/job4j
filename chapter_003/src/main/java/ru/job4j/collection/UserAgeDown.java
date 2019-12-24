/**
 * Пакет для работы с коллекциями ArrayList/LinkedList/HashSet/TreeSet и так же сортировкой компоратором
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection;

import java.util.Comparator;
/**
 * Класс UserAgeUp реализует компоратор для объкета User, обратная сортировка по полю Age
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 24.12.2019
 */
public class UserAgeDown implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return Integer.compare(o2.getAge() - o1.getAge(), 0);
    }
}
