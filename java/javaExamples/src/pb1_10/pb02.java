package pb1_10;

public class pb02 {
    public static void main(String[] args) {
        int[] rotto = new int[6];
        rotto[0] = (int)(Math.random() * 45) + 1;
        System.out.print(rotto[0] + " ");
        boolean isRotto = true;
        for (int i = 1; i < 6; i++) {
            int randNum = (int)(Math.random() * 45) + 1;
            isRotto = true;
            for (int j = 0; j < i; j++) {
                if (rotto[i] == randNum) {
                    System.out.print(randNum + "(중복발생! 재추첨) ");
                    i--;
                    isRotto = false;
                    break;
                }
            }
            if (isRotto) {
                rotto[i] = randNum;
                System.out.print(randNum + " ");
            }
        }
    }
}
