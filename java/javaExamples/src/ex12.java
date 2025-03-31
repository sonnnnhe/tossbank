import java.util.Random;

public class ex12 {
    public static void main(String[] args) {
        // 조건문
        // * 자바스크립트 문법과 거의 동일
        // 1. 단일 if문
        if (10 < 20) {
            System.out.println("10이 20보다 작음");
        }
        if (10 < 20) // 실행문이 한줄일 때 중괄호 생략 가능
            System.out.println("10이 20보다 작음");
        // 2. if else문
        if (10 > 20) {
            System.out.println("10 > 20");
        } else {
            System.out.println("10 <= 20");
        }

        if (10 > 20)
            System.out.println("10 > 20");
        else
            System.out.println("10 <= 20");  // ctrl + alt + l : 자동정렬
        // 3. if else if문
        int score = 90;
        if (score == 90) {
            System.out.println("90");
        } else if (score == 80) {
            System.out.println("80");
        } else {
            System.out.println("그외의 수");
        }
        // 4. 중첩 if문
        if(true) { // 조건1
            if(false) { // 조건2
                // 조건1 AND 조건2
            }
            else if(true) { //조건3
                // 조건1 AND 조건3
            }
        }

        // 자바에서 랜덤수 발생시키는 방법
        // 1. Math.random() : 0.0~0.99999...
        // 2. Random 클래스


        //연습문제
        /* 1.
         철수와 영희가 주사위 놀이를 하고 있다.
         주사위 2개를 던져서,
         두개 다 짝수가 나오면 철수 승!
         두개 다 홀수가 나오면, 영희 승!
         그외의 경우는 무승부! 이다.
         게임의 결과를 출력하시오. */
        Random rand = new Random();
        int dice1 = rand.nextInt(6) + 1;
        int dice2 = rand.nextInt(6) + 1;
        System.out.println(dice1);
        System.out.println(dice2);
        if (dice1 % 2 == 0 && dice2 % 2 == 0) {
            System.out.println("철수 승!");
        } else if (dice1 % 2 == 1 && dice2 % 2 == 1) {
            System.out.println("영희 승!");
        } else {
            System.out.println("무승부!");
        }
        System.out.println();

        //2.
        //철수와 영희을 주사위게임을 하고 있다.
        //주사위 2개를 철수가 던지고,
        //주사위 2개를 영희도 던진다.
        //게임룰 : 첫번째 주사위는 십의 자릿수로하고,
        //        두번째 주사위는 일의 자릿수로 해서,
        // 더 높은 점수를 가진 사람이 승리한다.
        //출력값 예시 :
        //        철수 주사위1 수 : 1
        //        철수 주사위2 수 : 3
        //        철수의 점수는 13
        //        영희 주사위1 수 : 3
        //        영희 주사위2 수 : 4
        //        영희의 점수는 34
        //        영희 승!
        Random random = new Random();
        int chulsu1 = random.nextInt(6) + 1;
        int chulsu2 = random.nextInt(6) + 1;
        System.out.println("철수 주사위1 수 : " + chulsu1);
        System.out.println("철수 주사위1 수 : " + chulsu2);
        int chulsuTot = chulsu1 * 10 + chulsu2;
        System.out.println("철수의 점수는 " + chulsuTot);

        int yeonghee1 = random.nextInt(6) + 1;
        int yeonghee2 = random.nextInt(6) + 1;
        System.out.println("영희 주사위1 수 : " + yeonghee1);
        System.out.println("영희 주사위1 수 : " + yeonghee2);
        int yeongheeTot = yeonghee1 * 10 + yeonghee2;
        System.out.println("영희의 점수는 " + yeongheeTot);

        if (chulsuTot > yeongheeTot) {
            System.out.println("철수 승!");
        } else if (yeongheeTot > chulsuTot) {
            System.out.println("영희 승!");
        } else {
            System.out.println("무승부!");
        }

    }
}
