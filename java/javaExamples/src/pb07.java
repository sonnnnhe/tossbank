import java.util.Scanner;

public class pb07 {
    public static void main(String[] args) {
        System.out.println("정수 n을 입력하세요");
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                sum += j;
            }
        }

        System.out.println(sum);
    }
}
