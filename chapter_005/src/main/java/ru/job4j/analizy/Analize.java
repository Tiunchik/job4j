/**
 * Пакет для работы с коллекциями, разаботка упрощённых аналогов коллекций
 *
 * @author -
 */
package ru.job4j.analizy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс Analize - класс содержит метод по анализу массива
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 23.01.2019
 */
public class Analize {
    /**
     * Проводит сравнение коллекции до изменения и после
     *
     * @param previous - коллекция до изменений
     * @param current  - коллекция после изменений
     * @return - объект с информацией о изменениях
     */
    public Info diff(List<User> previous, List<User> current) {
        Info temp = new Info();
        Map<Integer, User> modifCurr = current.stream().collect(Collectors.toMap(e -> e.id, e -> e));
        List<User> tempPrevious = new ArrayList<>(previous);
        tempPrevious.removeAll(modifCurr.values());
        for (var e : tempPrevious) {
            if (modifCurr.containsKey(e.id)) {
                temp.changed++;
            } else {
                temp.deleted++;
            }
        }
        temp.added = current.size() - (previous.size() - temp.deleted);
        return temp;

    }

    /**
     * Внутренний класс, по которому проводится сравнеие
     */
    public static class User {

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        int id;
        String name;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof User)) {
                return false;
            }
            User user = (User) o;
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    /**
     * внутренний класс, содержит информацию о сравнении
     */
    public static class Info {

        public Info() {
            added = 0;
            changed = 0;
            deleted = 0;
        }

        int added;
        int changed;
        int deleted;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Info)) {
                return false;
            }
            Info info = (Info) o;
            return added == info.added
                    && changed == info.changed
                    && deleted == info.deleted;
        }

        @Override
        public int hashCode() {
            return Objects.hash(added, changed, deleted);
        }
    }

}
