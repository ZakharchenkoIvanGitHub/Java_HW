/*
1. Ввод с консоли в формате Ф.И.О Возраст пол
2. Выход из режима вода по горячей кнопке
3. Вывод несортированного списка в формате Иванов И.И. 32M
4. Два варианта продолжения, либо вывод списка сортированного по возрасту либо завершение приложения.*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class HW_4 {
    public static void bubleSortAge(ArrayList<Integer> age, LinkedList<Integer> index) {
        ArrayList<Integer> ageTmp = new ArrayList<>(age);

        boolean sort = true;
        int k = ageTmp.size();
        while (sort) {
            sort = false;
            for (int i = 0; i < k - 1; i++) {
                if (ageTmp.get(i) > ageTmp.get(i + 1)) {
                    int temp = ageTmp.get(i);
                    ageTmp.set(i, ageTmp.get(i + 1));
                    ageTmp.set(i + 1, temp);

                    int temp2 = index.get(i);
                    index.set(i, index.get(i + 1));
                    index.set(i + 1, temp2);
                    sort = true;
                }
            }
            k--;
        }
    }


    public static void sortGender(ArrayList<Boolean> gender, LinkedList<Integer> index) {
        int i = 0;
        int f = index.size();
        while (i < f) {
            if (!gender.get(index.get(i))) {
                int temp = index.get(i);
                index.remove(i);
                index.add(temp);
                f--;
            }
            i++;
        }
    }

    public static void sortGender2(ArrayList<Boolean> gender, LinkedList<Integer> index) {
        LinkedList<Integer> indexM = new LinkedList<>();
        LinkedList<Integer> indexW = new LinkedList<>();

        for (int i : index) {
            if (!gender.get(index.get(i))) {
                indexW.add(index.get(i));
            } else {
                indexM.add(index.get(i));
            }
        }
        index.clear();
        index.addAll(indexM);
        index.addAll(indexW);
    }

    public static void printData(ArrayList<String> lastName,
                                 ArrayList<String> firstName,
                                 ArrayList<String> patronymic,
                                 ArrayList<Boolean> gender,
                                 ArrayList<Integer> age,
                                 LinkedList<Integer> index) {
        for (int i : index) {
            StringBuilder str = new StringBuilder();
            str.append(lastName.get(i)).
                    append(" ").
                    append(firstName.get(i).charAt(0)).
                    append(". ").
                    append(patronymic.get(i).charAt(0)).
                    append(". ").
                    append(age.get(i)).
                    append(". ").
                    append(gender.get(i) ? "М" : "Ж");
            System.out.println(str);
        }
        System.out.println("*".repeat(10));
    }

    public static void main(String[] args) {

        LinkedList<Integer> index = new LinkedList<>();
        ArrayList<String> lastName = new ArrayList<>();
        ArrayList<String> firstName = new ArrayList<>();
        ArrayList<String> patronymic = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ф.И.О Возраст пол, через прбел. Выход х");

        boolean run = true;
        while (run) {
            String in = scanner.nextLine();
            if (in.equals("x")) {
                run = false;
            } else {
                String[] data = in.split(" ");
                index.add(lastName.size());
                lastName.add(data[0]);
                firstName.add(data[1]);
                patronymic.add(data[2]);
                age.add(Integer.parseInt(data[3]));

                gender.add(data[4].contains("м"));
            }
        }

        printData(lastName, firstName, patronymic, gender, age, index);

        System.out.println("Введите s - чтобы отсортировать по возрасту, any  key - чтобы выйти.");
        String in = scanner.nextLine();
        if (in.equals("s")) {
            bubleSortAge(age, index);
            System.out.println("Данные отсортированны по возрасту:");
            printData(lastName, firstName, patronymic, gender, age, index);
            sortGender(gender, index);
            System.out.println("Дополнительная сортировка по полу:");
            printData(lastName, firstName, patronymic, gender, age, index);
        }
    }
}
