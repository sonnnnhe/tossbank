package pb1_100;

import java.util.Scanner;

public class pb7_ {
    public static void main(String[] args) {
        System.out.println("7번: 정수값을 입력하세요.");
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        System.out.println(num);

        System.out.println("8번: 문자를 입력하세요.");
        scanner.nextLine();
        String c = scanner.nextLine();
        System.out.println(c);

        System.out.println("9번: 실수를 입력하세요.");
        float f = scanner.nextFloat();
        System.out.println(f);
    }
}
