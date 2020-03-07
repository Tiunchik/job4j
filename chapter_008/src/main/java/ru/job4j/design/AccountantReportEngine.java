/**
 * Package ru.job4j.design for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.design;

import java.util.function.Predicate;

/**
 * Class ReportEngine -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 07.03.2020
 */
public class AccountantReportEngine implements Reports {

    /**
     * storage of emloyers.
     */
    private Store store;

    /**
     * Constructor, add storage of emloyers.
     *
     * @param store
     */
    public AccountantReportEngine(Store store) {
        this.store = store;
    }

    /**
     * generate report accordingly requirements of Accountan departament.
     *
     * @param filter filter to make list of emploers
     * @return text of report
     */
    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        text.append(System.lineSeparator());
        for (Employer worker : store.findBy(filter)) {
            text.append(worker.getName()).append(";")
                    .append(worker.getHired()).append(";")
                    .append(worker.getFired()).append(";")
                    .append(String.format("|%10a|", worker.getSalary())).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}