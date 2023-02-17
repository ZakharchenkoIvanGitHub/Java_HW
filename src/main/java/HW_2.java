import java.util.*;

/*
1. Напишите программу, чтобы найти вхождение в строке (содержащей все символы другой строки).
2. Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга (вхождение в обратном порядке).
3. *Напишите программу, чтобы перевернуть строку с помощью рекурсии.
4. Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().
5. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
6. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
7. *Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.
*/
public class HW_2 {

    public static void task_1() {
        /*Метод находит вхождение одной строки в другую
         **/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первую строчку");
        String str1 = scanner.nextLine();
        System.out.println("Введите вторую строчку");
        String str2 = scanner.nextLine();

        if (str1.contains(str2)) {
            System.out.printf("Строка %s входит в строку %s\n", str2, str1);
        } else {
            System.out.printf("Строка %s не входит в строку %s\n", str2, str1);
        }
    }


    public static void task_1_bonus() {
        /*Метод находит вхождение букв одной строки в другую
         **/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первую строчку");
        String str1 = scanner.nextLine();
        System.out.println("Введите вторую строчку");
        String str2 = scanner.nextLine();

        char[] str1Char = str1.toCharArray();
        Set<Character> strSet1 = new HashSet<>();
        for (char ch : str1Char)
            strSet1.add(ch);

        char[] str2Char = str2.toCharArray();
        Set<Character> strSet2 = new HashSet<>();
        for (char ch : str2Char)
            strSet2.add(ch);

        if (strSet1.containsAll(strSet2)) {
            System.out.println("Все буквы второй строки входят в первую");
        } else {
            System.out.println("Не все буквы второй строки входят в первую");
        }
    }

    public static void task_2() {
        /*Метод проверяет являются ли две данные строки вращением друг друга
         **/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первую строчку");
        String str1 = scanner.nextLine();
        System.out.println("Введите вторую строчку");
        String str2 = scanner.nextLine();

        str2 = recursRevers(str2, 0).toString();

        if (str1.contains(str2) || str2.contains(str1)) {
            System.out.println("Найдено вхождение обратной строки");
        } else {
            System.out.println("Не найдено вхождение обратной строки");
        }
    }


    public static StringBuilder recursRevers(String str, int index) {
        /*Метод рекурсивного разворота
         **/
        if (Objects.equals(str, ""))
            return new StringBuilder();
        if (index == str.length() - 1) {
            StringBuilder res = new StringBuilder();
            res.append(str.charAt(index));
            return res;
        } else
            return recursRevers(str, index + 1).append(str.charAt(index));
    }

    public static void task_3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строчку");
        String str = scanner.nextLine();
        StringBuilder revStr = recursRevers(str, 0);
        System.out.println(revStr);
    }

    public static void task_4() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число");
        int num1 = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите второе число");
        int num2 = Integer.parseInt(scanner.nextLine());

        StringBuilder res = new StringBuilder();

        res.append(num1).append(" + ").append(num2).append(" = ").append(num1 + num2);
        System.out.println(res);
        task_5(res);
        res.setLength(0);

        res.append(num1).append(" - ").append(num2).append(" = ").append(num1 - num2);
        System.out.println(res);
        task_6(res);
        res.setLength(0);

        res.append(num1).append(" * ").append(num2).append(" = ").append(num1 * num2);
        System.out.println(res);
    }

    public static void task_5(StringBuilder build) {
        int index = build.indexOf("=");
        if (index > -1) {
            build.deleteCharAt(index);
            build.insert(index, "равно");
            System.out.println(build + " (Замена из задания 5)");
        }
    }

    public static void task_6(StringBuilder build) {
        int index = build.indexOf("=");
        if (index > -1) {
            build.replace(index, index + 1, "равно");
            System.out.println(build + " (Замена из задания 6)");
        }
    }

    public static void task_7() {
        String str = "*=*".repeat(10000);
        System.out.println(str);
        long start = System.currentTimeMillis();
        str = str.replace("=", "равно");
        long finish = System.currentTimeMillis();
        System.out.println(str);
        System.out.printf("Время замены String: %d\n\n", finish - start);

        StringBuilder build = new StringBuilder("*=*".repeat(10000));
        System.out.println(build);
        int index = build.indexOf("=");
        start = System.currentTimeMillis();
        while (index > -1) {
            build.replace(index, index + 1, "равно");
            index = build.indexOf("=");
        }
        finish = System.currentTimeMillis();
        System.out.println(build);
        System.out.printf("Время замены StringBuilder: %d\n", finish - start);
    }


    public static void main(String[] args) {
        //task_1();
        //task_1_bonus();
        //task_2();
        //task_3();
        //task_4();
        task_7();
    }
}
