/**
 * Тестовое задание по созданию методов в классе с параметрами и аргументами
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop;

/**
 * Класс для тестового задания по созданию методов в классе с параметрами и аргументами
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 11.12.2019
 */
public class Jukebox {
    /**
     * Пременные song используються для записи песен в объект
     */
    String song1, song2;

    /**
     * Метод music используеться для проигрывания записанных песен
     *
     * @param number - по поступающему аргументу выбирается песня ( 1 - первая, 2 - вторая)
     */
    public void music(int number) {
        if (number == 1) {
            System.out.println(song1);
        } else if (number == 2) {
            System.out.println(song2);
        } else {
            System.out.println("Песня не найдена");
        }
    }

    /**
     * метод main
     *
     * @param args - args.
     */
    public static void main(String[] args) {
        Jukebox barbox = new Jukebox();
        barbox.song1 = "Пусть бегут неуклюже,\n"
                    + "Пешеходы по лужам,\n"
                    + "А вода по асфальту рекой.\n"
                    + "И неясно прохожим,\n"
                    + "В этот день непогожий,\n"
                    + "Почему я весёлый такой.\n";
        barbox.song2 = "Спят усталые игрушки, книжки спят.\n"
                    + "Одеяла и подушки ждут ребят.\n"
                    + "Даже сказка спать ложится,\n"
                    + "Чтобы ночью нам присниться.\n"
                    + "Ты ей пожелай: «Баю-бай».\n";
        barbox.music(1);
        barbox.music(2);
        barbox.music(3);


    }
}
