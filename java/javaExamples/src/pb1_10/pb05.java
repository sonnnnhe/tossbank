package pb1_10;

import java.util.Scanner;

public class pb05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int outCnt = 0;
        System.out.println("게임시작!");
        while(true) {
            n++;
            System.out.println(n + "번타자");

            int ballCnt = 0;
            int strikeCnt = 0;
            while (true) {
                int rand = (int)(Math.random() * 10) + 1;
                if (rand <= 5) {
                    System.out.println("볼~");
                    ballCnt++;
                    if (ballCnt == 4) {
                        System.out.println("1루 진루!");
                        break;
                    }
                } else {
                    System.out.println("스트라이크!");
                    strikeCnt++;
                    if (strikeCnt == 3) {
                        System.out.println("삼진 아웃!");
                        outCnt++;
                        break;
                    }
                }
            }

            if (outCnt == 3) {
                System.out.println("게임종료!");
                break;
            }
        }
    }
}
