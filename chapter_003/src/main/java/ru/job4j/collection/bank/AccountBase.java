/**
 * Пакет для тестового задания "Банковские переводы"
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс AccountBase - класс содержит методы для работы с массивом TreeMap<User, List<Account>>, а так же
 * содержит в себе самм массив (связь - композиция)
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 28.12.2019
 */
public class AccountBase {
    /**
     * Массив типа Map, содежит базу данных клиентов банка
     */
    private final TreeMap<User, ArrayList<Account>> base = new TreeMap<>();

    /**
     * Метод добавляет клиента банка в базу данных
     *
     * @param user - клиент
     * @return - возвращает 1 если клиент добавлен и 0 если клиент уже есть в базе
     */
    public boolean addUser(User user) {
        if (!(base.containsKey(user))) {
            base.put(user, new ArrayList<Account>());
            return true;
        }
        return false;
    }

    /**
     * Метод удаляет клиента из базы данных банка
     *
     * @param user - какого пользователя необходимо удалить
     * @return возвращает 1 если клиент удалён и 0 если клиента нет в базе
     */
    public boolean deleteUser(User user) {
        if (!(base.containsKey(user))) {
            base.remove(user);
            return true;
        }
        return false;
    }

    /**
     * Добавляет клиенту счёт
     *
     * @param passport - счёт добавляется клиенту со следующими паспортными данными
     * @param account  - добавляемый счёт
     * @return возвращает 1 если счет добавлен и 0 если нет
     */
    public boolean addAccountToUser(String passport, Account account) {
        if (getUser(passport) != null) {
            base.get(getUser(passport)).add(account);
            return true;
        }
        return false;
    }

    /**
     * Удаляет у клиента счёт
     *
     * @param passport - счёт удаляется у клиента со следующими паспортными данными
     * @param account  - удаляемый счёт
     * @return возвращает 1 если счет удалён и 0 если нет
     */
    public boolean deleteAccountFromUser(String passport, Account account) {
        List<Account> temp = base.get(getUser(passport));
        if (temp.contains(account)) {
            base.get(getUser(passport)).remove(account);
            return true;
        }
        return false;
    }

    /**
     * Возвращает коллекцию счетов пользователя
     *
     * @param passport - список принадлежит клиенту со следующими паспортными данными
     * @return - список счетов пользователя
     */
    public List<Account> getUserAccounts(String passport) {
        if (getUser(passport) != null) {
            return base.get(getUser(passport));
        }
        return null;
    }

    /**
     * Производит перевод денег между счетами пользователей/пользователя
     *
     * @param srcPassport  - паспортные данные клиента, с котороого списываются средства
     * @param srcRequisite - реквизиты счета с которого списываются средства
     * @param destPassport - паспортные данные клиенту, которому зачисляются средства
     * @param dstRequisite - реквизиты счета на который перечисляются средства
     * @param amount       - переводимые средства
     * @return - возвращает 1 если перевод осуществлён и 0 если нет
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String
            dstRequisite, double amount) {
        Account a1 = getAccount(srcPassport, srcRequisite),
                a2 = getAccount(destPassport, dstRequisite);
        if (a1 != null && a2 != null) {
            return a1.transfer(a2, amount);
        }
        return false;
    }

    /**
     * Метод возвращает объкт User из клиентской базы по паспортым данным
     *
     * @param srcPassport - паспортные данные для поиска
     * @return - объект User
     */
    private User getUser(String srcPassport) {
        if (!(base.isEmpty())) {
            List<User> temp = new ArrayList<>(base.keySet());
            return temp.stream()
                    .filter(x -> x.getPassportN().equals(srcPassport))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод возвращает счёт пользователя по рекизитам счёта
     *
     * @param srcPassport - паспортные данные пользователя
     * @param reqs        - реквизиты счёта для поиска
     * @return - счёт с искомыми рекизитами
     */
    private Account getAccount(String srcPassport, String reqs) {
        List<Account> temp = getUserAccounts(srcPassport);
        if (temp != null) {
            Stream<Account> stream = temp.stream();
            stream.filter(x -> x.getReq().equals(reqs));
            if (stream.findFirst().isPresent()) {
                Account acc = stream.findFirst().get();
            }
        }
        return null;
    }

}

