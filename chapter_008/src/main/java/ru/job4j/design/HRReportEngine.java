/**
 * Package ru.job4j.design for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.design;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Class HRReportEngine -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 07.03.2020
 */
public class HRReportEngine implements Reports {

    /**
     * storage of emloyers.
     */
    private Store store;

    /**
     * Constructor, add storage of emloyers.
     *
     * @param store
     */
    public HRReportEngine(Store store) {
        this.store = store;
    }

    /**
     * generate report accordingly requirements of HR departament.
     *
     * @param filter filter to make list of emploers
     * @return text of report
     */
    @Override
    public String generate(Predicate<Employer> filter) {
        List<Employer> temp = store.findBy(filter).stream()
                .sorted((x, y) -> Double.compare(y.getSalary(), x.getSalary()))
                .collect(Collectors.toList());
        StringBuilder answer = new StringBuilder();
        answer.append("Name; Salary;");
        answer.append(System.lineSeparator());
        for (Employer employer : temp) {
            answer.append(employer.getName()).append(";")
                    .append(employer.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return answer.toString();
    }
}
