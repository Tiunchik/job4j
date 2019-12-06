package ru.job4j.condition;

public class SqMax {
    public static int max(int first, int second, int third, int forth) {
             /*Не понял как сделать лучше, вначал отловил все не соответствия присваемых значение, но при дальнейших
             проверках выяснил, что еcли вложенный условный оператор приходит к значению false
              то все следующие усовные операторы в коде пропускаються и мы сразу приходим к возврату значения, что не
              верно. В иотге переписал часть кода с добавление логического оператоа И
            */
        int result = forth;
        if (first > second && first > third && first > forth) {
            result = first; //изменил 3 на 1
        }

        else if (second > third && second > forth) {
            result = second; //изменил 1 на 2
        }

        else if (third > forth) {
            result = third; //изменил 2 на 3
        }
        return result;
    }
}