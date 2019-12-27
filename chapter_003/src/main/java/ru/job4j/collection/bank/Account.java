/**
 * Пакет для тестового задания "Банковские переводы"
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection.bank;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Класс Account - класс модель данных для счёта
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 28.12.2019
 */
public class Account {

    /**
     * Содержит данные о сумме на счёте
     */
    private double wealth;
    /**
     * Содержит реквизиты счёта
     */
    private String req;

    /**
     * Конструктор класса
     *
     * @param money  - задает изначальное количество средств на счёте
     * @param adress - задаёт реквизиты счёта
     */
    public Account(double money, String adress) {
        this.wealth = money;
        this.req = adress;
    }

    /**
     * возвращает реквизиты счёта
     *
     * @return возвращает реквизиты счёта
     */
    public String getReq() {
        return req;
    }

    /**
     * Меняет количество средств на счёта, счёт не может иметь средств меньше 0
     *
     * @param wealth - на какую сумму меняется счёт, для уменьшения внесите отрицательное число
     * @return - 1 если счёт уменьшен, 0 если операция не произведена
     */
    public boolean setWealth(double wealth) {
        if (this.wealth + wealth >= 0) {
            this.wealth += wealth;
            return true;
        }
        return false;
    }

    /**
     * Переопределённый метод to String
     *
     * @return
     */
    @Override
    public String toString() {
        String otvet;
        otvet = "Account{wealth= " + wealth + " , reqs= " + req + "}";
        return otvet;
    }
}
