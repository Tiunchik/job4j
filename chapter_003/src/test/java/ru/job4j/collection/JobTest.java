/**
 * Пакет для работы с коллекциями ArrayList/LinkedList/HashSet/TreeSet и так же сортировкой компоратором
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;
/**
 * Класс JobTest исползуется для автоматических тесотв компораторов, в том числе автоматических тестов
 * последовательности компораторов
 *
 * @author -
 * @version -
 * @since 24.12.2019
 */
public class JobTest {

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<User> nameUpAgeUp = new UserNameUp().thenComparing(new UserAgeUp());
        int rsl = nameUpAgeUp.compare(
                new User("Fedor", 26),
                new User("Ivan", 34)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndProrityTwo() {
        Comparator<User> nameUpAgeUp = new UserNameUp().thenComparing(new UserAgeUp());
        int rsl = nameUpAgeUp.compare(
                new User("Fedor", 26),
                new User("Fedor", 34)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void ReversewhenCompatorByNameAndPrority() {
        Comparator<User> nameUpAgeUp = new UserNameDown().thenComparing(new UserAgeDown());
        int rsl = nameUpAgeUp.compare(
                new User("Ivan", 26),
                new User("Fedor", 34)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void ReversewhenCompatorByNameAndProrityTwo() {
        Comparator<User> nameUpAgeUp = new UserNameDown().thenComparing(new UserAgeDown());
        int rsl = nameUpAgeUp.compare(
                new User("Fedor", 34),
                new User("Fedor", 26)
        );
        assertThat(rsl, lessThan(0));
    }
}