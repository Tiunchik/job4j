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
public class OldReportEngine implements Reports {

    /**
     * storage of emloyers.
     */
    private Store store;

    /**
     * Constructor, add storage of emloyers.
     *
     * @param store
     */
    public OldReportEngine(Store store) {
        this.store = store;
    }

    /**
     * old generate report.
     *
     * @param filter filter to make list of emploers
     * @return text of report
     */
    @Override
    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        text.append(System.lineSeparator());
        for (Employer employer : store.findBy(filter)) {
            text.append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(employer.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}