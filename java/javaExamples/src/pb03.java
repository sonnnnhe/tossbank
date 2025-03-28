import java.util.Scanner;

public class pb03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력하세요.");
        int num = scanner.nextInt();

        for (int i = 1; i <= num; i++) {
            boolean isX = false;
            String numChar = Integer.toString(i);
            for (int j = 0; j < numChar.length(); j++) {
                if (numChar.charAt(j) == '3' || numChar.charAt(j) == '6' || numChar.charAt(j) == '9') {
                    isX = true;
                    break;
                }
            }
            if (isX) {
                System.out.print("X ");
            } else {
                System.out.print(i + " ");
            }
        }
    }
}
