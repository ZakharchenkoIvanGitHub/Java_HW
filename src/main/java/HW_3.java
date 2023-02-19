/*
1. Создать новый список, добавить несколько строк с названиями цветов и вывести коллекцию на экран.
2. Итерация всех элементов списка цветов и добавления к каждому символа '!'.
3. Вставить элемент в список в первой позиции.
4. Извлечь элемент (по указанному индексу) из заданного списка.
5. Обновить определенный элемент списка по заданному индексу.
6. Удалить третий элемент из списка.
7. Поиска элемента в списке по строке.
8. Создать новый список и добавить в него несколько елементов первого списка.
9. Удалить из первого списка все элементы отсутствующие во втором списке.
10. *Сортировка списка.
11. *Сравнить время работы тысячи повторений пункта 3 для ArrayList и LinkedList.
*/

import java.util.*;

public class HW_3 {

    public static ArrayList<String> getList(int count) {
        //task_1

        String[] color = new String[]{"Красный", "Оранжевый", "Желтый", "Зеленый", "Голубой", "Синий", "Фиолетовый"};
        if (count > color.length) count = color.length;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(color[i]);
        }
        return list;
    }

    public static void addExclamation(ArrayList<String> list) {
        //task_2
        list.replaceAll(s -> s + "!");
    }

    public static void addFirstPos(List<String> list, String str) {
        //task_3
        list.add(0, str);
    }


    public static String getEl(ArrayList<String> list, int ind) {
        //task_4
        return list.get(ind);
    }

    public static void setEl(ArrayList<String> list, int ind, String str) {
        //task_5
        list.set(ind, str);
    }

    public static void delEl(ArrayList<String> list, int ind) {
        //task_6
        list.remove(ind);
    }

    public static void searchEl(ArrayList<String> list, String str) {
        //task_7
        int ind = list.indexOf(str);
        if (ind > -1) {
            System.out.printf("Нашел элемент '%s' на %d позиции\n", str, ind);
        } else {
            System.out.println("Элемент не найден");
        }
    }

    public static void removeEl(ArrayList<String> list1, ArrayList<String> list2) {
        //task_9
        list1.removeAll(list2);
    }

    public static void sortList(ArrayList<String> list) {
        //task_10
        Collections.sort(list);
    }

    public static void main(String[] args) {


        ArrayList<String> list = getList(7); // task_1
        System.out.println(list);

        addExclamation(list); // task_2

        addFirstPos(list, "Розовый");
        System.out.println(list); // task_3

        System.out.println(getEl(list, 5));// task_4

        setEl(list, 7, "Ультрафиолетовый");// task_5
        System.out.println(list);

        delEl(list, 3);// task_6
        System.out.println(list);

        searchEl(list, "Оранжевый!");// task_7

        ArrayList<String> list2 = getList(5); //task_8
        addExclamation(list2);
        System.out.println(list2);

        removeEl(list, list2);// task_9
        System.out.println(list);

        sortList(list2); //task_10
        System.out.println(list2);

        ArrayList<String> testList1 = new ArrayList<>(); //task_11
        LinkedList<String> testList2 = new LinkedList<>();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            addFirstPos(testList1, "Розовый");
        }
        long finish = System.currentTimeMillis();
        System.out.printf("Время вставки ArrayList: %d\n", finish - start);

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            addFirstPos(testList2, "Розовый");
        }
        finish = System.currentTimeMillis();
        System.out.printf("Время вставки LinkedList: %d\n", finish - start);


    }
}
