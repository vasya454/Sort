import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyArrays {
    // вывод массива в консоль
    static void printArray(int[] m) {//вывод массива поэлементно в консоль
        for (int i = 0; i < m.length; i++) {
            //System.out.print(m[i]+ ((i != m.length-1) ? " " : "\n"));
            System.out.print(m[i]);
            if (i != m.length - 1)
                System.out.print(" ");
            else
                System.out.print("\n");
        }
    }

    // ввод массива из консоли
    static int[] inputArray(int n) {
        int[] m = new int[n];
        //ввод массива из консоли
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < m.length; i++) {
            System.out.println("Введите число [" + i + "]: ");
            m[i] = scanner.nextInt();
        }
        return m;
    }

    // сумма элементов массива
    static int calculateSum(int[] m) {
        int s = 0;
        for (int j : m) {
            s += j;
        }
        return s;
        // System.out.println(s);
    }

    // вывод всего массива в обратном порядке
    static int[] reverseArray(int[] m) {
        int[] r = new int[m.length];
        for (int i = 0; i < m.length; i++) {
            r[i] = m[m.length - i - 1];
        }
        return r;
    }

    // среднее арифметическое всех эл-тов
    static double averageValue(int[] m) {
        return (double) calculateSum(m) / m.length;
    }

    // максимальное значение
    static int maxValue(int[] m) {
        int maxValue = m[0];
        for (int i = 1; i < m.length; i++) {
            if (m[i] > maxValue) {
                maxValue = m[i];
            }
        }
        return maxValue;
    }

    // минимальное значение
    static int minValue(int[] m) {
        int minValue = m[0];
        for (int i = 1; i < m.length; i++) {
            if (m[i] < minValue) {
                minValue = m[i];
            }
        }
        return minValue;
    }

    // номер эл-та с минимальным значением
    // а есил их несколько???????????
    static int indexOfMin(int[] m) {
        int indexOfMin = 0;
        for (int i = 1; i < m.length; i++) {
            if (m[i] < m[i - 1]) {
                indexOfMin = i;
            }
        }
        return indexOfMin;
    }

    // разность между максимальным и минимальным эл-тами
    static int diffMaxMin(int[] m) {
        return maxValue(m) - minValue(m);
    }

    // сколько раз в массиве встречаются число х (х - аргумент функции)
    static int countOfSame(int x, int[] m) {
        int countOfSame = 0;
        for (int j : m) {
            if (x == j) {
                countOfSame++;
            }
        }
        return countOfSame;
    }

    // значение эл-та наиболее близкого к х (х - аргумент функции)
    static int[] valuesOfNearby(int x, int[] m) {
        int[] diffValues = new int[m.length];
        for (int i = 0; i < m.length; i++) {
            if (m[i] - x >= 0) {
                diffValues[i] = m[i] - x;
            } else {
                diffValues[i] = x - m[i];
            }
        }
        int minValue = minValue(diffValues);
        int countOfNearby = countOfSame(minValue(diffValues), diffValues);
        int[] valuesOfNearby = new int[countOfNearby];
        int i = 0;
        for (int j = 0; j < diffValues.length; j++) {
            if (diffValues[j] == minValue) {
                valuesOfNearby[i] = m[j];
                i++;
            }
        }
        return valuesOfNearby;
    }

    // ввод массива из файла (целочисленный тип, разделены пробелом, с подсчетом кол-ва элементов)
    static int[] inputFromFile(File file) {
        try {
            FileReader fileReader = new FileReader(file);
            Scanner scan = new Scanner(fileReader);
            int length = 0;
            while (scan.hasNext()) {
                scan.nextInt();
                length++;
            }
            fileReader.close();
            fileReader = new FileReader(file);
            scan = new Scanner(fileReader);
            int[] x = new int[length];
            for (int i = 0; i < x.length; i++) {
                x[i] = scan.nextInt();
            }
            fileReader.close();
            return x;
        } catch (Exception e) {
            System.out.println("Something wrong");
            return null;
        }
    }

    // вывод массива в файл
    static void outputInFile(int[] m, File file) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            for (int i = 0; i < m.length; i++) {
                fileWriter.write(m[i] + "");
                if (i < m.length - 1) fileWriter.write(" ");
            }
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("Something wrong");
        }
    }
}
