/**
 * Package ru.job4j.design for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.design;

import java.util.function.Predicate;

/**
 * Class HRReportEngine -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 07.03.2020
 */
public class CodersReportEngine implements Reports {

    /**
     * storage of emloyers.
     */
    private Store store;

    /**
     * Constructor, add storage of emloyers.
     *
     * @param store
     */
    public CodersReportEngine(Store store) {
        this.store = store;
    }

    /**
     * generate report accordingly requirements of Programming departament.
     *
     * @param filter filter to make list of emploers
     * @return text of report
     */
    @Override
    public String generate(Predicate<Employer> filter) {
        StringBuilder answer = new StringBuilder()
                .append("<head>").append(System.lineSeparator())
                .append("<title> Programmers report </title>").append(System.lineSeparator())
                .append("</head>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append("<table class= \"reportTable\">").append(System.lineSeparator())
                .append("<tr>").append(System.lineSeparator())
                .append("<th> Name </th>").append(System.lineSeparator())
                .append("<th> Hired </th>").append(System.lineSeparator())
                .append("<th> Fired </th>").append(System.lineSeparator())
                .append("<th> Salary </th>").append(System.lineSeparator())
                .append("</tr>").append(System.lineSeparator());
        for (var worker : store.findBy(filter)) {
            answer.append("<tr>").append(System.lineSeparator())
                    .append("<td class =\"name\"><a>").append(worker.getName()).append("</a>").append(System.lineSeparator())
                    .append("<td class =\"hired\"><a>").append(worker.getHired()).append("</a>").append(System.lineSeparator())
                    .append("<td class =\"fired\"><a>").append(worker.getFired()).append("</a>").append(System.lineSeparator())
                    .append("<td class =\"salary\"><a>").append(worker.getSalary()).append("</a>").append(System.lineSeparator())
                    .append("</tr>").append(System.lineSeparator());
        }
        return answer.toString();
    }
}
