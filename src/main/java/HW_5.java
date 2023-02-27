/*
1. Создать множество, ключь и значение строки.
2. Добавить шесть элементов.
3. Вывести в консоль значения.
4. Добавить ко всем значениям символ "!"
5. Создать второе множество с таким же обобщением. Ключи второго множества частично совпадают с ключеми первого.
6. Объеденить значания во втором множестве и первом если ключи совподают.
7. Вывести результат в консоль.*/

import java.util.HashMap;

public class HW_5 {
    public static void main(String[] args) {
        //task_1
        HashMap<String, String> hm = new HashMap<>();

        //task_2
        hm.put("Первый", "один");
        hm.put("Второй", "два");
        hm.put("Третий", "три");
        hm.put("Четвертый", "четыре");
        hm.put("Пятый", "пять");
        hm.put("Шестой", "шесть");

        //task_3
        hm.forEach((k, v) -> System.out.println(v));
        System.out.println();

        //task_4
        for (String key : hm.keySet()) {
            hm.compute(key, (k, v) ->  v + "!");
        }
        hm.forEach((k, v) -> System.out.println(v));
        System.out.println();

        //task_5
        HashMap<String, String> hm2 = new HashMap<>();
        hm2.put("Первый", "1");
        hm2.put("Второй", "2");
        hm2.put("Третий!!!", "3");
        hm2.put("Четвертый", "4");
        hm2.put("Пятый", "5");
        hm2.put("Шестой!!!", "6");


        //task_6
        for (String k : hm2.keySet()) {
            hm2.merge(k,hm.getOrDefault(k,""), String::concat);
        }

        //task_7
        for (String k : hm2.keySet()) {
            System.out.println(k + " " + hm2.get(k));
        }
    }
}
