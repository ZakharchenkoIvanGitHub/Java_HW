/*
1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
Пункты реализовать в методе main
*Пункты реализовать в разных методах
 */

import java.util.Random;

public class HW_1 {


    static int getRandomInt(int k) {
        return new Random().nextInt(k); //это кидалка случайных чисел!)
    }

    static int getNumHiBit(int num) {
        String binStr = Integer.toBinaryString(num);
        System.out.printf("Число в двоичном представлении: %s\n", binStr);
        return binStr.length() - 1;
    }

    static int[] getMultiplesToMax(int start, int multi) {
        int max = Short.MAX_VALUE;
        int firstMulti = 0;
        for (int i = start; i < max + 1; i++) {
            if (i % multi == 0) {
                firstMulti = i;
                break;
            }
        }

        int[] res = new int[(max - firstMulti) / multi + 1];
        int ind = 0;
        for (int i = firstMulti; i < max + 1; i += multi) {
            res[ind] = i;
            ind++;
        }
        return res;
    }

    static int[] getNonMultiplesToMin(int finish, int multi) {
        int min = Short.MIN_VALUE;

        int[] res = new int[(finish - min + 1) - (finish - min + 1) / multi];
        int ind = 0;

        for (int i = min; i < finish + 1; i++) {
            if (i % multi != 0) {
                res[ind] = i;
                ind++;
            }
        }

        return res;
    }


    static void ptintArray(int[] arr) {
        for (int el :
                arr) {
            System.out.printf("%d ", el);

        }
        System.out.println();
    }

    public static void main(String[] args) {

        int i = getRandomInt(2000);
        System.out.printf("Сгенерированное число: %d\n", i);
        int n = getNumHiBit(i);
        System.out.printf("Номер старшего значащего бита: %d\n", n);
        int[] m1 = getMultiplesToMax(i, n);
        System.out.printf("В массиве чисел кратных %d: %d элементов\n", n, m1.length);
        //ptintArray(m1);
        int[] m2 = getNonMultiplesToMin(i, n);
        System.out.printf("В массиве чисел не кратных %d: %d элементов\n", n, m2.length);
        //ptintArray(m2);
    }
}
