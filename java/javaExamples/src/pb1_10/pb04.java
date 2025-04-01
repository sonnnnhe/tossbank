package pb1_10;

import java.util.Scanner;

public class pb04 {
    public static boolean game(int n) {
        boolean isX = false;
        String numString = Integer.toString(n);
        for (int j = 0; j < numString.length(); j++) {
            if (numString.charAt(j) == '3' || numString.charAt(j) == '6' || numString.charAt(j) == '9') {
                isX = true;
                break;
            }
        }
        return isX;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isX = false;

        for (int i = 1; i <= 40; i++) {
            boolean isClap = game(i);

            if (i % 2 == 1) {
                System.out.print("컴퓨터 : ");
                if (isClap) {
                    if (i == 33 || i == 39) {
                        System.out.println("XX");
                    } else {
                        System.out.println("X");
                    }
                } else {
                    System.out.println(i);
                }
            } else {
                System.out.print("나 : ");
                String myNum = scanner.nextLine();
                int num = 0;
                boolean isClap2 = game(i);
                if (!myNum.equals("X") && !myNum.equals("XX")) {
                    num = Integer.parseInt(myNum);
                }

                if (i == 40 && num == 40) {
                    System.out.println("무승부!");
                    System.out.println("게임종료");
                    break;
                }

                if (!isClap2) {
                    if (num == i) {
                        continue;
                    } else {
                        System.out.println("컴퓨터 승!");
                        System.out.println("게임종료");
                        break;
                    }
                } else {
                    if (i == 36 && myNum.equals("XX")) {
                        continue;
                    }
                    else if (i != 36 && myNum.equals("X")) {
                        continue;
                    } else {
                        System.out.println("컴퓨터 승!");
                        System.out.println("게임종료");
                        break;
                    }
                }
            }

        }
    }
}
