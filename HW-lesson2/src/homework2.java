import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class homework2 {
    public static void main(String[] args) throws IOException {
        ex1();
        System.out.println(" ");
        ex2();
        System.out.println(" ");
        ex3();
        System.out.println(" ");
        System.out.println(" ");
        ex4();
        System.out.println(" ");
        System.out.println(" ");
        int[] massiv5 = initializeMassiv5();
        ex5(massiv5);
        System.out.println(" ");
        System.out.println(" ");
        ex6(massiv5);
        System.out.println(" ");
        System.out.println(" ");

        ex7(massiv5, ex7Help());

    }

    public static void ex1() {
        int[] massiv1 = {1, 0, 0, 0, 1, 0, 1, 1};
        for (int i = 0; i < massiv1.length; i++) {
            if (massiv1[i] == 0)
                massiv1[i] = 1;
            else massiv1[i] = 0;
            System.out.print(massiv1[i] + " ");
        }

    }

    public static void ex2() {
        int[] massiv2 = new int[8];
        int count = 0;
        for (int i = 0; i < 8; i++) {
            massiv2[i] = massiv2[i] + count;
            count = count + 3;
            System.out.print(massiv2[i] + " ");
        }
    }

    public static void ex3() {
        int[] massiv3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < massiv3.length; i++) {
            if (massiv3[i] < 6)
                massiv3[i] = massiv3[i] * 6;
            System.out.print(massiv3[i] + " ");
        }
    }

    public static void ex4() {
        int[][] massiv4 = new int[10][10];
        for (int i = 0; i < massiv4.length; i++) {
            for (int j = 0; j < massiv4[i].length; j++) {
                if (i == j)
                    massiv4[i][j] = 1;
                else if (j == massiv4.length - i - 1)
                    massiv4[i][j] = 1;
                System.out.print(massiv4[i][j]);
            }
            System.out.println();
        }
    }

    public static int[] initializeMassiv5() throws IOException {
        // массив для задания 5, 6, 7. один, для удобства.
        System.out.println("Введите длинну массива:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nomber = Integer.parseInt(reader.readLine());
        System.out.println("Введите данные для заполнения массива:");
        int[] massiv5 = new int[nomber];
        for (int i = 0; i < massiv5.length; i++)
            massiv5[i] = Integer.parseInt(reader.readLine());
        return massiv5;
    }

    public static void ex5(int[] massiv5) {
        int max = massiv5[0];
        int min = massiv5[0];
        for (int i = 0; i < massiv5.length; i++) {
            if (massiv5[i] < min)
                min = massiv5[i];
            if (massiv5[i] > max)
                max = massiv5[i];
        }
        System.out.println("Максимум = " + max + ", минимум =  " + min);
    }


    public static boolean ex6(int[] massiv5) {
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int sum4 = 0;
        int i;
        if (massiv5.length % 2 == 0) {
            for (i = 0; i < massiv5.length / 2; i++) {
                sum1 = sum1 + massiv5[i];
            }
            for (i = massiv5.length / 2; i < (massiv5.length); i++) {
                sum2 = sum2 + massiv5[i];
            }
            if (sum1 == sum2) {
                System.out.println(true);
                return true;
            } else {
                System.out.println(false);
                return false;
            }
        } else {
            for (i = 0; i < (massiv5.length / 2); i++) {
                sum1 = sum1 + massiv5[i];
            }
            for (i = massiv5.length / 2; i < (massiv5.length); i++) {
                sum2 = sum2 + massiv5[i];
            }
            for (i = 0; i < (massiv5.length / 2 + 1); i++) {
                sum3 = sum3 + massiv5[i];
            }
            for (i = massiv5.length / 2 + 1; i < (massiv5.length); i++) {
                sum4 = sum4 + massiv5[i];
            }
            if (sum1 == sum2 || sum3 == sum4) {
                System.out.println(true);
                return true;
            } else {
                System.out.println(false);
                return false;
            }
        }

    }
public static int ex7Help()throws IOException{
    System.out.println("Введите, на сколько позиций сдвинуть элементы массива:");
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());
    return n;
}

    public static void ex7(int[] massiv5, int n) {
        int i = (massiv5.length-1-n);
        int p;
        n = Math.abs(n);
        int s = massiv5.length-1;

        while (s>=n){
            massiv5[s] = massiv5[i];
            s=s-1;
            i=i-1;
        }


        for (p = 0; p < n; p++) {
            massiv5[p] = 0;
        }
for (int h=0; h<massiv5.length; h++)
    System.out.print(massiv5[h] + " ");

        }
    }





