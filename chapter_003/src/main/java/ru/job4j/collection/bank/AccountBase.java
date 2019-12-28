/**
 * Пакет для тестового задания "Банковские переводы"
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

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
        if (getUser(srcPassport) != null && getAccount(getUser(srcPassport), srcRequisite) != null
                && getUser(destPassport) != null && getAccount(getUser(destPassport), dstRequisite) != null
                && amount > 0 && amount != 0) {
            if (getAccount(getUser(srcPassport), srcRequisite).setWealth(-1 * amount)) {
                getAccount(getUser(destPassport), dstRequisite).setWealth(amount);
                return true;
            }

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
        List<User> temp = new ArrayList<>(base.keySet());
        for (User index : temp) {
            if (index.getPassportN().equals(srcPassport)) {
                return index;
            }
        }
        return null;
    }

    /**
     * Метод возвращает счёт пользователя по рекизитам счёта
     *
     * @param user - пользователь у которого ищется счёт
     * @param reqs - реквизиты счёта для поиска
     * @return - счёт с искомыми рекизитами
     */
    private Account getAccount(User user, String reqs) {
        List<Account> temp = base.get(user);
        for (Account index : temp) {
            if (index.getReq().equals(reqs)) {
                return index;
            }
        }
        return null;
    }

}

