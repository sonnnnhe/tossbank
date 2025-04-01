package pb1_10;

import java.util.Scanner;

public class pb06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("3부터 99까지의 홀수 중 하나를 입력하세요");
        int num = scanner.nextInt();
        int k = num / 2 + 1;

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
