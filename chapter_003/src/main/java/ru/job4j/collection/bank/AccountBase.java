/**
 * Пакет для тестового задания "Банковские переводы"
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection.bank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс AccountBase - класс содержит методы для работы с массивом TreeMap<User, List<Account>>, а так же
 * содержит в себе самм массив (связь - композиция)
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.3
 * @since 28.12.2019
 */
public class AccountBase {
    /**
     * Массив типа Map, содежит базу данных клиентов банка
     */
    private final HashMap<User, ArrayList<Account>> base = new HashMap<>();

    /**
     * Метод добавляет клиента банка в базу данных
     *
     * @param user - клиент
     * @return - возвращает 1 если клиент добавлен и 0 если клиент уже есть в базе
     */
    public boolean addUser(User user) {
        return base.putIfAbsent(user, null) != null;
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
        var temp = getUser(passport);
        if (temp != null) {
            base.get(temp).add(account);
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
        var uTemp = getUser(passport);
        List<Account> temp = base.get(uTemp);
        if (temp.contains(account)) {
            base.get(uTemp).remove(account);
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
        var temp = getUser(passport);
        if (temp != null) {
            return base.get(temp);
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
            return temp.stream()
                    .filter(x -> x.getReq().equals(reqs))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

}

