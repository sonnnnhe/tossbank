package pb1_10;

import java.util.Arrays;
import java.util.Scanner;

public class pb08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("학생 수, 한줄에 앉을 수 있는 자리수, 학생들의 키를 입력하세요.");
        String[] inputs = scanner.nextLine().split(" ");

        int N = Integer.parseInt(inputs[0]);
        int C = Integer.parseInt(inputs[1]);
        int[] intHeights = new int[N];

        for (int i = 0; i < N; i++) {
            intHeights[i] = Integer.parseInt(inputs[i + 2]);
        }
        Arrays.sort(intHeights);

        for (int i = 1; i <= intHeights.length; i++) {
            if (i % C == 0) {
                System.out.println(intHeights[i - 1] + " ");
            } else {
                System.out.print(intHeights[i - 1] + " ");
            }
        }
    }
}
