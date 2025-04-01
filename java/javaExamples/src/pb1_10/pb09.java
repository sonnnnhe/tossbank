package pb1_10;

import java.util.Scanner;

public class pb09 {
    public static void main(String[] args) {
        int randNum = (int)(Math.random() * 100) + 1;

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("번호를 입력하세요.");
            int input = scanner.nextInt();

            if (input == randNum) {
                System.out.println("정답입니다.");
                break;
            } else {
                if (input > randNum) {
                    System.out.println("번호가 정답보다 큽니다.");
                } else {
                    System.out.println("번호가 정답보다 작습니다.");
                }
            }
        }
    }
}
