/**
 * Тестовое задание по созданию класса обёртки для борьбы с исключениями
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.tracker;

/**
 * Класс ValidateInput - класс обёртка для классов SubInport/ConsoleInput;
 *
 * @author -
 * @version 0.2
 * @since 18.12.2019
 */
public class ValidateInput implements Input {
    /**
     * Переменная по которой определяется как будет вести себя даный метод
     */
    private final Input input;

    /**
     * Конструктор класса
     * @param input требует объект типа Input, для опредления типа полчаемых данных
     */
    public ValidateInput(Input input) {
        this.input = input;
    }

    /**
     * Используем метод класса, который декорируем
     * @param question - данны текст выводиться в консоль, задаётся вопрос пользователю
     * @return - получаемые данные типа String
     */
    @Override
    public String askStr(String question) {
        return input.askStr(question);
    }

    /**
     * Перегруженный метод. В меотде осуществлена борьба с исключением - ввод не верного типа данных пользователм
     *
     * @param question - данны текст выводиться в консоль, задаётся вопрос пользователю
     * @return - получаемые данные типа int
     */
    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again ");
            }
        } while (invalid);
        return value;
    }

    /**
     * Перегруженный метод. В меотде осуществлена борьба с исключением - ввод некорректного значения, но верного типа
     *
     * @param question - данны текст выводиться в консоль, задаётся вопрос пользователю
     * @param max      предел допустимого значения от ользователя, от 0 до max
     * @return - получаемые данные типа int, от 0 до max
     */
    @Override
    public int askInt(String question, int max) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.askInt(question, max);
                invalid = false;
            } catch (IllegalStateException moe) {
                System.out.println("Please select key from menu ");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again ");
            }
        } while (invalid);
        return value;
    }
}
