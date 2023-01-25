import java.util.Arrays;
import java.util.Random;

public class JAVAsem1HW {
    public static Integer[] append(Integer[] arr, int elem) {     // Создание метода append для java
        Integer[] array = new Integer[arr.length + 1];    // Создание и Расширение нового массива на одну ячейку при каждом вхождении
        System.arraycopy(arr, 0, array, 0, arr.length); // Копирование начиная с 0-ой позиции элементов в входящий массив
        array[arr.length] = elem;  // В созданный в этом методе массив на текущуюю позицию ставится входящий элемент
        return array;
    }
    public static void main(String[] args) {
        /* Первый семинар.
        1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
        2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
        3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
        4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2

        int i = new Random().nextInt(k); //это кидалка случайных чисел!) */

        // Нахождение случайного целого числа в диапазоне от 0 до 2000
        Random random_number = new Random();
        int i = random_number.nextInt(1001); // Тоько так смог сделать, т. к. не понял как перевести стринг в инт правильно
        System.out.println(i);


        // Перевел целое число в двоичную систему счисления
        String binary = Integer.toBinaryString(i);
        System.out.println(binary); // Вывод двоичного числа с типом стринг


        // Класс стринг в инт
        int n = Integer.parseInt(binary);
        System.out.println(n);              //  Вывод двоичного числа с типом int


        // Нахождение номера старшего бита
        int res = 0;
        while (n != 1) {
            n >>= 1;
            res++;
        }
        System.out.println(res); // Вывод старшего бита в терминал


        int countM1 = 0; // Объявление и инициализация переменной для подсчета количества кратных чисел диапазона
        int countM2 = 0;
        Integer[] m1 = new Integer[0];
        Integer[] m2 = new Integer[0];
        for ( int j = i; j < Short.MAX_VALUE; j++ ) {
            if ( j % res == 0) {
                m1 = append(m1, j);
                countM1++;
            }
            else continue;
        }

        for (int k = i; Short.MIN_VALUE < k; k-- ) {
            if (k % res == 0) continue;
            else {
                m2 = append(m2, k);
                countM2++;
            }

        }
        // Вывод данных
        System.out.printf("Number of multiples: %d;\nNumber of non-multiple numbers: %d;\n", countM1, countM2);
        System.out.println(Arrays.toString(m1));
        System.out.println(Arrays.toString(m2));
    }
}
