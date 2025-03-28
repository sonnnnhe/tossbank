import java.util.Scanner;

public class pb10 {
    public static void main(String[] args) {
        System.out.println("문자열을 입력하세요.");
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        int openCnt = 0;
        int closeCnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                openCnt++;
            } else {
                closeCnt++;
            }
        }

        System.out.println(openCnt + " " + closeCnt);
    }
}
