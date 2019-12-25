/**
 * Пакет для работы с коллекциями ArrayList/LinkedList/HashSet/TreeSet и так же сортировкой компоратором
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection;

import java.util.Comparator;
/**
 * Класс UserAgeUp реализует компоратор для объкета User, обратная сортировка по полю name
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 24.12.2019
 */
public class UserNameDown implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return o2.getName().compareTo(o1.getName());
    }

}
