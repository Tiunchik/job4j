/**
 * Пакет для тестового задания "Банковские переводы", работа с optional
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection.bank;

import java.util.*;

/**
 * Класс AccountBase - класс содержит методы для работы с коллекциями HashMap<User, List<Account>, а так же
 * содержит в себе самми коллекцию (композиция)
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.4
 * @since 03.01.2019
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
        if (base.containsKey(user)) {
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
        if (temp.isPresent()) {
            base.get(temp.get()).add(account); //если делать через ifPresent то не выходит сделать метод с возвращаемым значением
            // boolean - см метод deleteAccountFromUser
            return true;
        }
        return false;
    }

    /**
     * Удаляет у клиента счёт
     *
     * @param passport - счёт удаляется у клиента со следующими паспортными данными - если клиент сущевует
     * @param account  - удаляемый счёт - если счёт существует
     */
    public void deleteAccountFromUser(String passport, Account account) {
        var temp = getUser(passport);
        temp.flatMap(x -> getUserAccounts(passport))
                .ifPresent(e -> base.get(temp.get()).remove(account));
    }

    /**
     * Возвращает коллекцию счетов пользователя
     *
     * @param passport - список принадлежит клиенту со следующими паспортными данными
     * @return - список счетов пользователя
     */
    private Optional<List<Account>> getUserAccounts(String passport) {
        var temp = getUser(passport);
        return temp.map(base::get);
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
        var a1 = getAccount(srcPassport, srcRequisite);
        var a2 = getAccount(destPassport, dstRequisite);
        if (a1.isPresent() && a2.isPresent()) {
            return a1.get().transfer(a2.get(), amount);
        }
        return false;
    }

    /**
     * Метод возвращает объкт User из клиентской базы по паспортым данным
     *
     * @param srcPassport - паспортные данные для поиска
     * @return - объект User
     */
    private Optional<User> getUser(String srcPassport) {
        if (!(base.isEmpty())) {
            var temp = new ArrayList<>(base.keySet());
            return temp.stream()
                    .filter(x -> x.getPassportN().equals(srcPassport))
                    .findFirst();
        }
        return Optional.empty();
    }

    /**
     * Метод возвращает счёт пользователя по рекизитам счёта
     *
     * @param srcPassport - паспортные данные пользователя
     * @param reqs        - реквизиты счёта для поиска
     * @return - счёт с искомыми рекизитами
     */
    private Optional<Account> getAccount(String srcPassport, String reqs) {
        var temp = getUserAccounts(srcPassport);
        return temp.flatMap(accounts -> accounts.stream()
                .filter(x -> x.getReq().equals(reqs))
                .findFirst());
    }

}

