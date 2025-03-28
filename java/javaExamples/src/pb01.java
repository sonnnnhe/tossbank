import java.util.Scanner;

public class pb01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("요일을 입력하세요. 월(1) ~ 일(7)");
        int day = scanner.nextInt();

        if (day % 2 == 1) {
            System.out.println("oh my god");
        } else {
            System.out.println("enjoy");
        }
    }
}
